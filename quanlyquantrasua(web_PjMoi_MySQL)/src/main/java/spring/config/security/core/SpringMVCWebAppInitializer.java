package spring.config.security.core;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import spring.config.security.ApplicationConfig;

public class SpringMVCWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { ApplicationConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
}