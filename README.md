
# 🍽️ Online Food Delivery Web Application

This is an Online Food Delivery Web Application developed using Java technologies including JSP, Servlets, JDBC, and MySQL. It allows users to register, log in, browse restaurants and menus, add items to a cart, place orders, and view order history. The project demonstrates the full-stack development process using a traditional MVC pattern and is designed for learning and demonstration purposes.

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
📸 Restaurants page images
<img width="892" alt="image" src="https://github.com/user-attachments/assets/a746fbfe-6ed8-499a-a80d-7e137c614c7c" />

<img width="947" alt="image" src="https://github.com/user-attachments/assets/d6461b92-f734-48d7-b910-1ef4aebbbcfe" />
  
  
📸 Menu page images
<img width="946" alt="image" src="https://github.com/user-attachments/assets/9c481384-802a-4bb5-8ad7-d444e8aa0c49" />

<img width="941" alt="image" src="https://github.com/user-attachments/assets/cd3f54fc-8dbe-41ca-9f10-d57b250c5517" />


📸 cart page image
<img width="948" alt="image" src="https://github.com/user-attachments/assets/c4fd4b46-5bc1-47ae-b578-979db8162bfe" />

---

## 🚦 How to Run the Project

1. Clone the repository  
2. Create the database using provided SQL scripts  
3. Update DB connection details in `DBUtil.java`  
4. Deploy the project on Apache Tomcat (v10.1)  
5. Open in browser: `http://localhost:8080/ManeeshFoods/home`

---

## 📁 Folder Structure

<pre>├── src/
│ ├── com.maneesh.model/
│ ├── com.maneesh.dao/
│ ├── com.maneesh.dao.impl/
│ └── com.maneesh.servlet/
├── WebContent/
│ ├── images/
│ ├── jsp/
│ ├── css/
│ └── WEB-INF/
</pre>
---
🙋‍♂️ Author 

Maneesh Reddy Bhumireddy Connect on LinkedIn(www.linkedin.com/in/maneesh-reddy-bhumireddy-6566a3276) | Email: maneeshreddy200@gmail.com


