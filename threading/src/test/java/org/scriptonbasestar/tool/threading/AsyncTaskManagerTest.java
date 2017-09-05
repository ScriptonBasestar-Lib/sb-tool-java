package org.scriptonbasestar.tool.threading;

import org.scriptonbasestar.tool.threading.testres.AdderAsyncExecuteMethodsImpl;
import org.scriptonbasestar.tool.threading.testres.RequestVo;
import org.scriptonbasestar.tool.threading.testres.ResponseVo;
import org.junit.Test;

/**
 * @Author: archmagece
 * @Since: 2014-02-11 15:36
 *
 * 이거보고 쓰면 돼
 */
public class AsyncTaskManagerTest {


	AsyncTaskManager<RequestVo, ResponseVo> asyncTaskManager;
//	@Before
//	public void before(){
//		asyncTaskManager = new AsyncTaskManager(new AdderAsyncExecuteMethodsImpl());
//	}

	@Test
	public void test() throws InterruptedException {
		asyncTaskManager = new AsyncTaskManager(new AdderAsyncExecuteMethodsImpl());
		for(int i=0;i<100;i++){
			RequestVo requestVo = new RequestVo();
			asyncTaskManager.execute(requestVo);
		}
		//늦게오는친구 기다려주긔
		Thread.sleep(5000);
	}

	@Test
	public void threadAlreadyRunTest(){
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while(true){
						System.out.println("runrunrun");
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
		System.out.println(thread.isAlive());
		System.out.println(thread.isDaemon());
		System.out.println(thread.isInterrupted());
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(thread.isAlive());
		System.out.println(thread.isDaemon());
		System.out.println(thread.isInterrupted());
//		thread.start();
	}
}
