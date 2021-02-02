/**
 * 
 */
package com.texas.hamburgeradmin.exception;

/**
 * @author sande
 *
 */
public class LocationNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LocationNotFoundException(String id) {

        super(String.format("Location with Id %s not found", id));
    }
}
