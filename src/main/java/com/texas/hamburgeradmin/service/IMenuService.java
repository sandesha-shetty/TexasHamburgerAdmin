/**
 * 
 */
package com.texas.hamburgeradmin.service;

import java.awt.MenuItem;

import com.texas.hamburgeradmin.model.Menu;

/**
 * @author sande
 *
 */
public interface IMenuService {
	public Menu createMenu(MenuItem menuItem,String location,String category, String subcategory);
}
