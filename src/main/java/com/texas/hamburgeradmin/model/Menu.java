/**
 * 
 */
package com.texas.hamburgeradmin.model;



import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * @author sandesha Shetty
 *
 */

@Document(collection = "menus")
@Data
public class Menu extends Category {
	@Id
	private String id;
	
	@NotNull(message="Menu Type  is mandatory")
	private String type;
	
	@NotNull(message="Menu Item is mandatory")
	private String item;
	
	@NotNull(message="Menu Price  is mandatory")
	private double price;
	
}
