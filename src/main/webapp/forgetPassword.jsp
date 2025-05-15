<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password - ManeeshFoods</title>
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

        <!-- Forgot Password Form -->
        <div class="auth-container">
            <div class="auth-box">
                <h2>Reset Password</h2>
                <p style="text-align: center; color: var(--text-color); margin-bottom: 2rem; opacity: 0.8;">
                    Enter your email address and we'll send you a link to reset your password.
                </p>
                <% if(request.getAttribute("errorMessage") != null) { %>
                    <div class="error-message">
                        <%= request.getAttribute("errorMessage") %>
                    </div>
                <% } %>
                <% if(request.getAttribute("successMessage") != null) { %>
                    <div class="success-message">
                        <%= request.getAttribute("successMessage") %>
                    </div>
                <% } %>
                <form action="${pageContext.request.contextPath}/user/forgot-password" method="get" class="auth-form">
                    <div class="form-group">
                        <label for="email">Email Address</label>
                        <input type="email" id="email" name="email" required
                               value="<%= request.getParameter("email") != null ? request.getParameter("email") : "" %>"
                               placeholder="Enter your registered email">
                    </div>
                    <button type="submit" class="auth-button">
                        <i class="fas fa-paper-plane"></i> Send Reset Link
                    </button>
                </form>
                <div class="auth-divider">
                    <span>or</span>
                </div>
                <div class="alternative-options" style="text-align: center; margin-top: 1rem;">
                    <p class="auth-switch">
                        Remember your password? <a href="${pageContext.request.contextPath}/login.jsp">Login here</a>
                    </p>
                    <p class="auth-switch" style="margin-top: 0.5rem;">
                        Don't have an account? <a href="${pageContext.request.contextPath}/register.jsp">Register now</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</body>
</html> 