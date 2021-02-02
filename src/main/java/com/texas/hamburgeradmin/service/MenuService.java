package com.texas.hamburgeradmin.service;



import java.awt.MenuItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.texas.hamburgeradmin.model.Menu;


@Service
public class MenuService implements IMenuService {
	
	@Override
	public Menu createMenu(MenuItem menuItem, String location, String category, String subcategory) {
		// TODO Auto-generated method stub
		return null;
	}


	



}
}
