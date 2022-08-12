package org.spring.app.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class LCAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Registering Spring Config Classes >>>>");
		Class configClasses[] = { LoveCalculatorAppConfig.class };
		return configClasses;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Configure Mapping For Dispatcher Servlet >>>>");
		String mappingArr[] = { "/" };
		return mappingArr;

	}

}
