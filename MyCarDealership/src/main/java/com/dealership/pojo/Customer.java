package com.dealership.pojo;

public class Customer {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String custCarBrand;
	private String custCarModel;
	private int custCarValue;
	private int custRemainingPayments;
	private int lastFourSsnID;
	public Customer(String username, String password, String firstName, String lastName, String custCarBrand,
			String custCarModel, int custCarValue, int custRemainingPayments, int lastFourSsnID) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.custCarBrand = custCarBrand;
		this.custCarModel = custCarModel;
		this.custCarValue = custCarValue;
		this.custRemainingPayments = custRemainingPayments;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public int getLastFourSSNId() {
		return lastFourSsnID;
	}
	public void setLastFourSSNId(int lastFourSsnID) {
		this.lastFourSsnID = lastFourSsnID;
	}
	
	
}
