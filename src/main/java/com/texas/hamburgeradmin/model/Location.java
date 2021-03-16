/**
 * 
 */
package com.texas.hamburgeradmin.model;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * @author Sandesha Shetty
 * This is the Model for the Location Object 
 */
@Document(collection = "locations")
@Data
public class Location {
	@Id
	private String id;
	
	@NotNull(message="Name is mandatory")
	private String name;
	
	@NotNull(message="Latitude is mandatory")
	private String latitiude;
	
	@NotNull(message="Longitude is mandatory")
	private String longitude;
	
	@NotNull(message="Address is mandatory")
	private String address;
	
	@NotNull(message="Phone Number is mandatory")
	private String phone;
	
	@NotNull(message="Location Status is mandatory")
	private Boolean status;
}
