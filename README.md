# Online-Food-Delivery.github.io
# 🍽️ Online Food Delivery Web Application

A full-stack web application built using **Java**, **JSP**, **Servlets**, **JDBC**, and **MySQL** that allows users to browse restaurants, view menus, place orders, and track order history. This project simulates a basic food delivery platform with end-to-end functionality.

---

## 🚀 Features

- ✅ User Registration & Login  
- ✅ Browse Restaurants & Menus  
- ✅ Add Items to Cart  
- ✅ Place Orders  
- ✅ View Order History  
- ✅ MySQL Database Integration  
- ✅ Secure Session Management

---

## 🛠️ Technologies Used

- **Frontend:** HTML, CSS, JSP  
- **Backend:** Java Servlets, JDBC  
- **Database:** MySQL  
- **Server:** Apache Tomcat  
- **IDE:** Eclipse 
- **Tools:** MySQL Workbench

---

## 🧱 Database Schema

- `users` – Stores user details (name, email, phone, address, password)  
- `restaurants` – Stores restaurant names and locations  
- `menu` – Contains food items linked to restaurants  
- `orders` – Contains order details  
- `order_items` – Items included in each order

SQL scripts to create and populate tables are available in the `database/` folder.

---

## 📸 Screenshots

_Add screenshots here showing login, menu, cart, and order pages (optional)._

---

## 🚦 How to Run the Project

1. Clone the repository  
2. Create the database using provided SQL scripts  
3. Update DB connection details in `DBUtil.java`  
4. Deploy the project on Apache Tomcat (v9 or above)  
5. Open in browser: `http://localhost:8080/FoodDeliveryApp`

---

## 📁 Folder Structure
FoodDeliveryApp/
├── src/
│ ├── com.maneesh.model/
│ ├── com.maneesh.dao/
│ ├── com.maneesh.dao.impl/
│ └── com.maneesh.servlet/
├── WebContent/
│ ├── jsp/
│ ├── css/
│ └── WEB-INF/
└── database/


