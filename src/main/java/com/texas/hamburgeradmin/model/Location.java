/**
 * 
 */
package com.texas.hamburgeradmin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

/**
 * @author sande
 *
 */
@Document(collection = "locations")
@Data
public class Location {
	@Id
	private String id;
	private String name;
	private String latitiude;
	private String longitude;
	private String address;
	private String phone;
}
