package com.dealership.app;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.dealership.dao.CustomerCarDAO;
import com.dealership.dao.CustomerDAO;
import com.dealership.driver.MainMenu;
import com.dealership.pojo.Customer;
import com.dealership.pojo.CustomerCar;

public class CustomerApp{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//static CarDAO dao = new CarDAO();
	static CustomerDAO dao2 = new CustomerDAO();
	//static CustomerCarDAO dao3 = new CustomerCarDAO();

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
			System.out.println("Z Go Back to Home Menu");
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
			case "Z":
				System.out.println("Going back to Main Menu");
				MainMenu.mainMenu();
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
			System.out.println("You are logged in");
			System.out.println("A. View all Cars in the Dealership");
			System.out.println("B. Make Offer");
			System.out.println("C. View Payments on my own Car");
			System.out.println("Z. Back to Home Menu");
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
				System.out.println("Thanks for visiting the dealership!");
				System.exit(0);
				break;
			case "Z":
				System.out.println("Going back to Main Menu");
				MainMenu.mainMenu();
				break;
			default:
				System.out.println("Invalid Option!!.Please enter again");
				break;
			}
		} while (option != "D");
		}else {
			CustomerApp.customerMenu();
		}
}
	
		

	private static void addCustomerCar() throws Exception{
		System.out.println("------------------------------------");
		System.out.println("Enter First Name:");
		System.out.println("------------------------------------");
		String name = br.readLine();
		System.out.println("------------------------------------");
		System.out.println("Enter Last Name:");
		System.out.println("------------------------------------");
		String lastname =br.readLine();
		System.out.println("------------------------------------");
		System.out.println("Enter last 4 of SSN:");
		System.out.println("------------------------------------");
		String lastFourSsnID = br.readLine();
		System.out.println("------------------------------------");
		System.out.println("Enter Username:");
		System.out.println("------------------------------------");
		String username = br.readLine();
		System.out.println("------------------------------------");
		System.out.println("Enter Password:");
		System.out.println("------------------------------------");
		String password = br.readLine();
		System.out.println("------------------------------------");
		System.out.println("Enter Brand Name:");
		System.out.println("------------------------------------");
		String custCarBrand = br.readLine();
		System.out.println("------------------------------------");
		System.out.println("Enter Model Name:");
		System.out.println("------------------------------------");
		String custCarModel = br.readLine();
		System.out.println("------------------------------------");
		System.out.println("Enter Car Value:");
		System.out.println("------------------------------------");
		int custCarValue = Integer.parseInt(br.readLine());
		System.out.println("------------------------------------");
		System.out.println("Enter remaining Payments:");
		System.out.println("------------------------------------");
		int custRemainingPayments = Integer.parseInt(br.readLine());
		System.out.println("------------------------------------");
		System.out.println("Enter current monthly payment Value:");
		System.out.println("------------------------------------");
		int monPayment = Integer.parseInt(br.readLine());

		//CustomerCar cCar = new CustomerCar(brand, model, price,id,remPayments,monPayment);
		Customer customer = new Customer(name,lastname,lastFourSsnID,username,password,custCarBrand,
				custCarModel,custCarValue,custRemainingPayments,monPayment);
		int status = dao2.addCustomer(customer);
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

	public static void viewPayments() throws Exception{
		System.out.println("------------------------------------");
		List<Customer> customerList = dao2.getAllCustomers();
		for (Customer customer : customerList) {
			displayCustomer(customer);
		}
		System.out.println("------------------------------------");
		System.out.println("\n");
		
		CustomerApp.customerMenu();
	}
	public static void displayCustomer(Customer customer) {
		System.out.println("Customer Name: "+ customer.getName()+" "+customer.getLastname());
		System.out.println("Car Brand: " + customer.getCustCarBrand());
		System.out.println("Car Model: " + customer.getCustCarModel());
		System.out.println("Car Price: " + customer.getCustCarValue());
		System.out.println("Car Remaining Payments "+ customer.getCustRemainingPayments());
		System.out.println("Car Monthly Payment "+customer.getMonPayment());
		System.out.println("\n");
	}
}

