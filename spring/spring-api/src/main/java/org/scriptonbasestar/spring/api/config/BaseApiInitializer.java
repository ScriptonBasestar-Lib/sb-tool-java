package org.scriptonbasestar.spring.api.config;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;
import java.util.Map;

public abstract class BaseApiInitializer
	extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
//		super.onStartup(servletContext);
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		System.out.println("===============================");
		System.out.println(context.getDisplayName());
		System.out.println("===============================");
		context.setConfigLocation(configLocation());
		servletContext.addListener(new ContextLoaderListener(context));

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.setAsyncSupported(true);
		dispatcher.addMapping("/");

		FilterRegistration.Dynamic fr;
//		fr = servletContext.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain"));
//		fr.addMappingForUrlPatterns(null, false, "/*");
		for (Map.Entry<String, Filter> entry : getFilters().entrySet()) {
			fr = servletContext.addFilter(entry.getKey(), entry.getValue());
			fr.addMappingForUrlPatterns(null, false, "/*");
		}

		fr = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
		fr.setInitParameter("encoding", "UTF-8");
		fr.setInitParameter("forceEncoding", "true");
		fr.addMappingForUrlPatterns(null, false, "/*");
	}

	protected abstract String configLocation();

	@Override
	protected abstract Class<?>[] getRootConfigClasses();

	@Override
	protected abstract Class<?>[] getServletConfigClasses();

	@Override
	protected abstract String[] getServletMappings();

	protected abstract Map<String, Filter> getFilters();

}
