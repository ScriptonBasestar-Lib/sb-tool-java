package org.scriptonbasestar.tool.threading;

import lombok.Data;

import java.util.Queue;
import java.util.concurrent.*;

/**
 * @since 2014-02-11
 * @author archamgece@gmail.com
 *
 * @see IAsyncExecuteMethod 를 구현해야함
 *
 *
 * @param <Request>
 * @param <Response>
 */

public final class AsyncTaskManager<Request, Response> {

	private ExecutorService executor;
	private IAsyncExecuteMethod<Request, Response> executeMethod;

	private final Queue<RequestRetrier<Request>> requestRetriers = new ConcurrentLinkedQueue<RequestRetrier<Request>>();
	private final Queue<Response> responses = new ConcurrentLinkedQueue<Response>();

	private final int threadIdleCountLimit;
	private final int tryCountLimit;

	public AsyncTaskManager(IAsyncExecuteMethod<Request, Response> executeMethod){
		this(executeMethod, Runtime.getRuntime().availableProcessors());
	}

	public AsyncTaskManager(IAsyncExecuteMethod<Request, Response> executeMethod, int NUMBER_OF_THREAD){
		this(executeMethod, NUMBER_OF_THREAD, 10, 3);
	}

	public AsyncTaskManager(IAsyncExecuteMethod<Request, Response> executeMethod, int NUMBER_OF_THREAD, int threadIdleCountLimit, int tryCountLimit){
		this.executeMethod = executeMethod;
		this.executor = Executors.newFixedThreadPool(NUMBER_OF_THREAD);
		this.threadIdleCountLimit = threadIdleCountLimit;
		this.tryCountLimit = tryCountLimit;
	}

	/**
	 * 여기서만 사용되는 것.
	 * @param <Request>
	 */
	@Data
	private static class RequestRetrier<Request>{
		public RequestRetrier(Request request){
			this.request = request;
			this.tryCnt = 0;
		}
		private Request request;
		private int tryCnt;
	}

	/**
	 * MainRunner 여기서 실행되는 클래스
	 */
	private class MainRunner implements Callable<Response> {
		final RequestRetrier<Request> requestRetrier;
		public MainRunner(RequestRetrier<Request> requestRetrier){
			this.requestRetrier = requestRetrier;
		}
		@Override
		public Response call() {
			try{
				requestRetrier.setTryCnt(requestRetrier.getTryCnt()+1);
				return executeMethod.call(requestRetrier.getRequest());
			}catch (Exception e){
				requestRetriers.add(requestRetrier);
				return null;
			}
		}
	}

	private class FutureRunner implements Runnable{
		final Future<Response> future;
		public FutureRunner(Future<Response> future){
			this.future = future;
		}
		@Override
		public void run() {
			try {
//				Response response = this.future.access();
//				responses.add(response);
				if(this.future.isDone()){
					responses.add(this.future.get());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

	Thread thread = new Thread(new Runnable() {
		int endCount = 0;
		@Override
		public void run() {
			while(true) {
				while(!responses.isEmpty()){
					Response response = responses.remove();
					executeMethod.afterCall(response);
				}
				while(!requestRetriers.isEmpty()){
					RequestRetrier<Request> requestRetrier = requestRetriers.remove();
					if(requestRetrier == null){
						continue;
					}
					//FAIL tryCnt 3이상인 경우 실패
					if(requestRetrier.getTryCnt()<tryCountLimit){
						execute(requestRetrier);
					}
				}
				if(threadIdleCountLimit > endCount++){
//					break;
					endCount = 0;
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	});

	public void execute(Request request) {
		execute(new RequestRetrier<Request>(request));
	}

	private void execute(RequestRetrier<Request> requestRetrier) {
		//before work
		executeMethod.beforeCall(requestRetrier.getRequest());

		Future<Response> future = executor.submit(new MainRunner(requestRetrier));

		//main work
		executor.execute(new FutureRunner(future));

		//after work
		if(!thread.isAlive() || thread.isInterrupted()){
			try{
				thread.start();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
