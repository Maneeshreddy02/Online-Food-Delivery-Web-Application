<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.maneesh.model.Menu"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu - ManeeshFoods</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="menu.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
    <!-- Navigation Bar -->
    <nav class="navbar">
        <div class="nav-container">
            <div class="logo">
                <h1>ManeeshFoods</h1>
            </div>
            <div class="search-bar">
                <input type="text" placeholder="Search for dishes">
                <button><i class="fas fa-search"></i></button>
            </div>
            <div class="nav-links">
                <a href="home">Home</a>

                <a href="#" class="active">Menu</a>
                <a href="#"><i class="fas fa-shopping-cart"></i> Cart</a>
                <form action="login.jsp" method="post" class="login-btn" style="display: inline;">
                    <input type="submit" value="Login" style="border: none; background: none; padding: 0; margin: 0;color: white;">
                </form>
            </div>
        </div>
    </nav>

    <!-- Menu Header -->
    <div class="menu-header">
        <h1>Menu</h1>
    </div>

        <!-- Menu Grid -->
    <div class="menu-container">
        <div class="menu-grid">
        <% List<Menu> menuItems=(List<Menu>)request.getAttribute("allMenus");
            for(Menu menuItem:menuItems){ %>
            <!-- Menu Item -->
            <div class="menu-card">
                <div class="menu-image">
                    <img src="<%= menuItem.getImagePath() %>" alt="<%= menuItem.getItemName() %>">
                </div>
                <div class="menu-content">
                    <h3><%= menuItem.getItemName() %></h3>
                    <p class="menu-description"><%= menuItem.getDescription() %></p>
                    <div class="menu-price">
                        <span class="price">₹<%= menuItem.getPrice() %></span>
                        
                         <form action="cart" method="post">
                <input type="hidden" name="itemId" value="<%=menuItem.getMenuId()%>">
                <input type="hidden" name ="quantity" value="1" min="1">
                <input type="hidden" name="restaurantId" value="<%=menuItem.getRestaurantId()%>">
            
                <input type="hidden" name="action" value="add">
                
                <input class="add-to-cart-btn" type="submit" value="Add to Cart" >
                </form>
                    </div>
                </div>
                
               
            </div>
        <%}%>
        </div>
    </div> 
    
   </body>
