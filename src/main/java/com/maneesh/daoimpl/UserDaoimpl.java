package com.maneesh.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.maneesh.dao.UserDao;
import com.maneesh.model.User;
import com.mysql.cj.callback.UsernameCallback;

public class UserDaoimpl implements UserDao{
	final static String INSERT="INSERT into `user` "
			+ "(`userName`,`password`,`email`,`phone`,`address`,`role`)"
			+ "values(?,?,?,?,?,?)";
	final static String SELECT_QUERY="SELECT * from `user` WHERE `userId` =?";
	String UPDATE="UPDATE user SET userName=?,password=?,email=?,phone=?,address=?,role=?  WHERE userId =?";
	String query = "SELECT * FROM User WHERE email = ? AND password = ?";
	final static String SELECT_QUERY2="SELECT COUNT(*) FROM `user` WHERE `email` = ?";
	final static String INSERT2	="INSERT INTO user (userName, password,email, phone) VALUES (?, ?, ?, ?)";
	
	final static String DELETE="DELETE  from `user` WHERE `userId`=?,`password` =?";
	final static String SELECT_ALL_QUERY="SELECT * from `user`";
	PreparedStatement prepareStatement=null;
	ArrayList<User> userList=new ArrayList<User>();
	private static User user = null;
	
	
	static private  Connection connection;
	
	public UserDaoimpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","root");

		} catch (ClassNotFoundException  | SQLException e ) {
			
			e.printStackTrace();
		}
		
		
	}
	@Override
	public boolean addUser(User user) {
	      try {
			prepareStatement=connection.prepareStatement(INSERT);
			//prepareStatement.setInt(1, user.getUserId());
			prepareStatement.setString(1, user.getUserName());
			prepareStatement.setString(2, user.getPassword());
			prepareStatement.setString(3, user.getEmail());
			prepareStatement.setString(4, user.getPhone());
			prepareStatement.setString(5, user.getAddress());
			prepareStatement.setString(6, user.getRole());
			
			int executeUpdate = prepareStatement.executeUpdate();
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}
	      return false;
	}
		
		
	

	@Override
	public void updateUser(User user) {
		
		try {
			
			prepareStatement=connection.prepareStatement(UPDATE);
			prepareStatement.setInt(7,  user.getUserId());
			prepareStatement.setString(1,  user.getUserName());
			prepareStatement.setString(2,  user.getPassword());
			prepareStatement.setString(3,  user.getEmail());
			prepareStatement.setString(4,  user.getPhone());
			prepareStatement.setString(5,  user.getAddress());
			prepareStatement.setString(6,  user.getRole());
			
			
			 int executeUpdate = prepareStatement.executeUpdate();
			 System.out.println(executeUpdate);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
			
	}
	 @Override
	    public User validateUser(String email, String password) {
	 
		 try {
				prepareStatement=connection.prepareStatement(query);
				prepareStatement.setString(1, email);
				prepareStatement.setString(2,password);
				ResultSet res = prepareStatement.executeQuery();
				
				if(res.next()) {
					int id = res.getInt(1);
					String name = res.getString(2);
					String pass = res.getString(3);
					String email2 = res.getString(4);
					String  phone = res.getString(5);
					String address = res.getString(6);
					String role = res.getString(7);
					
					
					user = new User( id,name, pass, email2, phone, address, role,null,null);
					
					
				}
				
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			return user;
	    }
	

	@Override
	public void deleteUser(int userId) {
		try {
			prepareStatement=connection.prepareStatement(DELETE);
			prepareStatement.setInt(1, userId);
			int res = prepareStatement.executeUpdate();
			System.out.println(res);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public User getUser(int userId) {
		
		try {
			prepareStatement=connection.prepareStatement(SELECT_QUERY);
			prepareStatement.setInt(1, userId);
			ResultSet res = prepareStatement.executeQuery();
			
			if(res.next()) {
				int id = res.getInt(1);
				String name = res.getString(2);
				String password = res.getString(3);
				String email = res.getString(4);
				String  phone = res.getString(5);
				String address = res.getString(6);
				String role = res.getString(7);
				
				
				user = new User( id,name, password, email, phone, address, role,null,null);
				
				
			}
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		try {
			Statement statement = connection.createStatement();
			ResultSet executeQuery = statement.executeQuery(SELECT_ALL_QUERY);
			userList = getALlUsersFormList(executeQuery);
			for (User user : userList) {
				System.out.println(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return null;
	}

	
	ArrayList<User> getALlUsersFormList(ResultSet executeQuery){
		
		try {
			while (executeQuery.next()) {
				 userList.add(new User(executeQuery.getInt(1),executeQuery.getString(2),executeQuery.getString(3),
				executeQuery.getString(4),executeQuery.getString(5),executeQuery.getString(6),executeQuery.getString(7)));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return userList;
	}
	@Override
	public boolean isEmailExists(String email) {
		try {
			prepareStatement=connection.prepareStatement(SELECT_QUERY2);
			prepareStatement.setString(1, email);
			ResultSet res = prepareStatement.executeQuery();
			
			if(res.next()) {
				return res.getInt(1)>0;			
				
				
			}
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return false;
	
		
	}
	@Override
	public boolean registerUser(User user) {
	try {
			
			prepareStatement=connection.prepareStatement(INSERT2);
//		/\	prepareStatement.setInt(7,  user.getUserId());
			prepareStatement.setString(1,  user.getUserName());
			prepareStatement.setString(2,  user.getPassword());
			prepareStatement.setString(3,  user.getEmail());
			prepareStatement.setString(4,  user.getPhone());
//			prepareStatement.setString(5,  user.getAddress());
//			prepareStatement.setString(6,  user.getRole());
			
			
			 int executeUpdate = prepareStatement.executeUpdate();
			 return executeUpdate>0;
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
}
