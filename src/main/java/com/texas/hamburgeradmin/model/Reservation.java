/**
 * 
 */
package com.texas.hamburgeradmin.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * @author Sandesha Shetty
 *
 */
@Data
@Document(collection = "reservations")
public class Reservation {
	@Id
	private String id;
	
	@NotNull(message="Event Name is mandatory")
	@Indexed(name = "eventName" , unique= true)
	private String eventName;
	
	@NotNull(message="Email is mandatory")
	
	private String email;
	
	@NotNull(message="Date is mandatory")
	private String dateofEvent;
	
	@NotNull(message="Number of People is mandatory")
	private int numberofPeople;

}
