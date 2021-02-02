/**
 * 
 */
package com.texas.hamburgeradmin.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Data;

/**
 * @author sande
 *
 */
@Data
public class MenuSubCategory extends MenuCategory{
	@Id
	private String id;
	private String name;
	private List<MenuItems> menuItems;
}
