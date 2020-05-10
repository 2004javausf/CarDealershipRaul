package com.dealership.pojo;

public class Offer {
String price;
String payement;
int carId;
public Offer(String price, String payement, int carId) {
	super();
	this.price = price;
	this.payement = payement;
	this.carId = carId;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getPayement() {
	return payement;
}
public void setPayement(String payement) {
	this.payement = payement;
}
public int getCarId() {
	return carId;
}
public void setCarId(int carId) {
	this.carId = carId;
}


}
