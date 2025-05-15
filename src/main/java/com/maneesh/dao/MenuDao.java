package com.maneesh.dao;

import java.util.List;

import com.maneesh.model.Menu;

public interface MenuDao {
	int insertMenu(Menu menu);
	List<Menu> getAllRest();
	Menu getMenuById(int menuId);
	List<Menu> getAllMenuByRestaurant(int restaurantId);
	int delete(int menuId);
	int updateMenuById(Menu menu);
	

}
