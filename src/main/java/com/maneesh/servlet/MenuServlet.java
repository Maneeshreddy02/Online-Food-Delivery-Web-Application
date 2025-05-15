package com.maneesh.servlet;

import java.io.IOException;
import java.util.List;

import com.maneesh.daoimpl.MenuDaoImpl;
import com.maneesh.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int restaurantid = Integer.parseInt(req.getParameter("restaurantId"));
		MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
		List<Menu> allMenuByRestaurant = menuDaoImpl.getAllMenuByRestaurant(restaurantid);
		req.setAttribute("allMenus", allMenuByRestaurant);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("menu.jsp");
		requestDispatcher.forward(req, resp);
	}
}
	

	
		
	
		
	


