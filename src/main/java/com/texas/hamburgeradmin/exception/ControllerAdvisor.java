package com.texas.hamburgeradmin.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ReservationNotFoundException.class)
	    public ResponseEntity<Object> handleReservationNotFoundException(
	    		ReservationNotFoundException ex, WebRequest request) {

	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "Reservation not found");
	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	    }
	
	@ExceptionHandler(LocationNotFoundException.class)
    public ResponseEntity<Object> handleLocationNotFoundException(
    		LocationNotFoundException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Location not found");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

	    @ExceptionHandler(NoDataFoundException.class)
	    public ResponseEntity<Object> handleNodataFoundException(
	        NoDataFoundException ex, WebRequest request) {

	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "No Data  found");
	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	    }

}
