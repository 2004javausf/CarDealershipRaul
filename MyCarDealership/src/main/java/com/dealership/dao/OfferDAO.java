package com.dealership.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dealership.dbutil.DBUtil;
import com.dealership.pojo.Offer;

public class OfferDAO {
	public List<Offer> getAllOffers() {
		//create array list
		List<Offer> offerList = new ArrayList<Offer>();
		try {
			//open connection
			Connection conn = DBUtil.getConnection();
			//create statement
			Statement st = conn.createStatement();
			//create ResultSet Object and execute the SQL Query
																	 
			
			ResultSet rs = st.executeQuery("SELECT * FROM offer");
			while (rs.next()) {
				Offer offer = new Offer(rs.getString("price"), rs.getString("payment"),rs.getString("acceptedDenied"),
						rs.getInt("carId"));
				offerList.add(offer);
			}
			//close connection 
			DBUtil.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return product list 
		return offerList;
	}

	public Offer getPrice(String price) {
		Offer offer = null;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM offer WHERE price = ?");
			ps.setString(1, price); 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				offer = new Offer(rs.getString("price"), rs.getString("payment"), rs.getString("acceptedDenied"),rs.getInt("carId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return offer;
	}

	public int addOffer(Offer offer) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO offer VALUES(?,?,?,?)");
			ps.setString(1, offer.getPrice()) ;
			ps.setString(2, offer.getPayment());
			ps.setString(3, offer.getAcceptedDenied());
			ps.setInt(4, offer.getCarId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public int updateOffer(Offer offer) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE offer SET price=?,payment=?,acceptedDenied=? WHERE carId=?");
			ps.setString(1, offer.getPrice());
			ps.setString(2, offer.getPayment());
			ps.setString(3, offer.getAcceptedDenied());
			ps.setInt(4, offer.getCarId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	//only for system admin ussage
	public int updateAllOffers(Offer offer) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("Update offer SET acceptedDenied=? where acceptedDenied=denied");
			ps.setString(1, offer.getAcceptedDenied());
			status = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public int deleteOffer(String id) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM product where id = ?");
			ps.setString(1, id);
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	

	public Offer getOfferById(String carId) {
		Offer offer = null;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM offer WHERE id = ?");
			ps.setString(1, carId); 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				offer = new Offer(rs.getString("price"), rs.getString("payment"),rs.getString("acceptedDenied"),rs.getInt("carId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return offer;
	}
}
