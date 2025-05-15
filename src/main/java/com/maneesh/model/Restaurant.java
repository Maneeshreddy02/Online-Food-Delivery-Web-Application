package com.maneesh.model;

public class Restaurant {
	private int restaurantId;
	private String name;
	private String cuisineType;
	private String  deliveryTime;
	private int  adminUserId;
	private String restaurantAddress;
	private double  rating;
	private String inactive;
	private String imagePath;
	
	
	public Restaurant(int restaurantId, String name, String cuisineType, String deliveryTime, int adminUserId,
			double rating, String inactive) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.adminUserId = adminUserId;
		this.rating = rating;
		this.inactive = inactive;
	}
	public Restaurant() {
	}
	public Restaurant(int restaurantId, String name, String cuisineType, String deliveryTime, int adminUserId, double rating,
			String inactive, String imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.adminUserId = adminUserId;
		this.rating = rating;
		this.inactive = inactive;
		this.imagePath = imagePath;
	}
	public String getRestaurantAddress() {
		return restaurantAddress;
	}
	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}
	public Restaurant(int restaurantId, String name, String cuisineType, String deliveryTime, int adminUserId,
			String restaurantAddress, double rating, String inactive, String imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.adminUserId = adminUserId;
		this.restaurantAddress = restaurantAddress;
		this.rating = rating;
		this.inactive = inactive;
		this.imagePath = imagePath;
	}
	public Restaurant(String name, String cuisineType, String deliveryTime, int adminUserId, double rating,
			String inactive) {
		super();
		this.name = name;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.adminUserId = adminUserId;
		this.rating = rating;
		this.inactive = inactive;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int resturantId) {
		this.restaurantId = resturantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public int getAdminUserId() {
		return adminUserId;
	}
	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getInactive() {
		return inactive;
	}
	public void setInactive(String inactive) {
		this.inactive = inactive;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", cuisineType=" + cuisineType
				+ ", deliveryTime=" + deliveryTime + ", adminUserId=" + adminUserId + ", restaurantAddress="
				+ restaurantAddress + ", rating=" + rating + ", inactive=" + inactive + ", imagePath=" + imagePath
				+ "]";
	}
	

}
