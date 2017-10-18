package org.scriptonbasestar.spring.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * @author archmagece
 */
@Slf4j
public class ResponseTimeInterceptor implements WebRequestInterceptor {
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		request.setAttribute("com.scriptonbasestar.request.startTime", System.currentTimeMillis());
//		return true;
//	}
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//		long responseTime = System.currentTimeMillis ()-(long)request.getAttribute("com.scriptonbasestar.request.startTime");
//	}

	@Override
	public void preHandle(WebRequest request) throws Exception {
		request.setAttribute("com.scriptonbasestar.request.startTime", System.currentTimeMillis(), RequestAttributes.SCOPE_REQUEST);
	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		long responseTime = System.currentTimeMillis ()-(long)request.getAttribute("com.scriptonbasestar.request.startTime", RequestAttributes.SCOPE_REQUEST);
//		model.put("responseTime", responseTime);
	}

	@Override
	public void afterCompletion(WebRequest request, Exception ex) throws Exception {
	}
}
