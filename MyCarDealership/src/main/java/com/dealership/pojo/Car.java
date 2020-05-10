package com.dealership.pojo;

public class Car {
	String brand;
	String model;
	int price;
	int id;
	public Car(String brand, String model, int price, int id) {
		super();
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.id = id;
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
