/**
 * 
 */
package com.texas.hamburgeradmin.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * @author sande
 *
 */
@Document(collection = "menus")
@Data
public class Menu {
	@Id
	private String id;
	private String location;
	private List<MenuCategory> menuCategories;
}
