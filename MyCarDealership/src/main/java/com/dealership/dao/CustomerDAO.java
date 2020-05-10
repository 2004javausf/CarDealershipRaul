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
						rs.getString("username"),rs.getString("password"),rs.getString("custCarBrand"),
						rs.getString("custCarModel"),rs.getInt("custCarValue"),rs.getInt("custRemainingPayments"),
						rs.getInt("lastFourSsnID"));
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
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM product WHERE name = ?");
			ps.setString(1, name); 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				customer  = new Customer(rs.getString("name"), rs.getString("lastname"),
						rs.getString("username"),rs.getString("password"),rs.getString("custCarBrand"),
						rs.getString("custCarModel"),rs.getInt("custCarValue"),rs.getInt("custRemainingPayments"),
						rs.getInt("lastFourSsnID"));
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
			PreparedStatement ps = conn.prepareStatement("INSERT INTO customer VALUES(?,?,?,?,?,?,?,?)");
			ps.setString(1, customer.getUsername()) ;
			ps.setString(2, customer.getPassword());
			ps.setString(3, customer.getFirstName());
			ps.setString(4, customer.getLastName());
			ps.setString(5, customer.getCustCarBrand());
			ps.setString(6, customer.getCustCarModel());
			ps.setInt(7, customer.getCustCarValue());
			ps.setInt(8, customer.getCustRemainingPayments());
			ps.setInt(9, customer.getLastFourSSNId());
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
			PreparedStatement ps = conn.prepareStatement("UPDATE customer SET username=?,password=?,"
					+ "firstName=?,lastName=?,"
					+ "custCarBrand=?,custCarModel=?,"
					+ "custCarValue=?,custRemainingPayments=? WHERE lastFourSsnID=?");
			ps.setString(1, customer.getUsername());
			ps.setString(2, customer.getPassword());
			ps.setString(3, customer.getFirstName());
			ps.setString(4,customer.getLastName());
			ps.setString(4, customer.getCustCarBrand());
			ps.setString(5, customer.getCustCarModel());
			ps.setInt(6,customer.getCustCarValue());
			ps.setInt(7, customer.getCustRemainingPayments());
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
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM product WHERE lastFourSsnID = ?");
			ps.setString(1, lastFourSsnID); 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				customer = new Customer(rs.getString("name"), rs.getString("lastname"),
						rs.getString("username"),rs.getString("password"),rs.getString("custCarBrand"),
						rs.getString("custCarModel"),rs.getInt("custCarValue"),rs.getInt("custRemainingPayments"),
						rs.getInt("lastFourSsnID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
}

