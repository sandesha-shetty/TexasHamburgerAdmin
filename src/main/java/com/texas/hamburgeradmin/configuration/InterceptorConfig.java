/**
 * 
 */
package com.texas.hamburgeradmin.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.texas.hamburgeradmin.interceptor.ExecutionTimeInterceptor;

/**
 * @author Sandesha Shetty
 *
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer  {
	
	@Autowired
	ExecutionTimeInterceptor timeInterceptor;
	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(timeInterceptor)
		.addPathPatterns("/api/*");
	}
	
}
