package com.maneesh.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.maneesh.dao.RestaurantDao;
import com.maneesh.model.Restaurant;


public class RestaurantDaoImpl implements RestaurantDao {
	final static String INSERT="INSERT into `restaurant` "
			+ "(`name`,`cuisineType`,`deliveryTime`,`adminUserId`,`rating`,`inactive`)"
			+ "values(?,?,?,?,?,?)";
	final static String SELECT_QUERY="SELECT * from `restaurant` WHERE `restaurantId` =?";
	final static String UPDATE="UPDATE `restaurant` SET `name`=?,`cuisineType`=?,`deliveryTime`=?,`adminUserId`=?,`rating`=?,`inactive`=?  WHERE `restaurantId` =?";
	
	final static String DELETE="DELETE  from `restaurant` WHERE `restaurantId` =?";
	final static String SELECT_ALL_QUERY="SELECT * from `restaurant`";
	PreparedStatement prepareStatement=null;
	ArrayList<Restaurant> restList=new ArrayList<Restaurant>();
	private static Restaurant rest = null;

	static private  Connection connection;
	
	public RestaurantDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","root");

		} catch (ClassNotFoundException  | SQLException e ) {
			
			e.printStackTrace();
		}
		
		
	}
	@Override
	public int insertRestaurant(Restaurant rest) {
		int executeUpdate = 0;
		try {
			prepareStatement=connection.prepareStatement(INSERT);
			//prepareStatement.setInt(1, user.getUserId());
			prepareStatement.setString(1, rest.getName());
			prepareStatement.setString(2, rest.getCuisineType());
			prepareStatement.setString(3, rest.getDeliveryTime());
			prepareStatement.setInt(4, rest.getAdminUserId());
			prepareStatement.setDouble(5, rest.getRating());
			prepareStatement.setString(6, rest.getInactive());
			
			 executeUpdate = prepareStatement.executeUpdate();
			//System.out.println(executeUpdate);
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}	
		
		
		return executeUpdate;
	}

	@Override
	public List<Restaurant> getAllRest() {
		try {
			Statement statement = connection.createStatement();
			ResultSet executeQuery = statement.executeQuery(SELECT_ALL_QUERY);
			restList = getALlUsersFormList(executeQuery);
			for (Restaurant rest : restList) {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restList;
	}
ArrayList<Restaurant> getALlUsersFormList(ResultSet executeQuery){
		
		try {
			while (executeQuery.next()) {
				 restList.add(new Restaurant(executeQuery.getInt(1),executeQuery.getString(2),executeQuery.getString(3),
				executeQuery.getString(4),executeQuery.getInt(5),executeQuery.getString(6),executeQuery.getDouble(7),executeQuery.getString(8),executeQuery.getString(9)));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return restList;
	}



	@Override
	public Restaurant getRestById(int restaurantId) {
		try {
			prepareStatement=connection.prepareStatement(SELECT_QUERY);
			prepareStatement.setInt(1, restaurantId);
			ResultSet res = prepareStatement.executeQuery();
			
			if(res.next()) {
				int id = res.getInt(1);
				String name = res.getString(2);
				String cuisineType = res.getString(3);
				String deliveryTime = res.getString(4);
				int adminUserId = res.getInt(5);
				double rating = res.getDouble(6);
				String inactive = res.getString(7);
				
				
				rest = new Restaurant( id,name, cuisineType, deliveryTime, adminUserId, rating, inactive,null);
				
				
			}
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return rest;
		
	}

	@Override
	public int delete(int restaurantId) {
		int res=0;
		try {
			prepareStatement=connection.prepareStatement(DELETE);
			prepareStatement.setInt(1, restaurantId);
			res = prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int updateRestById(Restaurant rest) {
		int executeUpdate=0;
	try {
			
			prepareStatement=connection.prepareStatement(UPDATE);
			prepareStatement.setInt(7,  rest.getRestaurantId());
			prepareStatement.setString(1, rest.getName());
			prepareStatement.setString(2, rest.getCuisineType());
			prepareStatement.setString(3, rest.getDeliveryTime());
			prepareStatement.setInt(4, rest.getAdminUserId());
			prepareStatement.setDouble(5, rest.getRating());
			prepareStatement.setString(6, rest.getInactive());
			
			
			  executeUpdate = prepareStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return executeUpdate;
	}

}
