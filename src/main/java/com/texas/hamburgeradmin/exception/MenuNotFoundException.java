/**
 * 
 */
package com.texas.hamburgeradmin.exception;

/**
 * @author sande
 *
 */
public class MenuNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MenuNotFoundException(String id) {

        super(String.format("Menu with Id %s not found", id));
    }
}
