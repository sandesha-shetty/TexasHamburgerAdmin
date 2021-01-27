/**
 * 
 */
package com.texas.hamburgeradmin.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.texas.hamburgeradmin.model.Location;

/**
 * @author sandesha
 *
 */
@Repository
public interface LocationRepository extends MongoRepository<Location, String> {
	List<Location> findByNameContaining(String name);
}
