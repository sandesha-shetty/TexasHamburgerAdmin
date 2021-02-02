package com.texas.hamburgeradmin.service;

import java.util.List;
import java.util.Optional;

import com.texas.hamburgeradmin.model.Reservation;

public interface IReservationService {
	 Reservation  save(Reservation reservation);
	 List<Reservation> findAll();
	 Reservation findById(String id);
	 Reservation update(String id,Reservation reservation);
	 void deleteById(String id);
	 void deleteAll();
	  
}
