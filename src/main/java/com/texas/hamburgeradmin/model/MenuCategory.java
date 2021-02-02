/**
 * 
 */
package com.texas.hamburgeradmin.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Data;

/**
 * @author sandesha Shetty
 *
 */
@Data
public class MenuCategory extends Menu {
	@Id
	private String id;
	private String name;
	private List<MenuSubCategory> menuSubCategories;
}
