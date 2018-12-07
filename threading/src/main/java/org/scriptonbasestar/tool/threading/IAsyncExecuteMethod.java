package org.scriptonbasestar.tool.threading;


/**
 * @param <Request>  input object
 * @param <Response> output object
 *
 * @author archamgece@gmail.com
 * <p>
 * 본 메서드를 구현해서 @see org.beansugar.tool.threading.AsyncTaskManager 에 넣어서 사용하면 됨
 * @since 2014-02-11
 */
public interface IAsyncExecuteMethod<Request, Response> {
	void beforeCall(Request request);

	Response call(Request request);

	void afterCall(Response response);
}
