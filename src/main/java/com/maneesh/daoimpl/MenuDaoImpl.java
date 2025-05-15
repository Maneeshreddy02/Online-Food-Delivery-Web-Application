package com.maneesh.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.maneesh.dao.MenuDao;

import com.maneesh.model.Menu;



public class MenuDaoImpl implements MenuDao {
	final static String INSERT="INSERT into `menu` "
			+ "(`itemName`,`description`,`price`,`isAvailable`)"
			+ "values(?,?,?,?)";
	final static String SELECT_QUERY="SELECT * from `menu` WHERE `menuId` =?";
	final static String UPDATE="UPDATE `menu` SET `itemName`=?,`description`=?,`price`=?,`isAvailable`=?, WHERE `menuId` =?";
	final static String SELECT_QUERY2="SELECT * from `menu` WHERE `restaurantID`=?";
	final static String DELETE="DELETE  from `menu` WHERE `menuId` =?";
	final static String SELECT_ALL_QUERY="SELECT * from `menu`";
	private static Menu menu = null;
	PreparedStatement prepareStatement=null;
	ArrayList<Menu> userList=new ArrayList<Menu>();
	

	static private  Connection connection;
	
	public MenuDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","root");

		} catch (ClassNotFoundException  | SQLException e ) {
			
			e.printStackTrace();
		}
		
		
	}
	@Override
	public int insertMenu(Menu menu) {
		int executeUpdate = 0;
		try {
			prepareStatement=connection.prepareStatement(INSERT);
			prepareStatement.setString(1, menu.getItemName());
			prepareStatement.setString(2, menu.getDescription());
			prepareStatement.setDouble(3, menu.getPrice());
			prepareStatement.setString(4, menu.getIsAvailable());
			
			
			 executeUpdate = prepareStatement.executeUpdate();
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}	
		
		
		return executeUpdate;
	}

	@Override
	public List<Menu> getAllRest() {
		try {
			Statement statement = connection.createStatement();
			ResultSet executeQuery = statement.executeQuery(SELECT_ALL_QUERY);
			userList = getALlUsersFormList(executeQuery);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return  userList ;
	}
ArrayList<Menu> getALlUsersFormList(ResultSet executeQuery){
		
		try {
			while (executeQuery.next()) {
				 userList.add(new Menu(executeQuery.getInt(1),executeQuery.getInt(2),executeQuery.getString(3),executeQuery.getString(4),
				executeQuery.getDouble(5),executeQuery.getString(6),executeQuery.getString(7)));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return userList;
	}
public List<Menu> getAllMenuByRestaurant(int restaurantId){
	try {
		prepareStatement=connection.prepareStatement(SELECT_QUERY2);
		prepareStatement.setInt(1, restaurantId);
		ResultSet executeQuery = prepareStatement.executeQuery();
		userList = getALlUsersFormList(executeQuery);

	} catch (SQLException e) {
		e.printStackTrace();
	}

	
	
	
	return userList;
	
}



	@Override
	public Menu getMenuById(int menuId) {
		try {
			prepareStatement=connection.prepareStatement(SELECT_QUERY);
			prepareStatement.setInt(1, menuId);
			ResultSet res = prepareStatement.executeQuery();
			
			if(res.next()) {
				int id = res.getInt(1);
				int resid=res.getInt(2);
				String itemName = res.getString(3);
				String description = res.getString(4);
				double price = res.getDouble(5);
				String isAvailable = res.getString(6);
				
				
				
				 menu = new Menu( id,resid,itemName, description, price, isAvailable);
				
				
			}
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return menu;
		
	}
	
	
	
	

	@Override
	public int delete(int menuId) {
		int res=0;
		try {
			prepareStatement=connection.prepareStatement(DELETE);
			prepareStatement.setInt(1, menuId);
			res = prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int updateMenuById(Menu menu) {
		int executeUpdate=0;
	try {
			
			prepareStatement=connection.prepareStatement(UPDATE);
			prepareStatement.setInt(5,  menu.getMenuId());
			prepareStatement.setString(1, menu.getItemName());
			prepareStatement.setString(2, menu.getDescription());
			prepareStatement.setDouble(3, menu.getPrice());
			prepareStatement.setString(4, menu.getIsAvailable());
			
			
			  executeUpdate = prepareStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return executeUpdate;
	}

}
