/**
 * 
 */
package com.texas.hamburgeradmin.exception;

/**
 * @author sande
 *
 */
public class NoDataFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public NoDataFoundException() {
		super("No data found for the EndPoint");
    }

}
