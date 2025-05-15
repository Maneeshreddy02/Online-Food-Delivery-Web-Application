package com.maneesh.launch;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.List;

import com.maneesh.dao.RestaurantDao;
import com.maneesh.daoimpl.MenuDaoImpl;
import com.maneesh.daoimpl.RestaurantDaoImpl;
import com.maneesh.daoimpl.UserDaoimpl;
import com.maneesh.model.Restaurant;
import com.maneesh.model.User;

public class Launch {

	public static void main(String[] args) {
		User user = new User();
//		user.setUserId(1);
		user.setUserName("Man223");
		user.setPassword("123456");
		user.setEmail("Rajeshreddy67875@gmail.com");
		user.setPhone("1234544555");
//		user.setAddress("MG3");
//		user.setRole("User2");

	UserDaoimpl userDaoimpl = new UserDaoimpl();
		//    	userDaoimpl.addUser(user);
		//		User user2 = userDaoimpl.getUser(2);
		//		if(user2!=null) {
		//			
		//			System.out.println(user2);
		//		}
		//		else {
		//			System.out.println("User not found");
		//		}
		//		 userDaoimpl.getAllUsers();
		//		userDaoimpl.deleteUser(3);

//		userDaoimpl.updateUser(user);
//		Restaurant restaurant = new Restaurant("Maneesh","indian","25min",77,4.5,"active");
//		RestaurantDaoImpl restaurantDaoImpl = new RestaurantDaoImpl();
//		int insertRestaurant = restaurantDaoImpl.insertRestaurant(restaurant);
//		System.out.println(insertRestaurant);
//		restaurantDaoImpl.getAllRest();
//		Restaurant restById = restaurantDaoImpl.getRestById(1);
//		if(restById!=null) {
//			System.out.println(restById);
//		}
//		else {
//			System.out.println("Restaurant not found");
//		}
//		int delete = restaurantDaoImpl.delete(1);
//		System.out.println(delete);
//		Restaurant restaurant = new Restaurant(2,"ManeeshReddy","indian","25min",77,4.5,"active");
//		int updateRestById = restaurantDaoImpl.updateRestById(restaurant);
//		System.out.println(updateRestById);
//		MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
//		int restaurantId=2;
//		List<com.maneesh.model.Menu> allMenuByRestaurant = menuDaoImpl.getAllMenuByRestaurant(2);
//		System.out.println(allMenuByRestaurant);
//	boolean emailExists = userDaoimpl.isEmailExists("Rajeshreddy@gmail.com");
//    System.out.println(emailExists);
//	User validateUser = userDaoimpl.validateUser("maneeshreddy200@gmail.com", "1234");
//	System.out.println(validateUser);
    
////
	boolean registerUser = userDaoimpl.registerUser(user);
	System.out.println(registerUser);
    




	}

}
