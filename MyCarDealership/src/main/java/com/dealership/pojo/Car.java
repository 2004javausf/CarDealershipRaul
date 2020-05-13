package com.dealership.pojo;

public class Car {
	String brand;
	String model;
	String owned;
	int price;
	int id;
	public Car(String brand, String model, String owned, int price, int id) {
		super();
		this.brand = brand;
		this.model = model;
		this.owned = owned;
		this.price = price;
		this.id = id;
	}
	public Car(int id2, String owned2) {
		// TODO Auto-generated constructor stub
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getOwned() {
		return owned;
	}
	public void setOwned(String owned) {
		this.owned = owned;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	
}
