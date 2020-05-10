package com.dealership.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.dealership.dao.OfferDAO;
import com.dealership.pojo.Offer;

public class OfferApp {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static OfferDAO dao = new OfferDAO();

	public static void offerMenu() throws Exception {
		String option = "";
		do {
			System.out.println("A. Create Offer (add offer)");
			System.out.println("B. View Offer");
			System.out.println("C. Counter Offer (Update Offer)");
			System.out.println("D. Delete Offer");
			System.out.println("E. Search Offer");
			System.out.println("F. Accept/Deny Offers");
			System.out.println("G. Exit");
			System.out.println("==========================================================================");
			System.out.println("Enter an option");
			System.out.println("==========================================================================");
			option = br.readLine();
			System.out.println("\n");
			switch (option.toUpperCase()) {
			case"A":
				addOffer();
				break;
			case "B":
				viewOffer();
				break;
			case "C":
				updateOffer();
				break;
			case "D":
				deleteOffer();

				break;
			case "E":
				searchOffer();
				break;
			case "F":
				acceptDeny();
				break;
			case "G":
				System.out.println("*********************THANK YOU**************************");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Option!!.Please enter again");
				break;
			}
		} while (option != "F");
	}

	private static void viewOffer() {
		System.out.println("----------------------");
		List<Offer> offerList = dao.getAllOffers();
		for (Offer offer : offerList) {
			displayOffer(offer);
		}
		System.out.println("------------------------------------");
		System.out.println("\n");
	}

	private static void displayOffer(Offer offer) {
		System.out.println("Offer Price: " + offer.getPrice());
		System.out.println("Offer Payment: " + offer.getPayement());
		System.out.println("Car ID: " + offer.getCarId());
		System.out.println("\n");

	}

	private static void updateOffer() throws Exception {
		System.out.println("------------------------------------");
		System.out.println("Enter Offer Price:");
		System.out.println("------------------------------------");
		String price = br.readLine();
		System.out.println("------------------------------------");
		System.out.println("Enter Offer Payment:");
		System.out.println("------------------------------------");
		String payment = br.readLine();
		System.out.println("------------------------------------");
		System.out.println("Enter Offer carId:");
		System.out.println("------------------------------------");
		int carId = Integer.parseInt(br.readLine());

		Offer offer = new Offer(price, payment, carId);
		int status = dao.updateOffer(offer);
		if (status == 1) {
			System.out.println("Offer updated successfully");
		} else {
			System.out.println("ERROR while updating offer");
		}
		System.out.println("\n");

	}
public static void addOffer()throws Exception{
	System.out.println("------------------------------------");
	System.out.println("Enter desired car price:");
	System.out.println("------------------------------------");
	String price = br.readLine();
	System.out.println("------------------------------------");
	System.out.println("Enter desired Monthly Payment:");
	System.out.println("------------------------------------");
	String payment = br.readLine();
	System.out.println("------------------------------------");
	System.out.println("Enter CarId:");
	System.out.println("------------------------------------");
	int carId = Integer.parseInt(br.readLine());
	
	Offer offer = new Offer(price, payment,carId);
	int status = dao.addOffer(offer);
	if (status == 1) {
		System.out.println("Offer added successfully");
	} else {
		System.out.println("ERROR while adding offer");
	}
	System.out.println("\n");
}
	private static void deleteOffer() throws Exception {
		System.out.println("------------------------------------");
		System.out.println("Enter Offer ID:");
		System.out.println("------------------------------------");
		String carId = br.readLine();
		int status = dao.deleteOffer(carId);
		if (status == 1) {
			System.out.println("Offer deleted successfully ");
		} else {
			System.out.println("ERROR while deleting offer");
		}
		System.out.println("\n");
	}

	private static void searchOffer() throws Exception {
		System.out.println("------------------------------------");
		System.out.println("Enter Offer ID:");
		System.out.println("------------------------------------");
		String carId = br.readLine();
		Offer offer = dao.getOfferById(carId);
		displayOffer(offer);
		System.out.println("\n");
	}

	private static void acceptDeny() throws Exception {
		viewOffer();
		System.out.println("Please select offer to accept or deny");
		String carId = br.readLine();
		System.out.println("Press A to accept or D to deny, press 0 to exit");
		String option = br.readLine();

		switch (option) {
		case "A":
			System.out.println("Offer has been Accepted");
			break;
		case "B":
			System.out.println("Offer has been denied");
			break;
		default:
			System.exit(0);
		}

	}
}
