package com.dealership.pojo;

public class Offer {
String price;
String payment;
String acceptedDenied;
int carId;
public Offer(String price, String payment, String acceptedDenied, int carId) {
	super();
	this.price = price;
	this.payment = payment;
	this.acceptedDenied = acceptedDenied;
	this.carId = carId;
}

public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getPayment() {
	return payment;
}
public void setPayement(String payement) {
	this.payment = payement;
}
public String getAcceptedDenied() {
	return acceptedDenied;
}
public void setAcceptedDenied(String acceptedDenied) {
	this.acceptedDenied = acceptedDenied;
}
public int getCarId() {
	return carId;
}
public void setCarId(int carId) {
	this.carId = carId;
}


}
