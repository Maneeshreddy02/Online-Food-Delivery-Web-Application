<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.maneesh.model.Cart" %>
<%@ page import="com.maneesh.model.CartItem" %>
<%@ page import="java.util.Map" %>
<%
    Cart cart = (Cart) session.getAttribute("cart");
	Integer restaurantId=(Integer)session.getAttribute("restaurantId");
    if (cart == null) {
        cart = new Cart();
        session.setAttribute("cart", cart);
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart - ManeeshFoods</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/cart.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
    <div class="main-container">
        <!-- Navigation Bar -->
        <nav class="navbar">
            <div class="nav-container">
                <div class="logo">
                    <h1><a href="home" style="text-decoration: none; color: inherit;">ManeeshFoods</a></h1>
                </div>
                <div class="nav-links">
                    <a href="home">Home</a>
                    <a href="home">Menu</a>
                </div>
            </div>
        </nav>

        <div class="cart-container">
            <div class="cart-header">
                <h2 class="cart-title">Your Cart</h2>
                <% if(!cart.getItems().isEmpty()) { %>
                    <form action="cart"  style="margin: 0;">
                    <input type="hidden" name="action" value="clear">
                        <button type="submit" class="remove-btn" title="Clear Cart">
                            <i class="fas fa-trash"></i> Clear Cart
                        </button>
                    </form>
                <% } %>
            </div>

            <% if(cart.getItems().isEmpty()) { %>
                <div class="empty-cart">
                    <i class="fas fa-shopping-cart"></i>
                    <h3>Your cart is empty</h3>
                    <p>Looks like you haven't added any items to your cart yet.</p>
                    <a href="home" class="continue-shopping">
                        Continue Shopping
                    </a>
                </div>
            <% } else { %>
                <div class="cart-items">
                    <% for(Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) { 
                        CartItem item = entry.getValue();
                    %>
                        <div class="cart-item">
                            <div class="item-name"><%= item.getName() %></div>
                            <div class="item-price">₹<%= String.format("%.2f", item.getPrice()) %></div>
                            <div class="quantity-control">
                                <form action="cart" method="post" style="display: flex; align-items: center; gap: 1rem;">
                                     <input type="hidden" name="action" value= "update">
                                    <input type="hidden" name="itemId" value="<%= item.getId() %>">
                                    <input type="hidden" name="restaurantId" value="<%= item.getRestaurantId() %>">
                                    <input type="hidden" name="quantity" value="<%= item.getQuantity() -1 %>" >
                                     <button class="quantity-btn" >-</button>
                                     </form>
                                     <%=item.getQuantity() %> 
                                     <form action="cart"  >
                                     <input type="hidden" name="action" value="update">
                                    <input type="hidden" name="restaurantId" value="<%= item.getRestaurantId() %>">
                                      <input type="hidden" name="itemId" value="<%= item.getId() %>">
                                    <input type="hidden" name="quantity" value="<%= item.getQuantity() +1 %>" >
                                     <button class="quantity-btn" >+</button>
                                    
                                </form>
                            </div>
                            <div class="item-total">₹<%= String.format("%.2f", item.getPrice() * item.getQuantity()) %></div>
                            <form action="cart" method="post" style="margin: 0;">
                                    <input type="hidden" name="restaurantId" value="<%= item.getRestaurantId() %>">
                                <input type="hidden" name="itemId" value="<%= item.getId() %>">
                                <input type="hidden" name="action" value="remove">
                                <button  class="remove-btn" >
                                    <i class="fas fa-trash"></i>
                                Remove</button>
                            </form>
                        </div>
                    <% } %>
                </div>

                <div class="cart-summary">
                    <div class="summary-row">
                        <span>Subtotal</span>
                        <span>₹<%= String.format("%.2f", cart.getItems().values().stream()
                            .mapToDouble(item -> item.getPrice() * item.getQuantity())
                            .sum()) %></span>
                    </div>
                    <div class="summary-row">
                        <span>Delivery Fee</span>
                        <span>₹40.00</span>
                    </div>
                    <div class="summary-row total">
                        <span>Total</span>
                        <span>₹<%= String.format("%.2f", cart.getItems().values().stream()
                            .mapToDouble(item -> item.getPrice() * item.getQuantity())
                            .sum() + 40.00) %></span>
                    </div>
                    <button class="checkout-btn">
                        Proceed to Checkout
                    </button>
                </div>
            <% } %>
        </div>
    </div>

    <script>
        function updateQuantity(button, change) {
            const input = button.parentElement.querySelector('input[name="quantity"]');
            const newValue = parseInt(input.value) + change;
            if (newValue >= 1) {
                input.value = newValue;
                input.form.submit();
            }
        }
    </script>
</body>
</html> 