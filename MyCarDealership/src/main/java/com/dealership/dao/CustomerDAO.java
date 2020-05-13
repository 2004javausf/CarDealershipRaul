package com.dealership.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dealership.dbutil.DBUtil;
import com.dealership.pojo.Customer;

public class CustomerDAO {
	public List<Customer> getAllCustomers() {
		//create array list
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			//open connection
			Connection conn = DBUtil.getConnection();
			//create statement
			Statement st = conn.createStatement();
			//create ResultSet Object and execute the SQL Query
						 
			
			ResultSet rs = st.executeQuery("SELECT * FROM customer");
			while (rs.next()) {
				Customer customer = new Customer(rs.getString("name"), rs.getString("lastname"),
						rs.getString("lastFourSsnID"),rs.getString("username"),rs.getString("password"),
						rs.getString("custCarBrand"),rs.getString("custCarModel"),rs.getInt("custCarValue"),rs.getInt("custRemainingPayments"),
						rs.getInt("monPayment"));
				customerList.add(customer);
			}
			//close connection 
			DBUtil.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return product list 
		return customerList;
	}

	public Customer getName(String name) {
		Customer customer = null;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer WHERE name = ?");
			ps.setString(1, name); 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				customer  =new Customer(rs.getString("name"), rs.getString("lastname"),
						rs.getString("lastFourSsnID"),rs.getString("username"),rs.getString("password"),
						rs.getString("custCarBrand"),rs.getString("custCarModel"),rs.getInt("custCarValue"),rs.getInt("custRemainingPayments"),
						rs.getInt("monPayment"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	public int addCustomer(Customer customer) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, customer.getName()) ;
			ps.setString(2, customer.getLastname());
			ps.setString(3, customer.getLastFourSsnID());
			ps.setString(4, customer.getUsername());
			ps.setString(5, customer.getPassword());
			ps.setString(6, customer.getCustCarBrand());
			ps.setString(7, customer.getCustCarModel());
			ps.setInt(8, customer.getCustCarValue());
			ps.setInt(9, customer.getCustRemainingPayments());
			ps.setInt(10, customer.getMonPayment());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public int updateCar(Customer customer) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE customer SET "
					+ "custCarBrand=?,custCarModel=?,"
					+ "custCarValue=?,custRemainingPayments=?,monPayment=?, WHERE lastFourSsnID=?");
	
			ps.setString(1, customer.getCustCarBrand());
			ps.setString(2, customer.getCustCarModel());
			ps.setInt(3,customer.getCustCarValue());
			ps.setInt(4, customer.getCustRemainingPayments());
			ps.setInt(5, customer.getMonPayment());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public int deleteCustomer(String lastFourSsnID) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM customer where lastFourSsnID = ?");
			ps.setString(1, lastFourSsnID);
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	

	public Customer getCustomerById(String lastFourSsnID) {
		Customer customer = null;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer WHERE lastFourSsnID = ?");
			ps.setString(1, lastFourSsnID); 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				customer = new Customer(rs.getString("name"), rs.getString("lastname"),
						rs.getString("lastFourSsnID"),rs.getString("username"),rs.getString("password"),
						rs.getString("custCarBrand"),rs.getString("custCarModel"),rs.getInt("custCarValue"),rs.getInt("custRemainingPayments"),
						rs.getInt("monPayment"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
}

