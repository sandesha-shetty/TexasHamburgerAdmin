/**
 * 
 */
package com.texas.hamburgeradmin.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.texas.hamburgeradmin.model.Interceptor;
import com.texas.hamburgeradmin.service.InterceptorService;

import lombok.extern.log4j.Log4j2;

/**
 * @author sandesha Shetty
 *
 */
@Component
@Log4j2
public class ExecutionTimeInterceptor implements HandlerInterceptor  {
	
	@Autowired
	InterceptorService interceptorService;
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception arg3)
			throws Exception {
		
		try {
			long startTime = (Long) request.getAttribute("startTime");
	        long endTime = System.currentTimeMillis();
	        long executionTime = endTime - startTime;
			log.info("Request URL: {}", request.getRequestURL());
			log.info("Total Time Taken: {}", (endTime - startTime));
			
			SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
			Date resultDate = new Date(endTime);
				
			Interceptor interceptor = new Interceptor();
				
			interceptor.setUrlDate(sdf.format(resultDate));
			interceptor.setExecutionTime(executionTime);
			interceptor.setUrl(request.getRequestURL().toString());
			
			Interceptor _interceptor = interceptorService.storeInterceptor(interceptor);
			
			if(_interceptor == null) {
				log.error("Error while saving interceptor to DB! {}",new Throwable().getStackTrace()[0].getMethodName());
				return;
			}
		}catch(Exception e) {
			log.error("Error at the interceptor level! {}",new Throwable().getStackTrace()[0].getMethodName());
		}
		
	}


	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object object) throws Exception {
		
		long startTime = System.currentTimeMillis();
	    request.setAttribute("startTime", startTime);
	    //request.setAttribute("tenant-id",tenant.getTenantId())
		return true;
	}

}
