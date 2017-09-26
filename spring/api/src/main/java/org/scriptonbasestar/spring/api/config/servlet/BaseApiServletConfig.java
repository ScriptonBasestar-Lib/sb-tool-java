package org.scriptonbasestar.spring.api.config.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.BeanNameViewResolver;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author archmagece
 * @since 2015-05-18-12
 */
@Slf4j
@EnableWebMvc
@ComponentScan(
		includeFilters = {
				@ComponentScan.Filter(value = {Controller.class, ControllerAdvice.class}, type = FilterType.ANNOTATION)
		},
		excludeFilters = {
				@ComponentScan.Filter(value = {Configuration.class}, type = FilterType.ANNOTATION)
		}
)
@Configuration
public abstract class BaseApiServletConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

//	@Autowired
//	private AccessLogInterceptor accessLogInterceptor;
	@Autowired
	private LocaleChangeInterceptor localeChangeInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor);
//		registry.addWebRequestInterceptor(accessLogInterceptor);
	}

//	@Autowired
//	private AjaxResponseHandler ajaxResponseHandler;

//	@Override
//	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
//		returnValueHandlers.add(ajaxResponseHandler);
//	}

	@Bean
	public SessionLocaleResolver sessionLocaleResolver() {
		return new SessionLocaleResolver();
	}

//	@Bean
//	StringHttpMessageConverter stringHttpMessageConverter(){
//		StringHttpMessageConverter bean = new StringHttpMessageConverter();
//		List<MediaType> params = new ArrayList<>();
////		params.add(new MediaType("text/html;charset=UTF-8"));
//		params.add(MediaType.TEXT_HTML);
//		bean.setSupportedMediaTypes(params);
//		return bean;
//	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
//		converters.add(stringHttpMessageConverter());
		converters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
		converters.add(new MappingJackson2HttpMessageConverter());
	}

	@Bean
	public RequestMappingHandlerMapping defaultAnnotationHandlerMapping() {
		RequestMappingHandlerMapping bean = new RequestMappingHandlerMapping();
		bean.setAlwaysUseFullPath(true);
		return bean;
	}
//	@Bean
//	public RequestMappingHandlerMapping defaultAnnotationHandlerMapping() {
//		return new RequestMappingHandlerMapping();
//	}

	@Bean
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver bean = new BeanNameViewResolver();
		bean.setOrder(1);
		return bean;
	}

}
