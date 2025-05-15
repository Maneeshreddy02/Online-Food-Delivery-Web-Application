package com.maneesh.model;

import java.util.Date;

public class Order {
	private int orderId;
	private Date orderDate;
	private double totalAmount;
	private String status;
	private String paymentMode;
	public Order(int orderId, double totalAmount, String status, String paymentMode) {
		super();
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
	}
	public Order() {
		super();
	}
	public Order(int orderId, Date orderDate, double totalAmount, String status, String paymentMode) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
	}
	
	public Order(Date orderDate, double totalAmount, String status, String paymentMode) {
		super();
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
	}
	
	public Order(double totalAmount, String status, String paymentMode) {
		super();
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", status="
				+ status + ", paymentMode=" + paymentMode + "]";
	}
	
	

}
