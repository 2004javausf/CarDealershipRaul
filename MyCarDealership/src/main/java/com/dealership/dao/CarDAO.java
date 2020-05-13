package com.dealership.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dealership.dbutil.DBUtil;
import com.dealership.pojo.Car;
import com.dealership.pojo.Offer;


public class CarDAO {
	public List<Car> getAllCars() {
		//create array list
		List<Car> carList = new ArrayList<Car>();
		try {
			//open connection
			Connection conn = DBUtil.getConnection();
			//create statement
			Statement st = conn.createStatement();
			//create ResultSet Object and execute the SQL Query
																	 
			
			ResultSet rs = st.executeQuery("SELECT * FROM cars");
			while (rs.next()) {
				Car car = new Car(rs.getString("brand"), rs.getString("model"), rs.getString("owned"),
						rs.getInt("price"),rs.getInt("id"));
				carList.add(car);
			}
			//close connection 
			DBUtil.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return product list 
		return carList;
	}

	public Car getBrand(String brand) {
		Car car = null;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM product WHERE brand = ?");
			ps.setString(1, brand); 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				car =  new Car(rs.getString("brand"), rs.getString("model"), rs.getString("owned"),
						rs.getInt("price"),rs.getInt("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return car;
	}

	public int addCar(Car car) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO cars VALUES(?,?,?,?,?)");
			ps.setString(1, car.getBrand()) ;
			ps.setString(2, car.getModel());
			ps.setString(3, car.getOwned());
			ps.setInt(4, car.getPrice());
			ps.setInt(5, car.getId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public int updateCar(Car car) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE cars SET brand=?,model=?,owned=?,price=? WHERE id=?");
			ps.setString(1, car.getBrand());
			ps.setString(2, car.getModel());
			ps.setString(3, car.getOwned());
			ps.setInt(4, car.getPrice());
			ps.setInt(5, car.getId());
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
			PreparedStatement ps = conn.prepareStatement("DELETE FROM cars where id = ?");
			ps.setString(1, id);
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	

	public Car getCarById(String carId) {
		Car car = null;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM cars WHERE id = ?");
			ps.setString(1, carId); 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				car = new Car(rs.getString("brand"), rs.getString("model"), rs.getString("owned"),
						rs.getInt("price"),rs.getInt("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return car;
	}

	
}
