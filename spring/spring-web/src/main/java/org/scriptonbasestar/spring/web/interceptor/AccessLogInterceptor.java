package org.scriptonbasestar.spring.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author archmagece
 */
@Slf4j
//public class AccessLogInterceptor extends HandlerInterceptorAdapter {
public class AccessLogInterceptor
	implements WebRequestInterceptor {

//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		log.info("scriptonbasestar.access.log, header: {}, param: {}", request.getHeaderNames(), request.getParameterMap());
//		return true;
//	}

	@Override
	public void preHandle(WebRequest request) throws Exception {
		Map<String, String> map = new HashMap<>();
		Iterator<String> itr = request.getHeaderNames();
		String key;
		while (itr.hasNext()) {
			key = itr.next();
			map.put(key, request.getHeader(key));
		}
		log.debug("web access log, header: {}, param: {}", request.getHeaderNames(), request.getParameterMap());
	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
	}

	@Override
	public void afterCompletion(WebRequest request, Exception ex) throws Exception {
	}
}
