package com.maneesh.model;

public class CartItem {
    private int id;
    private int restaurantId;
    private String name;
    private int quantity;
    private double price;
    
    public CartItem() {
		// TODO Auto-generated constructor stub
	}

	public CartItem(int id, int restaurantId, String name, int quantity, double price) {
		super();
		this.id = id;
		this.restaurantId = restaurantId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", restaurantId=" + restaurantId + ", name=" + name + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
    
    
    
    
}
