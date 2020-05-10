package com.dealership.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.dealership.dao.CarDAO;
import com.dealership.dao.CustomerCarDAO;
import com.dealership.dao.CustomerDAO;
import com.dealership.pojo.CustomerCar;
import com.dealership.pojo.Offer;

public class CustomerApp {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//static CarDAO dao = new CarDAO();
	//static CustomerDAO dao2 = new CustomerDAO();
	static CustomerCarDAO dao3 = new CustomerCarDAO();

	static void customerMenu() throws Exception{
		String option = "";
		do {
			System.out.println("A. View Cars");
			System.out.println("B. Add customer owned car");
			System.out.println("C. Make Offer");
			System.out.println("D. View remaining payments")
			System.out.println("E. Exit");
			System.out.println("==========================================================================");
			System.out.println("Enter an option");
			System.out.println("==========================================================================");
			option = br.readLine();
			System.out.println("\n");
			switch (option.toUpperCase()) {
			case "A":
				EmployeeApp.viewCar();
				break;
			case "B":
				addCustomerCar();
				break;
			case "C":
				makeOffer();
				break;
			case "D":
			viewPayments();
			case "E":
				System.out.println("*********************THANK YOU**************************");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Option!!.Please enter again");
				break;
			}
		} while (option != "D");
	}

	private static void addCustomerCar() {
		System.out.println("------------------------------------");
		System.out.println("Enter Brand Name:");
		System.out.println("------------------------------------");
		String brand = br.readLine();
		System.out.println("------------------------------------");
		System.out.println("Enter Model Name:");
		System.out.println("------------------------------------");
		String model = br.readLine();
		System.out.println("------------------------------------");
		System.out.println("Enter Product Price:");
		System.out.println("------------------------------------");
		int price = Integer.parseInt(br.readLine());
		System.out.println("------------------------------------");
		System.out.println("Enter Product ID:");
		System.out.println("------------------------------------");
		int id = Integer.parseInt(br.readLine());
		
		CustomerCar cCar = new CustomerCar(brand, model, price,id);
		int status = dao3.addCustomerCar(cCar);
		if (status == 1) {
			System.out.println("Car added successfully");
		} else {
			System.out.println("ERROR while adding car");
		}
		System.out.println("\n");
		
	}

	private static void makeOffer() {
		OfferApp.addOffer();
		
	}





	private static void viewPayments() {
	// TODO Auto-generated method stub
	
}
