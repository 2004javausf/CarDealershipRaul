package com.dealership.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.dealership.dao.CarDAO;
import com.dealership.dao.CustomerCarDAO;
import com.dealership.dao.CustomerDAO;
import com.dealership.pojo.Car;
import com.dealership.pojo.CustomerCar;
import com.dealership.pojo.Offer;

public class CustomerApp {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//static CarDAO dao = new CarDAO();
	//static CustomerDAO dao2 = new CustomerDAO();
	static CustomerCarDAO dao3 = new CustomerCarDAO();

	public static void customerMenu() throws Exception{
		String option = "";
		do {
			System.out.println("A. View Cars");
			//System.out.println("B. Add customer owned car");
			System.out.println("B. Register for an Account");
			//System.out.println("C. Make Offer");
			//System.out.println("D. View remaining payments");
			System.out.println("C.Login to account");
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
				//this will enable  customer to register and add his own car
				addCustomerCar();
				break;
			case "C":
				logintoAccount();
				//makeOffer(); //move this to subsequent menun login
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

	private static void logintoAccount() throws Exception {
		System.out.println("Account Login");
		System.out.println("Enter your username");
		String username  = br.readLine();
		System.out.println("Please ente your password");
		String password = br.readLine();
		if(username.equals(username)&& password.equals(password)) {
			
			String option = "";
			System.out.println("You are logged in now you can do more stuff :-)");
			System.out.println("A. View all Cars in the Dealership");
			System.out.println("B. Make Offer");
			System.out.println("C. View Payments on my own Car");
			System.out.println("D. Exit");
			option = br.readLine();
			System.out.println("\n");
			do {
			switch (option.toUpperCase()) {
			case "A":
				EmployeeApp.viewCar();
				break;
			case "B":
				makeOffer();
				break;
			case "C":
			viewPayments();
			case "D":
				System.out.println("*********************THANK YOU**************************");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Option!!.Please enter again");
				break;
			}
		} while (option != "D");
		}
}
	
		

	private static void addCustomerCar() throws Exception{
		System.out.println("------------------------------------");
		System.out.println("Enter First Name:");
		System.out.println("------------------------------------");
		System.out.println("------------------------------------");
		System.out.println("Enter Last Name:");
		System.out.println("------------------------------------");
		System.out.println("------------------------------------");
		System.out.println("Enter Username:");
		System.out.println("------------------------------------");
		System.out.println("------------------------------------");
		System.out.println("Enter Password:");
		System.out.println("------------------------------------");
		System.out.println("------------------------------------");
		System.out.println("Enter Brand Name:");
		System.out.println("------------------------------------");
		String brand = br.readLine();
		System.out.println("------------------------------------");
		System.out.println("Enter Model Name:");
		System.out.println("------------------------------------");
		String model = br.readLine();
		System.out.println("------------------------------------");
		System.out.println("Enter Car Price:");
		System.out.println("------------------------------------");
		int price = Integer.parseInt(br.readLine());
		System.out.println("------------------------------------");
		System.out.println("Enter Car ID:");
		System.out.println("------------------------------------");
		int id = Integer.parseInt(br.readLine());
		System.out.println("------------------------------------");
		System.out.println("Enter remaining Payments:");
		System.out.println("------------------------------------");
		int remPayments = Integer.parseInt(br.readLine());
		System.out.println("------------------------------------");
		System.out.println("Enter monthly Payments:");
		System.out.println("------------------------------------");
		int monPayment = Integer.parseInt(br.readLine());
		CustomerCar cCar = new CustomerCar(brand, model, price,id,remPayments,monPayment);
		int status = dao3.addCustomerCar(cCar);
		if (status == 1) {
			System.out.println("Car added successfully");
		} else {
			System.out.println("ERROR while adding car");
		}
		System.out.println("\n");
		
	}

	private static void makeOffer() throws Exception{
		OfferApp.addOffer();
		
	}

	public static void viewPayments() {
		System.out.println("------------------------------------");
		List<CustomerCar> customerCarList = dao3.getAllCars();
		for (CustomerCar cCar : customerCarList) {
			displayCustomerCar(cCar);
		}
		System.out.println("------------------------------------");
		System.out.println("\n");
	}
	public static void displayCustomerCar(CustomerCar cCar) {
		System.out.println("Car Brand: " + cCar.getBrand());
		System.out.println("Car Model: " + cCar.getModel());
		System.out.println("Car Price: " + cCar.getPrice());
		System.out.println("Car Remaining Payments "+ cCar.getRemPayments());
		System.out.println("Car Monthly Payment "+cCar.getMonPayment());
		System.out.println("\n");
	}
}

