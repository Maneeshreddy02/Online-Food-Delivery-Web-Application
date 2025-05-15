package com.maneesh.dao;

import java.util.List;

import com.maneesh.model.Restaurant;
public interface RestaurantDao {
	int insertRestaurant(Restaurant rest);
	List<Restaurant> getAllRest();
	Restaurant getRestById(int restaurantId);
	int delete(int restaurantId);
	int updateRestById(Restaurant rest);
	

}
