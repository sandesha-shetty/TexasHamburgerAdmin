/**
 * 
 */
package com.texas.hamburgeradmin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.texas.hamburgeradmin.model.Menu;

/**
 * @author sande
 *
 */
@Repository
 public interface MenuRepository extends MongoRepository<Menu, String> {

}
