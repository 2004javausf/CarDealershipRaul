package com.dealership.pojo;

public class CustomerCar {
	String brand;
	String model;
	int price;
	int id;
	int remPayments;
	int monPayment;
	public CustomerCar(String brand, String model, int price, int id, int remPayments, int monPayment) {
		super();
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.id = id;
		this.remPayments = remPayments;
		this.monPayment = monPayment;
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
	public int getRemPayments() {
		return remPayments;
	}
	public void setRemPayments(int remPayments) {
		this.remPayments = remPayments;
	}
	public int getMonPayment() {
		return monPayment;
	}
	public void setMonPayment(int monPayment) {
		this.monPayment = monPayment;
	}
	
	
}
