/**
 * 
 */
package com.texas.hamburgeradmin.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.texas.hamburgeradmin.model.Menu;

/**
 * @author sande
 *
 */
@Repository
public interface MenuRepository extends MongoRepository<Menu, String> {
	List<Menu> findByCategory(String category);
	List<Menu> findByItem(String name);
	List<Menu> findByType(String type);

}
