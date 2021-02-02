package com.texas.hamburgeradmin.service;

import java.util.List;

import com.texas.hamburgeradmin.model.Interceptor;


public interface IInterceptorService {
	public Interceptor storeInterceptor(Interceptor interceptor);
	public List<Interceptor> getInterceptorByName(String urlName);
	public List<Interceptor> getInterceptorByDate(String urlDate);
}

