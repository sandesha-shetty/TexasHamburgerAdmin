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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.texas.hamburgeradmin.model.Location;
import com.texas.hamburgeradmin.service.ILocationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import lombok.extern.log4j.Log4j2;

/**
 * @author sandesha Shetty
 *
 */
@RestController
@RequestMapping("/api")
@Log4j2
public class LocationController {
	
	@Autowired
	ILocationService locationService;
	
	@GetMapping("/sample")
	public String getString() {
		return "Hello Man";
	}
	
	@PostMapping("/locations")
	@ApiOperation(value = "Save Location", notes = "Save Location",response=Location.class)
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No data found"),
	@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<Location> createBranch(@RequestBody @Valid Location location) {
		try {
			Location _location = locationService.createLocation(location);
			log.info("New Location created!");
			return new ResponseEntity<>(_location, HttpStatus.CREATED);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/locations")
	@ApiOperation(value = "Get all Location", notes = "Save Location",response=Location.class)
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No data found"),
	@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<List<Location>> findAllLocations(@RequestParam(required = false) String name) {
		
		log.info("Entering the controller to fetch all the locations");
		try {
			List<Location> locations = locationService.getAllLocations(name);
			return new ResponseEntity<>(locations, HttpStatus.OK);
		}catch(Exception e) {
			log.error("Error while getting branch information! {}",e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/locations/{id}")
	@ApiOperation(value = "Get Location by Id", notes = "Get Location by Id",response=Location.class)
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No data found"),
	@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<?> getLocationById(@PathVariable("id") String id) {
		
		return new ResponseEntity<>(locationService.getLocationById(id), HttpStatus.OK);
	
	}
	
	@GetMapping("/locations/status/{status}")
	public ResponseEntity<List<Location>> getByStatus(@PathVariable("status") boolean status) {
		try {
			List<Location> location = new ArrayList<>();
			locationService.getAllLocationsByStatus(status).forEach(location::add);
			return new ResponseEntity<>(location, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@PutMapping("/locations/{id}")
	@ApiOperation(value = "updates the location by id", notes = "update Location by Id",response=Location.class)
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No data found"),
	@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<?> updateLocation(@PathVariable("id") String id, @RequestBody @Valid Location location) {
		return new ResponseEntity<>(locationService.updateLocation(id, location), HttpStatus.OK);
	}

	@DeleteMapping("/locations/{id}")
	public ResponseEntity<HttpStatus> deleteLocation(@PathVariable("id") String id) {
		try {
			locationService.deleteLocation(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/locations")
	public ResponseEntity<HttpStatus> deleteAllLocations() {
		try {
			locationService.deleteAllLocations();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
