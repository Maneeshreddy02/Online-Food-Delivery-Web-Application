package com.maneesh.servlet;




import java.io.IOException;

import com.maneesh.daoimpl.MenuDaoImpl;
import com.maneesh.model.Cart;
import com.maneesh.model.CartItem;
import com.maneesh.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

      protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        
        String newrestid = request.getParameter("restaurantId");
        int rest = Integer.parseInt(newrestid);
        
    
    
    
    
    
//        System.out.println("someParam = " + request.getParameter("restaurantId"));

        Integer currentrestid = (Integer)session.getAttribute("restaurantId");
//        System.out.println(currentrestid);
        // if restaurantId changes, create a new cart and remove the old one
        if(cart==null || currentrestid!=rest) {
        		cart = new Cart();// create a new cart
        		session.setAttribute("cart", cart); // set the new cart in session
        		session.setAttribute("restaurantId", rest);// update the restaurantId
        	
        }
        String action = request.getParameter("action");
        if(action.equals("add")) {
        	
        	addToCart(request,  cart);
        }
        else if(action.equals("update")){
        	updateCart(request,  cart);
        }
        else if(action.equals("remove")) {
        	
        	removeFromCart(request, cart);
        }
        else if(action.equals("clear")) {
        	clearCart(request, response, cart);
        }
        session.setAttribute("cart", cart);
        response.sendRedirect("cart.jsp");
    }
        
   
    private void addToCart(HttpServletRequest request, Cart cart) 
            throws IOException {
        try {
            int itemId = Integer.parseInt(request.getParameter("itemId"));
//            String name = request.getParameter("name");
//            double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
            Menu menuById = menuDaoImpl.getMenuById(itemId);
//            System.out.println("menu in cart servlet"+menuById);
            if(menuById!=null) {
            CartItem item = new CartItem(
            menuById.getMenuId(),
            menuById.getRestaurantId(),
            menuById.getItemName(),
            quantity,
            menuById.getPrice()
            );
            cart.addCartItem(item);
            
         }
            
            } catch (NumberFormatException e) {
           
        }
    }

    private void updateCart(HttpServletRequest request, Cart cart) 
            throws IOException {
        try {
            int itemId = Integer.parseInt(request.getParameter("itemId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

           
            cart.updateCartItem(itemId, quantity);
            
        } catch (NumberFormatException e) {
        	
        }
           
    }

    private void removeFromCart(HttpServletRequest request, Cart cart) 
            throws IOException {
        try {
            int itemId = Integer.parseInt(request.getParameter("itemId"));
           
            cart.removeCartItem(itemId);
           
        } catch (NumberFormatException e) {
           
        }
    }


    private void clearCart(HttpServletRequest request, HttpServletResponse response, Cart cart) 
            throws IOException {
        cart.getItems().clear();
        response.sendRedirect(request.getContextPath() + "/cart");
    }
} 
