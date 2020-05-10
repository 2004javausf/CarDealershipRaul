package com.dealership.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AccountCreator {
	static Scanner scanner = new Scanner(System.in);
private static void creatorMenu() throws Exception {

		System.out.println("Please enter your name");
		String name = scanner.nextLine();
		System.out.println("Please enter your last name");
		String lastName = scanner.nextLine();
		System.out.println("Please enter your username");
		String username = scanner.nextLine();
		System.out.println("Please enter your password");
		String password = scanner.nextLine();
		
		if(username.equals(username)&& password.equals(password)) {
			System.out.println("You are logged in");
			CustomerApp.customerMenu();
		}
}
}
