package com.maneesh.model;

public class OrderItem {
	private int orderItemId;
	private int quantity;
	private double totalPrice;
	public OrderItem() {
		super();
	}
	public OrderItem(int orderItemId, int quantity, double totalPrice) {
		super();
		this.orderItemId = orderItemId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	public OrderItem(int quantity, double totalPrice) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
	}
	
	

}
