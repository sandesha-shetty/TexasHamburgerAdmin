/**
 * 
 */
package com.texas.hamburgeradmin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.texas.hamburgeradmin.model.Reservation;
import com.texas.hamburgeradmin.service.ReservationService;

import io.swagger.annotations.ApiOperation;

/**
 * @author sandesha shetty
 *
 */
@RestController
@RequestMapping("/api")
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	
	@GetMapping("/reservations")
	@ApiOperation(value="Retrieves all reservations",
	notes="Retrieves all Reservation items",
	response=Reservation.class)
	public ResponseEntity<List<Reservation>> getAllReservations(){
		//List<Reservation> reservations = new ArrayList<>();
		return new ResponseEntity<>(reservationService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/reservations/{id}")
	@ApiOperation(value="Retrieves reservations by id",
	notes="Retrieves retrieves reservations by id",
	response=Reservation.class)
	public ResponseEntity<?> getReservationById(@PathVariable("id") String id){
		return new ResponseEntity<>(reservationService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping("/reservations")
	@ApiOperation(value="create a reservation",
	notes="provide necessary details",
	response=Reservation.class)
	public ResponseEntity<?> createReservation(@RequestBody @Valid Reservation reservation){
			//Reservation _reservation = reservationService.save(reservation);
			return new ResponseEntity<>(reservationService.save(reservation), HttpStatus.OK);
	
	}

}
