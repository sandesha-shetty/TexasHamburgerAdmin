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

import com.texas.hamburgeradmin.model.Menu;
import com.texas.hamburgeradmin.model.Reservation;
import com.texas.hamburgeradmin.service.MenuService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

/**
 * @author sande
 *
 */
@RestController
@RequestMapping("/api")
@Log4j2
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	@GetMapping("/menus")
	@ApiOperation(value="Retrieves all menus",
	notes="Retrieves all Reservation items",
	response=Menu.class)
	public ResponseEntity<List<Menu>> listAllMenus(){
		//List<Reservation> reservations = new ArrayList<>();
		return new ResponseEntity<>(menuService.findAllMenus(), HttpStatus.OK);
	}
	
	@PostMapping("/menus")
	@ApiOperation(value="create a Menu",
	notes="provide necessary details",
	response=Reservation.class)
	public ResponseEntity<?> createMenu(@RequestBody @Valid Menu menu){
			//Reservation _reservation = reservationService.save(reservation);
			return new ResponseEntity<>(menuService.createMenu(menu), HttpStatus.OK);
	}
	
	@GetMapping("/menus/{id}")
	@ApiOperation(value="Retrieves Menus by id",
	notes="Retrieves retrieves Menus by id",
	response=Reservation.class)
	public ResponseEntity<?> getReservationById(@PathVariable("id") String id){
		return new ResponseEntity<>(menuService.getMenuById(id), HttpStatus.OK);
	}
	
	@GetMapping("/menus/{category}")
	public ResponseEntity<List<Menu>> getByCategoryName(@PathVariable("category") String category) {
		try {
			List<Menu> menu = new ArrayList<>();
			menuService.findMenuByCategory(category).forEach(menu::add);
			return new ResponseEntity<>(menu, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
