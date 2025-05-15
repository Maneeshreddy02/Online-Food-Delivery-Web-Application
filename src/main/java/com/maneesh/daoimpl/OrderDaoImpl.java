package com.maneesh.daoimpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.maneesh.dao.OrderDao;
import com.maneesh.model.Order;

public class OrderDaoImpl implements OrderDao {
	final static String INSERT="INSERT into `order` "
			+ "(`totalAmount`,`status`,`paymentMode`)"
			+ "values(?,?,?)";
	final static String SELECT_QUERY="SELECT * from `order` WHERE `orderId` =?";
	final static String UPDATE="UPDATE `order` SET `totalAmount`=?,`status`=?,`paymentMode`=? WHERE `orderId` =?";
	
	final static String DELETE="DELETE  from `order` WHERE `orderId` =?";
	final static String SELECT_ALL_QUERY="SELECT * from `order`";
	private static Order order = null;
	PreparedStatement prepareStatement=null;
	ArrayList<Order> userList=new ArrayList<Order>();
	

	static private  Connection connection;
	
	public OrderDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","root");

		} catch (ClassNotFoundException  | SQLException e ) {
			
			e.printStackTrace();
		}
		
		
	}
	@Override
	public int insertOrder(Order order) {
		int executeUpdate = 0;
		try {
			prepareStatement=connection.prepareStatement(INSERT);
			prepareStatement.setDouble(1, order.getTotalAmount());
			prepareStatement.setString(2, order.getStatus());
			prepareStatement.setString(3, order.getPaymentMode());
		
			
			 executeUpdate = prepareStatement.executeUpdate();
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}	
		
		
		return executeUpdate;
	}

	@Override
	public List<Order> getAllRest() {
		try {
			Statement statement = connection.createStatement();
			ResultSet executeQuery = statement.executeQuery(SELECT_ALL_QUERY);
			userList = getALlUsersFormList(executeQuery);
			for (Order order : userList) {
				System.out.println(order);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
ArrayList<Order> getALlUsersFormList(ResultSet executeQuery){
		
		try {
			while (executeQuery.next()) {
				 userList.add(new Order(executeQuery.getInt(1),executeQuery.getDouble(2),executeQuery.getString(3),
				executeQuery.getString(4)));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return userList;
	}



	@Override
	public Order getOrderById(int orderId) {
		try {
			prepareStatement=connection.prepareStatement(SELECT_QUERY);
			prepareStatement.setInt(1, orderId);
			ResultSet res = prepareStatement.executeQuery();
			
			if(res.next()) {
				int id = res.getInt(1);
				double totalAmount = res.getDouble(2);
				String status = res.getString(3);
				String paymentMode = res.getString(4);
				
				
				
				
				order = new Order( id,totalAmount, status, paymentMode);
				
				
			}
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return order;
		
	}

	@Override
	public int delete(int orderId) {
		int res=0;
		try {
			prepareStatement=connection.prepareStatement(DELETE);
			prepareStatement.setInt(1, orderId);
			res = prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int updateOrderById(Order order) {
		int executeUpdate=0;
	try {
			
			prepareStatement=connection.prepareStatement(UPDATE);
			prepareStatement.setInt(4,  order.getOrderId());
			prepareStatement.setDouble(1, order.getTotalAmount());
			prepareStatement.setString(2, order.getStatus());
			prepareStatement.setString(3, order.getPaymentMode());
		
			
			
			  executeUpdate = prepareStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return executeUpdate;
	}

}
