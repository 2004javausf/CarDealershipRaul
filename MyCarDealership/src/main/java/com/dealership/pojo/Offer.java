package com.dealership.pojo;

public class Offer {
String price;
String payement;
String acceptedDenied;
String acceptedDenied2;
int carId;
public Offer(String price, String payement, String acceptedDenied, int carId) {
	super();
	this.price = price;
	this.payement = payement;
	this.acceptedDenied = acceptedDenied;
	this.carId = carId;
}
public Offer(String acceptedDenied2) {
	// TODO Auto-generated constructor stub
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
public String getAcceptedDenied2() {
	return acceptedDenied2;
}
public void setAcceptedDenied2(String acceptedDenied2) {
	this.acceptedDenied2 = acceptedDenied2;
}


}
