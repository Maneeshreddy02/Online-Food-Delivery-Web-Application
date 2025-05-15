package com.maneesh.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.maneesh.dao.OrderItemDao;
import com.maneesh.model.OrderItem;

public class OrderItemDaoImpl  implements OrderItemDao{
	final static String INSERT="INSERT into `orderitem` "
			+ "(`quantity`,`totalPrice`)"
			+ "values(?,?)";
	final static String SELECT_QUERY="SELECT * from `orderitem` WHERE `orderItemId` =?";
	final static String UPDATE="UPDATE `orderitem` SET `quantity`=?,`totalPrice`=? WHERE `orderItemId` =?";
	
	final static String DELETE="DELETE  from `orderitem` WHERE `orderItemId` =?";
	final static String SELECT_ALL_QUERY="SELECT * from `orderitem`";
	private static OrderItem orderitem = null;
	PreparedStatement prepareStatement=null;
	ArrayList<OrderItem> orderItemList=new ArrayList<OrderItem>();
	

	static private  Connection connection;
	
	public OrderItemDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","root");

		} catch (ClassNotFoundException  | SQLException e ) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public int insertOrder(OrderItem orderitem) {
		int executeUpdate = 0;
		try {
			prepareStatement=connection.prepareStatement(INSERT);
			prepareStatement.setInt(1, orderitem.getQuantity());
			prepareStatement.setDouble(2, orderitem.getTotalPrice());
		
		
			
			 executeUpdate = prepareStatement.executeUpdate();
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}	
		
		
		return executeUpdate;
	}

	

	@Override
	public List<OrderItem> getAllRest() {
		try {
			Statement statement = connection.createStatement();
			ResultSet executeQuery = statement.executeQuery(SELECT_ALL_QUERY);
			orderItemList = getALlOrderItemsFormList(executeQuery);
			for (OrderItem orderitem : orderItemList) {
				System.out.println(orderitem);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
ArrayList<OrderItem> getALlOrderItemsFormList(ResultSet executeQuery){
		
		try {
			while (executeQuery.next()) {
				orderItemList.add(new OrderItem(executeQuery.getInt(1),executeQuery.getInt(2),executeQuery.getDouble(3)));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return orderItemList;
	}

	@Override
	public OrderItem getOrderById(int orderItemId) {
		try {
			prepareStatement=connection.prepareStatement(SELECT_QUERY);
			prepareStatement.setInt(1, orderItemId);
			ResultSet res = prepareStatement.executeQuery();
			
			if(res.next()) {
				int id = res.getInt(1);
				int quantity = res.getInt(2);
				double totalPrice = res.getDouble(3);
				
				
				
				
				
				orderitem = new OrderItem( id,quantity, totalPrice);
				
				
			}
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return orderitem;
	}

	@Override
	public int delete(int orderItemId) {
		int res=0;
		try {
			prepareStatement=connection.prepareStatement(DELETE);
			prepareStatement.setInt(1, orderItemId);
			res = prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return res;
		
	}

	@Override
	public int updateOrderById(OrderItem orderitem) {
		int executeUpdate=0;
		try {
				
				prepareStatement=connection.prepareStatement(UPDATE);
				prepareStatement.setInt(3,  orderitem.getOrderItemId());
				prepareStatement.setInt(1, orderitem.getQuantity());
				prepareStatement.setDouble(2, orderitem.getTotalPrice());
			
			
				
				
				  executeUpdate = prepareStatement.executeUpdate();
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return executeUpdate;
		
	}

}
