package org.scriptonbasestar.tool.threading.testres;

import org.scriptonbasestar.tool.threading.IAsyncExecuteMethod;

/**
 * @author : archmagece@gmail.com
 * @since: 2014-02-11 20:34
 */
public class AdderAsyncExecuteMethodsImpl
	implements IAsyncExecuteMethod<RequestDto, ResponseDto> {
	@Override
	public void beforeCall(RequestDto requestVo) {
		System.out.println("AdderAsyncExecuteMethodsImpl beforeCall -################# requestVo");
		System.out.println(requestVo);
	}

	@Override
	public ResponseDto call(RequestDto requestVo) {
		System.out.println("AdderAsyncExecuteMethodsImpl call -****************** RequestDto, ResponseDto");
		System.out.println(requestVo);
		ResponseDto responseVo = new ResponseDto();
		responseVo.val = requestVo.val + 1;
		System.out.println(responseVo);
		return responseVo;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void afterCall(ResponseDto responseVo) {
		System.out.println("AdderAsyncExecuteMethodsImpl afterCall -xxxxxxxxxxxxxxxxxxx responseVo");
		System.out.println(responseVo);
	}
}
