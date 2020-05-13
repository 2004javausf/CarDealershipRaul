package com.dealership.app;
import com.dealership.dao.CarDAO;
import com.dealership.dao.OfferDAO;
import com.dealership.driver.MainMenu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.dealership.dao.OfferDAO;
import com.dealership.pojo.Car;
import com.dealership.pojo.Offer;

//• As the system, I update a car to an owned state when an offer is accepted.
//• As the system, I reject all other pending offers for a car when an offer is accepted.
//• As the system, I can calculate the monthly payment.
public class AdminAPP {
	static Scanner scanner = new Scanner(System.in);
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static OfferDAO dao = new OfferDAO();
	
	public static Car car;
	public static void adminMenu()throws Exception{
	
		String option = "";
		do {
			System.out.println("A. View Cars");
			System.out.println("B. Update car to owned state");
			System.out.println("C. Reject all pending offers");
			System.out.println("D. Calculate Monthly Payment");
			System.out.println("E. Back to Main Menu");
			System.out.println("F. Exit");
			option = br.readLine();
			System.out.println("\n");
			switch(option.toUpperCase()) {
			case "A":
				EmployeeApp.viewCar();
				break;
			case "B":
				udpateToOwned();
				break;
			case "C":
				rejectAll();
				break;
			case "D":
				calculatePayment();
				break;
			case "E":
			MainMenu.mainMenu();
				default:
					System.out.println("Invalid option! Please try again");
					break;
			}
		}while (option !="F");
		
	}

	private static void calculatePayment() throws Exception  {
		
		EmployeeApp.searchCar();
	
	
	}

	private static void rejectAll() throws Exception{
		OfferApp.viewOffer();
		OfferApp.updateOffer();
		
	}

	private static void udpateToOwned() throws Exception {
	
	EmployeeApp.updateCar();
	}
}
