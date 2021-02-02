package com.texas.hamburgeradmin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.texas.hamburgeradmin.model.Reservation;

@Repository
public interface ReservationRepository extends MongoRepository<Reservation, String> {

}
