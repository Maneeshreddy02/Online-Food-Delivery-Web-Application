<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - ManeeshFoods</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/login.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <style>
        :root {
            --primary-color: #fc8019;
            --primary-dark: #e67e22;
            --secondary-color: #1c1c1c;
            --text-color: #ffffff;
            --dark-bg: #121212;
            --card-bg: #1e1e1e;
            --light-gray: rgba(255, 255, 255, 0.1);
            --border-color: rgba(255, 255, 255, 0.1);
            --shadow: 0 4px 12px rgba(0, 0, 0, 0.3);
            --card-shadow: 0 8px 24px rgba(0, 0, 0, 0.4);
            --transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
            --glow: 0 0 10px rgba(252, 128, 25, 0.3);
        }
    </style>
</head>
<body>
    <div class="main-container">
        <!-- Navigation Bar -->
        <nav class="navbar">
            <div class="nav-container">
                <div class="logo">
                    <h1><a href="${pageContext.request.contextPath}/home" style="text-decoration: none; color: inherit;">ManeeshFoods</a></h1>
                </div>
                <div class="nav-links">
                    <a href="${pageContext.request.contextPath}/home">Home</a>
                    <a href="${pageContext.request.contextPath}/login.jsp">Login</a>
                </div>
            </div>
        </nav>

        <!-- Registration Form -->
        <div class="auth-container">
            <div class="auth-box">
                <h2>Create Account</h2>
                <% if(request.getAttribute("errorMessage") != null) { %>
                    <div class="error-message">
                        <%= request.getAttribute("errorMessage") %>
                    </div>
                <% } %>
                <form action="${pageContext.request.contextPath}/user/register" method="post" class="auth-form">
                    <div class="form-group">
                        <label for="fullName">Full Name</label>
                        <input type="text" id="fullName" name="fullName" required 
                               value="<%= request.getParameter("fullName") != null ? request.getParameter("fullName") : "" %>">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" id="email" name="email" required
                               value="<%= request.getParameter("email") != null ? request.getParameter("email") : "" %>">
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone Number</label>
                        <input type="tel" id="phone" name="phone" pattern="[0-9]{10}" required
                               value="<%= request.getParameter("phone") != null ? request.getParameter("phone") : "" %>">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" id="password" name="password" required>
                    </div>
                    <div class="form-group checkbox-group">
                        <input type="checkbox" id="terms" name="terms" required>
                        <label for="terms">I agree to ManeeshFoods's Terms of Service and Privacy Policy</label>
                    </div>
                    <button type="submit" class="auth-button">Create Account</button>
                </form>
                <div class="auth-divider">
                    <span>or</span>
                </div>
                <div class="social-login">
                    <button class="google-btn">
                        <i class="fab fa-google"></i> Continue with Google
                    </button>
                    <button class="facebook-btn">
                        <i class="fab fa-facebook-f"></i> Continue with Facebook
                    </button>
                </div>
                <p class="auth-switch">
                    Already have an account? <a href="${pageContext.request.contextPath}/login.jsp">Login now</a>
                </p>
            </div>
        </div>
    </div>
</body>
</html> 