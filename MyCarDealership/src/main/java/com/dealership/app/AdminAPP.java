package com.dealership.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.dealership.dao.OfferDAO;
import com.dealership.pojo.Offer;

//• As the system, I update a car to an owned state when an offer is accepted.
//• As the system, I reject all other pending offers for a car when an offer is accepted.
//• As the system, I can calculate the monthly payment.
public class AdminAPP {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static OfferDAO dao = new OfferDAO();

	public static void adminMenu()throws Exception{
		String option = "";
		do {
			System.out.println("A. Update car to owned state");
			System.out.println("B. Reject all pending offers");
			System.out.println("C. Calculate Monthly Payment");
			System.out.println("D. Exit");
			option = br.readLine();
			System.out.println("\n");
			switch(option.toUpperCase()) {
			case "A":
				udpateToOwned();
				break;
			case "B":
				rejectAll();
				break;
			case "C":
				calculatePayment();
				break;
				default:
					System.out.println("Invalid option! Please try again");
					break;
			}
		}while (option !="D");
	}

	private static void calculatePayment() {
		// TODO add logic to calculate payemnt and mod subsequent classese
		System.out.println("Your monthly payment is 30000/72");
		
	}

	private static void rejectAll() throws Exception{
		OfferApp.viewOffer();
		
		System.out.println("------------------------------------");
		System.out.println("Enter accepted or denied:");
		System.out.println("------------------------------------");
		String acceptedDenied = br.readLine();


		Offer offer = new Offer(acceptedDenied);
		int status = dao.updateAllOffers(offer);
		if (status == 1) {
			System.out.println("All offers have been denied");
		} else {
			System.out.println("ERROR while updating offer");
		}
		System.out.println("\n");
		
	}

	private static void udpateToOwned() {
		//TODO add logic to this method
		System.out.println("Car is owned");
		
	}
}
