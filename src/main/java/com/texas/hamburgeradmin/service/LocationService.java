package com.texas.hamburgeradmin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.texas.hamburgeradmin.exception.LocationNotFoundException;
import com.texas.hamburgeradmin.exception.NoDataFoundException;
import com.texas.hamburgeradmin.model.Location;
import com.texas.hamburgeradmin.repository.LocationRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class LocationService implements ILocationService {
	
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public List<Location> getAllLocations(String name) {
		List<Location> location = new ArrayList<>();
		if(name == null) {
			log.info("Fetching all the locations api called");
			locationRepository.findAll().forEach(location::add);
		}else {
			log.info("Fetching all the locations api called containing name in request param");
			locationRepository.findByNameContaining(name).forEach(location::add);
		}
		if (location.isEmpty()) {
			throw new NoDataFoundException();
		}
		return location;
	}

	@Override
	public List<Location> getAllLocationsByStatus(boolean status) {
		log.info("Fetching all the branches based on status");
		return locationRepository.findByStatus(status);
	}

	@Override
	public Location getLocationById(String id) {
		if(id==null) {
			log.error("Id cannot be null in getByLocation !");
			return null;
		}
		log.info("Fetching branch by branch id at: {}",id);
		return locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));
	}

	@Override
	public Location createLocation(Location location) {
		log.info("New Location is being created");
		return locationRepository.save(location);
	}

	@Override
	public Location updateLocation(String id, Location location) {
		Optional<Location> locationData = locationRepository.findById(id);
		
		if (locationData.isPresent()) {
			Location _location = locationData.get();
			_location.setName(location.getName());
			_location.setLatitiude(location.getLatitiude());
			_location.setLongitude(location.getLongitude());
			_location.setAddress(location.getAddress());
			_location.setPhone(_location.getPhone());
			_location.setStatus(location.getStatus());
			return locationRepository.save(_location);
		} else {
			log.info("Location with id: "+id+" not found!");
			throw new NoDataFoundException();
		}	
	}

	@Override
	public void deleteLocation(String id) {
		if(id==null) {
			log.error("id cannot be null in delete location");
			return;
		}
		log.info("Deleting the location of given id at:"+ id);
		locationRepository.deleteById(id);
		
	}

	@Override
	public void deleteAllLocations() {
		log.info("Deleting all data in location at: {}");
		locationRepository.deleteAll();
		
	}
	

}
