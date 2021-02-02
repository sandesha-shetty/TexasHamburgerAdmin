/**
 * 
 */
package com.texas.hamburgeradmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.texas.hamburgeradmin.model.Interceptor;

/**
 * @author sande
 *
 */
@Repository
public interface InterceptorRepository extends JpaRepository<Interceptor,Long>{
	List<Interceptor> findByUrlDateContaining(String urlDate);
	List<Interceptor> findByUrlContaining(String url);
}
