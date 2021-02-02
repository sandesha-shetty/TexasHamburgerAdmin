/**
 * 
 */
package com.texas.hamburgeradmin.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

/**
 * @author sande
 *
 */

@Data
public class MenuItems extends MenuSubCategory{
	@Id
	private String id;
	private String name;
	private String 	description;
	private double price;

}
