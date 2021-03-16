/**
 * 
 */
package com.texas.hamburgeradmin.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.log4j.Log4j2;

/**
 * @author sande
 *
 */
@Configuration
@EnableWebSecurity
@Log4j2
public class APIWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	
//	@Autowired
//	private APIBasicAuthenticationEntryPoint authenticationEntryPoint;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authencationManager) throws Exception{
		log.info("Entering the authentication manager");
		authencationManager.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("select username,password,enabled from users where username=?")
		.authoritiesByUsernameQuery("select username,authority from authorities where username=?");
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("Only authorized user is allowed inside the application");
		String api = "/api/**";
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers(api).hasRole("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}
}
