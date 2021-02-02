package com.texas.hamburgeradmin.exception;


public class ReservationNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ReservationNotFoundException(String id) {

        super(String.format("Reservation with Id %s not found", id));
    }
}
