package com.dealership.driver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.dealership.app.AdminAPP;
import com.dealership.app.CustomerApp;
import com.dealership.app.EmployeeApp;

public class MainMenu {
	//static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static	Scanner scanner = new Scanner(System.in);
	public static void mainMenu() throws Exception {
		String option = "";
		do {
		System.out.println("Welcome to the Dealership");
		System.out.println("Please Make a selection");
		System.out.println("A. Employee Menu");
		System.out.println("B. Admin Menu");
		System.out.println("C. Customer Menu");
		System.out.println("D. Exit");
		option =scanner.nextLine();
		System.out.println("\n");
		switch(option.toUpperCase()) {
		case "A":
			generalLogin();
			break;
		case "B":
			generalLogin();
			break;
		case "C":
			CustomerApp.customerMenu();
			break;
		case "D":
			System.out.println("Thank you for visiting the Dealership! Good Bye");
			System.exit(0);
			default:
				System.out.println("Invalid selecion, try again!");
				
			
		}

	}while(option != "D");
}
	public static void generalLogin() throws Exception{
		System.out.println("Please Login ");
		System.out.println("Enter username");
		String username = scanner.nextLine();
		System.out.println("Enter password");
		String password = scanner.nextLine();
		if(username.equals("employee")&&password.equals("employee")) {
		EmployeeApp.employeeMenu();
		} else if(username.equals("admin")&&password.equals("admin")) {
			AdminAPP.adminMenu();
		}else {
			MainMenu.mainMenu();
		}
		
	
	}

}
