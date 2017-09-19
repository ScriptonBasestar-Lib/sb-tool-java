package com.scriptonbasestar.spring.web.config.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.annotation.ModelAttributeMethodProcessor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author archmagece
 * @since 2015-05-18-12
 */
@Slf4j
@EnableWebMvc
@ComponentScan(
		basePackages = {"com.scriptonbasestar.base.web"},
		includeFilters = {
				@ComponentScan.Filter(value = {Controller.class, ControllerAdvice.class}, type = FilterType.ANNOTATION)
		},
		excludeFilters = {
				@ComponentScan.Filter(value = {Configuration.class}, type = FilterType.ANNOTATION)
		}
)
@Configuration
public abstract class BaseWebServletConfig extends WebMvcConfigurerAdapter {

	protected abstract long getMultipartResolverUploadSize();

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

//	@Bean
//	public ResponseTimeInterceptor responseTimeInterceptor(){
//		return new ResponseTimeInterceptor();
//	}
//	@Bean
//	public AccessLogInterceptor accessLogInterceptor() {
//		return new AccessLogInterceptor();
//	}
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor(){
		return new LocaleChangeInterceptor();
	}

//	@Bean
//	public AjaxResponseHandler ajaxResponseHandler(){
//		return new AjaxResponseHandler();
//	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

//		registry.addWebRequestInterceptor(responseTimeInterceptor()).addPathPatterns("/action/**");
//		registry.addWebRequestInterceptor(accessLogInterceptor());
//		registry.addWebRequestInterceptor(accessLogInterceptor()).addPathPatterns("/**");
		registry.addInterceptor(localeChangeInterceptor());
//		registry.addInterceptor(localeChangeInterceptor()).addPathPatterns("/**");
	}

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
//		returnValueHandlers.add(new AjaxResponseHandler());
//		returnValueHandlers.add(modelAttributeMethodProcessor());
//		returnValueHandlers.add(ajaxResponseHandler());
	}

	@Bean
	public ModelAttributeMethodProcessor modelAttributeMethodProcessor(){
		return new ModelAttributeMethodProcessor(true);
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(modelAttributeMethodProcessor());
	}

	@Bean
	public SessionLocaleResolver sessionLocaleResolver() {
		return new SessionLocaleResolver();
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver bean = new CommonsMultipartResolver();
		bean.setMaxUploadSize(getMultipartResolverUploadSize());
		return bean;
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

	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
		MappingJackson2HttpMessageConverter bean = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JodaModule());
		bean.setObjectMapper(objectMapper);
		return bean;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
//		converters.add(stringHttpMessageConverter());
		converters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
		converters.add(mappingJackson2HttpMessageConverter());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resource/**").addResourceLocations("/resource/");
	}

	@Bean
	public ControllerClassNameHandlerMapping controllerClassNameHandlerMapping(){
		ControllerClassNameHandlerMapping bean = new ControllerClassNameHandlerMapping();
		bean.setInterceptors(new Object[]{localeChangeInterceptor()});
		return bean;
	}

	///view resolver
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		bean.setOrder(3);
		return bean;
	}

	/*
	 * ***************************************
	 *                MVC
	 * ***************************************
	 */
	@Bean
	public RequestMappingHandlerMapping handlerMapping() {
		RequestMappingHandlerMapping bean = new RequestMappingHandlerMapping();
		bean.setAlwaysUseFullPath(true);
		return bean;
	}
	//	@Bean
//	public DefaultAnnotationHandlerMapping defaultAnnotationHandlerMapping() {
//		DefaultAnnotationHandlerMapping bean = new DefaultAnnotationHandlerMapping();
//		bean.setAlwaysUseFullPath(true);
//		return bean;
//	}
//	@Bean
//	public RequestMappingHandlerMapping defaultAnnotationHandlerMapping() {
//		return new RequestMappingHandlerMapping();
//	}
	public AnnotationMethodHandlerAdapter annotationMethodHandlerAdapter(){
		AnnotationMethodHandlerAdapter bean = new AnnotationMethodHandlerAdapter();
		bean.setAlwaysUseFullPath(true);
		return bean;
	}
	public DefaultAnnotationHandlerMapping defaultAnnotationHandlerMapping(){
		DefaultAnnotationHandlerMapping bean = new DefaultAnnotationHandlerMapping();
		bean.setAlwaysUseFullPath(true);
		return bean;
	}
//	@Bean
//	public AnnotationMethodHandlerAdapter annotationMethodHandlerAdapter() {
//		AnnotationMethodHandlerAdapter bean = new AnnotationMethodHandlerAdapter();
//		bean.setAlwaysUseFullPath(true);
//		List<HttpMessageConverter> params = new ArrayList<>();
//		params.add(stringHttpMessageConverter());
////		bean.setMessageConverters();
//		return bean;
//	}
//	@Bean
//	public RequestMappingHandlerAdapter annotationMethodHandlerAdapter() {
//		return new RequestMappingHandlerAdapter();
//	}


	/*
	 * ***************************************
	 *                Tiles
	 * ***************************************
	 */
//	@Bean
//	public TilesConfigurer tilesConfigurer() {
//		TilesConfigurer bean = new TilesConfigurer();
//		bean.setDefinitions("classpath:layout/layout.xml");
//		bean.setPreparerFactoryClass(org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory.class);
//		return bean;
//	}
//
//	@Bean
//	public UrlBasedViewResolver tilesViewResolver() {
//		UrlBasedViewResolver bean = new UrlBasedViewResolver();
//		bean.setViewClass(org.springframework.web.servlet.view.tiles3.TilesView.class);
//		bean.setOrder(2);
//		return bean;
//	}
//
//	@Bean
//	public BeanNameViewResolver beanNameViewResolver() {
//		BeanNameViewResolver bean = new BeanNameViewResolver();
//		bean.setOrder(1);
//		return bean;
//	}
}
