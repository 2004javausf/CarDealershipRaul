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
		int n = st.executeUpdate("CREATE TABLE product(prod_id int, prod_name varchar2(30),prod_price int)");
		System.out.println("Number of rows affected"+n);
	}

}
