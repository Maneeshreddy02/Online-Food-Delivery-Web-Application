package com.maneesh.servlet;

import java.io.IOException;
import java.util.List;

import com.maneesh.dao.RestaurantDao;
import com.maneesh.daoimpl.RestaurantDaoImpl;
import com.maneesh.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/home")
public class RestaurantServlet  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RestaurantDaoImpl restaurantDaoImpl = new RestaurantDaoImpl();
		List<Restaurant> allRest = restaurantDaoImpl.getAllRest();
//		System.out.println(allRest);
		
		req.setAttribute("restaurants", allRest);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.jsp");
		requestDispatcher.forward(req, res);
		
	}

}
