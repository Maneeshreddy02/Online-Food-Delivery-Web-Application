<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,com.maneesh.model.Restaurant"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ManeeshFoods - Food Delivery Service</title>
    <link rel="stylesheet" href="styles.css">
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
                <input type="text" placeholder="Search for food and restaurants">
                <button><i class="fas fa-search"></i></button>
            </div>
            <div class="nav-links">
                <a href="#" class="active">Home</a>
                <a href="#">Offers</a>
                <a href="#">Help</a>
                <a href="#"><i class="fas fa-shopping-cart"></i> Cart</a>
                <a href="#" class="login-btn">Login</a>
            </div>
        </div>
    </nav>

    <!-- Hero Section -->
    <section class="hero">
        <div class="hero-content">
            <h1>Delicious food delivered to your doorstep</h1>
            <p>Order from your favorite restaurants with just a few clicks</p>
            <div class="location-search">
                <input type="text" placeholder="Enter your delivery location">
                <button>Find Food</button>
            </div>
        </div>
    </section>

    
          
          
          
          
          <%
          
          List<Restaurant> restaurants=( List<Restaurant> )request.getAttribute("restaurants");
                        		
          for(Restaurant r:restaurants){
        	 
        	  
          
        	  %>
          <section class="restaurants">
          <div class="restaurant-grid">
              <!-- Restaurant 1 -->
              <div class="restaurant-card">
                  <div class="card-image">
                      <img src="<%=r.getImagePath() %>" >
                      <span class="promoted">Promoted</span>
                  </div>
                  <div class="card-content">
                      <h3><%=r.getName() %></h3>
                      <div class="rating">
                          <span class="stars"><%=r.getRating() %> ★</span>
                          <span class="reviews">(2.5k reviews)</span>
                      </div>
                      <p class="location">Connaught Place, Delhi</p>
                      <div class="cuisine">
                          <span><%=r.getCuisineType() %></span>
                          
                      </div>
                      <div class="card-footer">
                          <span class="delivery-time"><%=r.getDeliveryTime() %></span>
                          <span class="cost">₹400 for two</span>
                      </div>
                  </div>
              </div>
               </div>
        <% 
       
            }
        
          
          %>

           

           
    </section>

    <!-- Footer -->
    <footer class="footer">
        <div class="footer-content">
            <div class="footer-section">
            	<h1>ManeeshFoods</h1>
                
                <p>ManeeshFoods brings you the best food from your favorite restaurants, delivered right to your doorstep.</p>
            </div>
            <div class="footer-section">
                <h4>Quick Links</h4>
                <ul>
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Careers</a></li>
                    <li><a href="#">Team</a></li>
                </ul>
            </div>
            <div class="footer-section">
                <h4>Contact Us</h4>
                <p>Email: support@maneeshfoods.com</p>
                <p>Phone: 1800-123-4567</p>
                <div class="social-icons">
                    <a href="#"><i class="fab fa-facebook"></i></a>
                    <a href="#"><i class="fab fa-twitter"></i></a>
                    <a href="#"><i class="fab fa-instagram"></i></a>
                </div>
            </div>
            <div class="footer-section">
                <h4>Newsletter</h4>
                <div class="newsletter">
                    <input type="email" placeholder="Enter your email">
                    <button>Subscribe</button>
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            <div class="app-links">
              
            </div>
            <p>&copy; 2024 ManeeshFoods. All rights reserved.</p>
        </div>
    </footer>
</body>
</html> 