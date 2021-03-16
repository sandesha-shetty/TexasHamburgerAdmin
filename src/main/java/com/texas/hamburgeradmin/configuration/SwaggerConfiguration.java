/**
 * 
 */
package com.texas.hamburgeradmin.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author sandesha Shetty
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiDetails())
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.texas.hamburgeradmin.controller"))
				.build();
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				" Texas Hamburger restaurant admin API",
				"With CRUD  API ",
				"Version 1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Sandesha Shetty", "", "sandesha.shetty17@gmail.com"),
				"API License",
				"http://google.com",
				Collections.emptyList());
	}
}

