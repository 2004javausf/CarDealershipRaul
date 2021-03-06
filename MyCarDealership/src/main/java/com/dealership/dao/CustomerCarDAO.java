package com.dealership.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dealership.dbutil.DBUtil;
import com.dealership.pojo.CustomerCar;
//int n3 = st.executeUpdate("CREATE TABLE customercars(customerbrand varchar(20),"
		//+ "customermodel varchar(20),customerpriceprice int, customerid int, remPayments int, monPayment int)");
public class CustomerCarDAO {
	public List<CustomerCar> getAllCars() {
		//create array list
		List<CustomerCar> customerCarList = new ArrayList<CustomerCar>();
		try {
			//open connection
			Connection conn = DBUtil.getConnection();
			//create statement
			Statement st = conn.createStatement();
			//create ResultSet Object and execute the SQL Query
																	 
			
			ResultSet rs = st.executeQuery("SELECT * FROM customercars");
			while (rs.next()) {
				CustomerCar cCar = new CustomerCar(rs.getString("customerbrand"), rs.getString("customermodel"),
						rs.getInt("customerprice"),rs.getInt("customerid"),rs.getInt("remPayments"),rs.getInt("monPayment"));
				customerCarList.add(cCar);
			}
			//close connection 
			DBUtil.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return product list 
		return customerCarList;
	}

	public CustomerCar getBrand(String brand) {
		CustomerCar cCar = null;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM customercars WHERE brand = ?");
			ps.setString(1, brand); 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cCar = new CustomerCar(rs.getString("customerbrand"), rs.getString("customermodel"),
						rs.getInt("customerprice"),rs.getInt("customerid"),rs.getInt("remPayments"),rs.getInt("monPayment"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cCar;
	}

	public int addCustomerCar(CustomerCar cCar) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO customercar VALUES(?,?,?,?,?,?)");
			ps.setString(1, cCar.getBrand()) ;
			ps.setString(2, cCar.getModel());
			ps.setInt(3, cCar.getPrice());
			ps.setInt(4, cCar.getId());
			ps.setInt(5, cCar.getRemPayments());
			ps.setInt(6, cCar.getMonPayment());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public int updateCustomerCar(CustomerCar cCar) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE customercar SET customerbrand=?,customermodel=?,"
					+ "customerprice=?,remPayments=?,monPayments=? WHERE customerid=?");
			ps.setString(1, cCar.getBrand());
			ps.setString(2, cCar.getModel());
			ps.setInt(3, cCar.getPrice());
			ps.setInt(4, cCar.getRemPayments());
			ps.setInt(5, cCar.getMonPayment());

			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public int deleteCar(String id) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM customercars where customerid = ?");
			ps.setString(1, id);
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	

	public CustomerCar getCarById(String carId) {
		CustomerCar cCar = null;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM customercars WHERE customerid = ?");
			ps.setString(1, carId); 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cCar = new CustomerCar(rs.getString("customerbrand"), rs.getString("customermodel"),
						rs.getInt("customerprice"),rs.getInt("customerid"),rs.getInt("remPayments"),rs.getInt("monPayment"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cCar;
	}
}
