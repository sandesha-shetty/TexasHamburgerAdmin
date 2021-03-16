package com.texas.hamburgeradmin.service;

import java.util.List;

import com.texas.hamburgeradmin.model.Location;
import com.texas.hamburgeradmin.model.Menu;

public interface IMenuService {
	public Menu getMenuById(String id);
	public List<Menu> findAllMenus(); 
	public Menu createMenu(Menu menu);
	public  List<Menu> findByMenuType(String type);
	public  List<Menu> findByMenuItem(String item);
}
