package com.dealership.pojo;

public class Customer {
private String name;
private String lastname;
private String lastFourSsnID;
private String username;
private String password;
private String custCarBrand;
private String custCarModel;
private int custCarValue;
private int custRemainingPayments;
private int monPayment;
public Customer(String name, String lastname, String lastFourSsnID, String username, String password,
		String custCarBrand, String custCarModel, int custCarValue, int custRemainingPayments, int monPayment) {
	super();
	this.name = name;
	this.lastname = lastname;
	this.lastFourSsnID = lastFourSsnID;
	this.username = username;
	this.password = password;
	this.custCarBrand = custCarBrand;
	this.custCarModel = custCarModel;
	this.custCarValue = custCarValue;
	this.custRemainingPayments = custRemainingPayments;
	this.monPayment = monPayment;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLastname() {
	return lastname;
}
public void setLatname(String latname) {
	this.lastname = latname;
}
public String getLastFourSsnID() {
	return lastFourSsnID;
}
public void setLastFourSsnID(String lastFourSsnID) {
	this.lastFourSsnID = lastFourSsnID;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getCustCarBrand() {
	return custCarBrand;
}
public void setCustCarBrand(String custCarBrand) {
	this.custCarBrand = custCarBrand;
}
public String getCustCarModel() {
	return custCarModel;
}
public void setCustCarModel(String custCarModel) {
	this.custCarModel = custCarModel;
}
public int getCustCarValue() {
	return custCarValue;
}
public void setCustCarValue(int custCarValue) {
	this.custCarValue = custCarValue;
}
public int getCustRemainingPayments() {
	return custRemainingPayments;
}
public void setCustRemainingPayments(int custRemainingPayments) {
	this.custRemainingPayments = custRemainingPayments;
}
public int getMonPayment() {
	return monPayment;
}
public void setMonPayment(int monPayment) {
	this.monPayment = monPayment;
}
	
	
	
	
}
