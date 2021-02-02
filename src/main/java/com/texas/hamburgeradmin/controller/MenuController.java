package com.texas.hamburgeradmin.controller;

import java.awt.MenuItem;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.texas.hamburgeradmin.model.Location;
import com.texas.hamburgeradmin.service.MenuService;


@RestController
@RequestMapping("/api")
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	@PostMapping("/menu")
	public ResponseEntity<?> createMenu(@RequestBody MenuItem menuItem,@RequestHeader("location") String location,@RequestHeader("category") String category,@RequestHeader("subcategory") String subcategory) {
//		try {
//			Optional<Location> locationData = locationService.findByName(location.getName());
//			if (locationData.isPresent()) {
//				return new ResponseEntity<>("Duplicate object", HttpStatus.METHOD_NOT_ALLOWED);
//			} else {
//				Location locationSave=locationService.saveLocation(location);
//				return new ResponseEntity<>(locationData.get(), HttpStatus.OK);
//			}
//		} catch (Exception e) {
//		
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
		menuService.createMenu(menuItem, location, category, subcategory);
		return null;
	}

}
