/**
 * 
 */
package com.texas.hamburgeradmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texas.hamburgeradmin.model.Interceptor;
import com.texas.hamburgeradmin.repository.InterceptorRepository;

/**
 * @author sandesha shetty
 *
 */
@Service
public class InterceptorService implements IInterceptorService {

	
	@Autowired
	InterceptorRepository interceptorRepository;
	
	@Override
	public Interceptor storeInterceptor(Interceptor interceptor) {
		return interceptorRepository.save(interceptor);
	}

	@Override
	public List<Interceptor> getInterceptorByName(String urlName) {
		List<Interceptor> interceptor = interceptorRepository.findByUrlContaining(urlName);
		return (interceptor.isEmpty())?null:interceptor;
	}

	@Override
	public List<Interceptor> getInterceptorByDate(String urlDate) {
		List<Interceptor> interceptor = interceptorRepository.findByUrlDateContaining(urlDate);
		return interceptor.isEmpty()?null:interceptor;
	}

}
