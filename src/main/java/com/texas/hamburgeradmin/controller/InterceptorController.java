/**
 * 
 */
package com.texas.hamburgeradmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.texas.hamburgeradmin.model.Interceptor;
import com.texas.hamburgeradmin.service.InterceptorService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

/**
 * @author sandesha shetty
 *
 */
@RestController
@RequestMapping("/api")
@Log4j2
public class InterceptorController {
	
	@Autowired
	InterceptorService interceptorService;
	
	@GetMapping("/interceptors")
	@ApiOperation(value="Finds the Api Execution time details based on the name of service",
	notes="Provides the Execution time of each API called",
	response=Interceptor.class)
	public ResponseEntity<List<Interceptor>> findInterceptorByName(@RequestParam String name){
		try {
			List<Interceptor> interceptor = interceptorService.getInterceptorByName(name);
			if(interceptor.isEmpty()) {
				log.info("No content available! {}",new Throwable().getStackTrace()[0].getMethodName());
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(interceptor,HttpStatus.OK);	
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

}
