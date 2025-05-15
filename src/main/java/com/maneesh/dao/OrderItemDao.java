package com.maneesh.dao;

import java.util.List;

import com.maneesh.model.OrderItem;

public interface OrderItemDao {
	int insertOrder(OrderItem orderitem);
	List<OrderItem> getAllRest();
	OrderItem getOrderById(int orderItemId);
	int delete(int orderItemId);
	int updateOrderById(OrderItem orderitem);

}
