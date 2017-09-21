package org.scriptonbasestar.spring.api.config.root;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * @author archmagece
 * @since 2015-06-03-20
 */
@Slf4j
@Configuration
public class BaseApiRootBeanConfig {

	@Autowired
	private Environment env;

//	@Bean
//	public ResponseTimeInterceptor responseTimeInterceptor() {
//		return new ResponseTimeInterceptor();
//	}

//	@Bean
//	public AccessLogInterceptor accessLogInterceptor() {
//		return new AccessLogInterceptor();
//	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor bean = new LocaleChangeInterceptor();
		bean.setParamName("lang");
		return bean;
	}

//	@Bean
//	public AjaxResponseHandler ajaxResponseHandler() {
//		return new AjaxResponseHandler();
//	}
}
