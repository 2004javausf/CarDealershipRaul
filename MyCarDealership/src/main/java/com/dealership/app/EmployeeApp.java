package com.dealership.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.dealership.dao.CarDAO;
import com.dealership.pojo.Car;


//As an employee, I can view all payments.
//As an employee, I can remove a car from the lot.
//As an employee, I can accept or reject a pending offer for a car.
//As an employee, I can add a car to the lot.


public class EmployeeApp {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static CarDAO dao = new CarDAO();


	public static void employeeMenu() throws Exception{
		String option = "";
		do {
			System.out.println("A. View Cars");
			System.out.println("B. Add Car");
			System.out.println("C. Update Car");
			System.out.println("D. Delete Car");
			System.out.println("E. Search Car");
			System.out.println("F. View Customers and remaining Payments");
			System.out.println("G. Accept/Deny Offers");
			System.out.println("H. Exit");
			System.out.println("==========================================================================");
			System.out.println("Enter an option");
			System.out.println("==========================================================================");
			option = br.readLine();
			System.out.println("\n");
			switch (option.toUpperCase()) {
			case "A":
				viewCar();
				break;
			case "B":
				addCar();
				break;
			case "C":
				updateCar();
				break;
			case "D":
				deleteCar();
				break;
			case "E":
				searchCar();
				break;
			case "F":
				viewPayments();
				break;
			case "G:":
				acceptDeny();
			break;
			case "H":
				System.out.println("*********************THANK YOU**************************");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Option!!.Please enter again");
				break;
			}
		} while (option != "F");
	}

	private static void acceptDeny() {
	// TODO Auto-generated method stub
	
}

	private static void viewPayments() {
	// TODO Auto-generated method stub
	
}

	public static void viewCar() {
		System.out.println("------------------------------------");
		List<Car> carList = dao.getAllCars();
		for (Car car : carList) {
			displayCar(car);
		}
		System.out.println("------------------------------------");
		System.out.println("\n");
	}

	public static void addCar() throws Exception {
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
		
		Car car = new Car(brand, model, price,id);
		int status = dao.addCar(car);
		if (status == 1) {
			System.out.println("Car added successfully");
		} else {
			System.out.println("ERROR while adding car");
		}
		System.out.println("\n");
	}

	public static void updateCar() throws Exception {
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
		
		Car car = new Car (brand, model, price,id);
		int status = dao.updateCar(car);
		if (status == 1) {
			System.out.println("Car updated successfully");
		} else {
			System.out.println("ERROR while updating car");
		}
		System.out.println("\n");
	}

	public static void deleteCar() throws Exception {
		System.out.println("------------------------------------");
		System.out.println("Enter Product ID:");
		System.out.println("------------------------------------");
		String carId = br.readLine();
		int status = dao.deleteCar(carId);
		if (status == 1) {
			System.out.println("Car deleted successfully ");
		} else {
			System.out.println("ERROR while deleting product");
		}
		System.out.println("\n");
	}

	public static void searchCar() throws Exception {
		System.out.println("------------------------------------");
		System.out.println("Enter Car ID:");
		System.out.println("------------------------------------");
		String carId = br.readLine();
		Car car = dao.getCarById(carId);
		displayCar(car);
		System.out.println("\n");
	}

	public static void displayCar(Car car) {
		System.out.println("Car Brand: " + car.getBrand());
		System.out.println("Car Model: " + car.getModel());
		System.out.println("Car Price: " + car.getPrice());
		System.out.println("\n");
	}
}
