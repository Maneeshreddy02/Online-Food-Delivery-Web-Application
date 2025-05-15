package com.maneesh.dao;

import java.util.List;


import com.maneesh.model.Order;

public interface OrderDao {
	int insertOrder(Order order);
	List<Order> getAllRest();
	Order getOrderById(int orderId);
	int delete(int orderId);
	int updateOrderById(Order order);


}
