package com.texas.hamburgeradmin.service;

import java.util.List;

import com.texas.hamburgeradmin.model.Location;

public interface ILocationService {
	public List<Location> getAllLocations(String name);
	public List<Location> getAllLocationsByStatus(boolean status);
	public Location getLocationById(String id);
	public Location createLocation(Location location);
	public Location updateLocation(String id,Location location);
	public void deleteLocation(String id);
	public void deleteAllLocations();
}
