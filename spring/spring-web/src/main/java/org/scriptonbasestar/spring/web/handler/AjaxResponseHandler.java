package org.scriptonbasestar.spring.web.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author archmagece
 */
@Slf4j
public class AjaxResponseHandler
	implements HandlerMethodReturnValueHandler {

	@Override
	public boolean supportsReturnType(MethodParameter returnType) {
		return false;
	}

	@Override
	public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
		System.out.println(webRequest.getParameter("com.scriptonbasestar.request.startTime"));
//		if(returnValue instanceof AjaxResponse){AjaxResponseHandler
//			((AjaxResponse) returnValue).responseTime((long)webRequest.getAttribute("com.scriptonbasestar.request.startTime"));
//		}
	}
}
