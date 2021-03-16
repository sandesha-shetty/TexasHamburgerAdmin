/**
 * 
 */
package com.texas.hamburgeradmin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texas.hamburgeradmin.exception.MenuNotFoundException;
import com.texas.hamburgeradmin.exception.NoDataFoundException;
import com.texas.hamburgeradmin.model.Menu;
import com.texas.hamburgeradmin.repository.MenuRepository;

import lombok.extern.log4j.Log4j2;

/**
 * @author sandesha Shetty
 *
 */
@Service
@Log4j2
public class MenuService implements IMenuService{
	
	@Autowired
	 private MenuRepository menuRepository;

	@Override
	public Menu getMenuById(String id) {
		// TODO Auto-generated method stub
		return menuRepository.findById(id)
                .orElseThrow(() -> new MenuNotFoundException(id));
	}

	@Override
	public List<Menu> findAllMenus() {
		List<Menu> menus = new ArrayList<>();
		menuRepository.findAll().forEach(menus::add);
		if (menus.isEmpty()) {
			 throw new NoDataFoundException();
		}
		return menus;
	}

	@Override
	public Menu createMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuRepository.save(menu);
	}

	@Override
	public List<Menu> findByMenuType(String type) {
		// TODO Auto-generated method stub
		List<Menu> menu = menuRepository.findByType(type);
        if (menu.isEmpty()) {
           throw new NoDataFoundException();
        } else {
            return menu;
        }
	}

	@Override
	public List<Menu> findByMenuItem(String item) {
		// TODO Auto-generated method stub
		List<Menu> menu = menuRepository.findByItem(item);
        if (menu.isEmpty()) {
           throw new NoDataFoundException();
        } else {
            return menu;
        }
	}

	public List<Menu> findMenuByCategory(String category) {
		List<Menu> menu = menuRepository.findByCategory(category);
        if (menu.isEmpty()) {
           throw new NoDataFoundException();
        } else {
            return menu;
        }
	}

}
