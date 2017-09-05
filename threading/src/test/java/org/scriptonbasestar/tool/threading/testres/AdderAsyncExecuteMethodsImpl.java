package org.scriptonbasestar.tool.threading.testres;

import org.scriptonbasestar.tool.threading.IAsyncExecuteMethod;

/**
 * @author : archmagece@gmail.com
 * @since: 2014-02-11 20:34
 * hello world, hello venus, hello alice
 */
public class AdderAsyncExecuteMethodsImpl implements IAsyncExecuteMethod<RequestVo, ResponseVo> {
	@Override
	public void beforeCall(RequestVo requestVo) {
		System.out.println("AdderAsyncExecuteMethodsImpl beforeCall -################# requestVo");
		System.out.println(requestVo);
	}

	@Override
	public ResponseVo call(RequestVo requestVo) {
		System.out.println("AdderAsyncExecuteMethodsImpl call -****************** RequestVo, ResponseVo");
		System.out.println(requestVo);
		ResponseVo responseVo = new ResponseVo();
		responseVo.val = requestVo.val+1;
		System.out.println(responseVo);
		return responseVo;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void afterCall(ResponseVo responseVo) {
		System.out.println("AdderAsyncExecuteMethodsImpl afterCall -xxxxxxxxxxxxxxxxxxx responseVo");
		System.out.println(responseVo);
	}
}
