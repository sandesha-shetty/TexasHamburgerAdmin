//package com.texas.hamburgeradmin.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import com.texas.hamburgeradmin.model.Location;
//import com.texas.hamburgeradmin.repository.LocationRepository;
//
//@Service
//public class LocationService {
//	
//	@Autowired
//	private LocationRepository locationRepository;
//	
//	public Location saveLocation(Location location) {
//			return locationRepository.save(location);
//	}
//
//	public Optional<Location> findByName(String name) {
//		// TODO Auto-generated method stub
//		return locationRepository.findByName(name);
//	}
//
//	public Iterable<Location> findAll() {
//		// TODO Auto-generated method stub
//		return locationRepository.findAll();
//	}
//
//	public Iterable<Location> findByNameContaining(String name) {
//		// TODO Auto-generated method stub
//		return locationRepository.findByNameContaining(name);
//	}
//
//	public Optional<Location> findById(String id) {
//		// TODO Auto-generated method stub
//		return locationRepository.findById(id);
//	}
//
//	public void deleteById(String id) {
//		// TODO Auto-generated method stub
//		 locationRepository.deleteById(id);
//	}
//
//	public void deleteAll() {
//		// TODO Auto-generated method stub
//		 locationRepository.deleteAll();
//	}
//
//	public Iterable<Location> findByStatus(boolean status) {
//		// TODO Auto-generated method stub
//		return  locationRepository.findByStatus(status);
//	}
//
//}
