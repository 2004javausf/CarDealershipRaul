package com.dealership.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.dealership.pojo.Customer;

import java.sql.Connection;
import java.sql.DriverManager;

public class Driver {

	public static void main(String[] args) throws Exception {

		// SCRIPT TO CREATE TABLE
	String JDBC_URL = "jdbc:oracle:thin:@java2004raul.cancjc6pfcwp.us-east-2.rds.amazonaws.com:1521:ORCL";
		
		String user = "ralocorvette";
		String password = "Papuchi2013";
		Connection conn = DriverManager.getConnection(JDBC_URL,user,password);
		Statement st = conn.createStatement();
		//int n = st.executeUpdate("DROP TABLE offer");
		
//		Customer customer = new Customer(rs.getString("name"), rs.getString("lastname"),
//				rs.getString("lastFourSsnID"),rs.getString("username"),rs.getString("password"),
//				rs.getString("custCarBrand"),rs.getString("custCarModel"),rs.getInt("custCarValue"),rs.getInt("custRemainingPayments"),
//				rs.getInt("monPayment"));
		
//		int n = st.executeUpdate("CREATE TABLE customer(name varchar2(30), lastname varchar2(30),"
//				+ "lastFourSsnID varchar2(30),username varchar2(30),password varchar2(30),"
//				+ "custCarBrand varchar2(30),custCarModel varchar2(30),custCarValue int, custRemainingPayments int,"
//				+ " monPayment int)");
	//int n1 = st.executeUpdate("Create Table offer (price varchar2(10),payment varchar2(10),"
				//+ "acceptedDenied varchar2(10),carId int)");
		
		//int n2 = st.executeUpdate("CREATE TABLE cars(brand varchar2(20),model varchar2(20),owned varchar2(30), price int, id int)");
		
		//int n3 = st.executeUpdate("CREATE TABLE customercars(customerbrand varchar(20),"
				//+ "customermodel varchar(20),customerpriceprice int, customerid int, remPayments int, monPayment int)");
		//System.out.println("Number of rows affected"+n);
		
		MainMenu.mainMenu();
	}

}
