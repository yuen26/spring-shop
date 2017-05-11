package com.yuen.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();
		bean.setBasename("classpath:messages"); 
		bean.setDefaultEncoding("UTF-8");
		return bean;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// Enable static/upload folder
		String[] CLASSPATH_RESOURCE_LOCATIONS = {"classpath:/static/upload/"};
		registry.addResourceHandler("/static/upload/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
	}
	
}
