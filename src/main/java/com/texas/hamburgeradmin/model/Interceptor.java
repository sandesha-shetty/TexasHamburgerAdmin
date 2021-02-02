/**
 * 
 */
package com.texas.hamburgeradmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

/**
 * @author sande
 *
 */

@Entity
@Data
public class Interceptor {
	
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
	
	@Column(name="executiontime")
	private long executionTime;
	
	@Column(name="url")
	private String url;
	
	@Column(name="urldates")
	private String urlDate;

}
