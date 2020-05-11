package com.dealreship.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Driver {

	public static void main(String[] args) throws Exception {

		// SCRIPT TO CREATE TABLE
		String JDBC_URL = "jdbc:oracle:thin:@java2004raul.cancjc6pfcwp.us-east-2.rds.amazonaws.com:1521:ORCL";
		
		String user = "ralocorvette";
		String password = "Papuchi2013";
		Connection conn = DriverManager.getConnection(JDBC_URL,user,password);
		Statement st = conn.createStatement();
		int n = st.executeUpdate("CREATE TABLE customer(name varchar2(30), lastname varchar2(30),"
				+ "username varchar2(30),password varchar2(30),custCarBrand varchar2(30),"
				+ "custCarModel varchar2(30), custCarValue int, custRemainingPayments int,"
				+ " lastFourSsnID int)");
		int n1 = st.executeUpdate("Create Table offer (price varchar2(10),payment varchar2(10),"
				+ "acceptedDenied varchar2(10),acceptedDenied2 varchar2(10),carId int)");
		
		int n2 = st.executeUpdate("CREATE TABLE car(price varchar2(20),model varchar2(20), price int, id int)");
		
		int n3 = st.executeUpdate("CREATE TABLE customercar(brand varchar(20),"
				+ "model varchar(20),price int, id int, remPayments int, monPayment int)");
		System.out.println("Number of rows affected"+n);
	}

}
