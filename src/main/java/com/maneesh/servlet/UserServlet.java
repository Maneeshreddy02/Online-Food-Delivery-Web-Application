package com.maneesh.servlet;

import java.io.IOException;

import com.maneesh.dao.UserDao;
import com.maneesh.daoimpl.UserDaoimpl;
import com.maneesh.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/user/*")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDAO;

    public void init() {
        userDAO = new UserDaoimpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getPathInfo();
        
        switch (action) {
            case "/login":
                login(request, response);
                break;
            case "/register":
                register(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                break;
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        try {
            User user = userDAO.validateUser(email, password);
            
          
           if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/home");
            } else {
                request.setAttribute("errorMessage", "Invalid email or password");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("errorMessage", "An error occurred during login");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String Name = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        
        try {
            if (userDAO.isEmailExists(email)) {
                request.setAttribute("errorMessage", "Email already exists");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
                return;
            }
            
            User newUser = new User();
            newUser.setUserName(Name);
            newUser.setPassword(password);
            newUser.setEmail(email);
            newUser.setPhone(phone);
            
            boolean success = userDAO.registerUser(newUser);
            
            if (success) {
                request.setAttribute("successMessage", "Registration successful! Please login.");
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            } else {
                request.setAttribute("errorMessage", "Registration failed. Please try again.");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("errorMessage", "An error occurred during registration");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
} 