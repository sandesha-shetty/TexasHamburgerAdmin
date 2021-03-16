/**
 * 
 */
package com.texas.hamburgeradmin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texas.hamburgeradmin.exception.NoDataFoundException;
import com.texas.hamburgeradmin.exception.ReservationNotFoundException;
import com.texas.hamburgeradmin.model.Reservation;
import com.texas.hamburgeradmin.repository.ReservationRepository;

/**
 * @author Sandesha Shetty
 *
 */
@Service
public class ReservationService implements IReservationService {
	
	@Autowired
	 private ReservationRepository reservationRepository;

	@Override
	public Reservation save(Reservation reservation) {
	
		return reservationRepository.save(reservation);
	}

	@Override
	public List<Reservation> findAll() {
		List<Reservation> reservations = new ArrayList<>();
		reservationRepository.findAll().forEach(reservations::add);
		if (reservations.isEmpty()) {
			 throw new NoDataFoundException();
		}
		return reservations;
	}

	@Override
	public Reservation findById(String id) {
		return reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));
	}

	@Override
	public Reservation update(String id, Reservation reservation) {
		Optional<Reservation> data = reservationRepository.findById(id);
		if (data.isPresent()) {
			Reservation _reservation = data.get();
			_reservation.setEventName(reservation.getEventName());
			_reservation.setEmail(reservation.getEmail());
			_reservation.setDateofEvent(reservation.getDateofEvent());
			_reservation.setNumberofPeople(reservation.getNumberofPeople());
			return reservationRepository.save(_reservation);
		}
		return null;
	}

	@Override
	public void deleteById(String id) {
		reservationRepository.deleteById(id);
		
	}

	@Override
	public void deleteAll() {
		reservationRepository.deleteAll();
		
	}

}
