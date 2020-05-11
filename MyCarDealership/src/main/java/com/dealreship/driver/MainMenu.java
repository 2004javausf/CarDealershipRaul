package com.dealreship.driver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.dealership.app.AdminAPP;
import com.dealership.app.CustomerApp;
import com.dealership.app.EmployeeApp;

public class MainMenu {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void mainMenu() {
		String option = "";
		do {
		System.out.println("Welcome to the Dealership");
		System.out.println("Please Make a selection");
		System.out.println("A Employee Login");
		System.out.println("B Admin Login");
		System.out.println("C Customer Login");
		System.out.println("D Register for a Customer account");
		option =br.readLine();
		System.out.println("\n");
		switch(option.toUpperCase()) {
		case "A":
			EmployeeApp.employeeMenu();
			break;
		case "B":
			AdminAPP.adminMenu();
			break;
		case "C":
			CustomerApp.customerMenu();
			break;
		case "D":
			System.out.println("Thank you for visiting the Dealership! Good Bye");
			System.exit(0);
				
			
		}

	}
}
