package org.scriptonbasestar.tool.threading;


/**
 * @since 2014-02-11
 * @author archamgece@gmail.com
 *
 * 본 메서드를 구현해서 @see org.beansugar.tool.threading.AsyncTaskManager 에 넣어서 사용하면 됨
 * @param <Request> input object
 * @param <Response> output object
 */
public interface IAsyncExecuteMethod<Request, Response> {
	void beforeCall(Request request);
	Response call(Request request);
	void afterCall(Response response);
}
