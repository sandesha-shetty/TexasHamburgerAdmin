/**
 * 
 */
package com.texas.hamburgeradmin.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @author sandesha Shetty
 *
 */
@Component
public class APIBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint  {
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			org.springframework.security.core.AuthenticationException authException) throws IOException {
		 response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");
	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	}

	@Override
	public void afterPropertiesSet() {
		setRealmName("Entering hamburger production site");
		super.afterPropertiesSet();
	}

}

