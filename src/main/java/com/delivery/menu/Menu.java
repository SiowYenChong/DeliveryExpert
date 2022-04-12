package com.delivery.menu;

import java.util.Scanner;

import com.delivery.order.order;
import com.delivery.user.User;
import com.delivery.user.UserDAO;

//phone num no exceed 11 digit
//email must come with @
//view user


public class Menu {
	public static void printMenu() {
		System.out.println("Welcome to DeliveryExpert system");
		System.out.println("===============MENU===============");
		System.out.println("1. Add user");
		System.out.println("2. Menu");
		System.out.println("3. View users");
		System.out.println("4. New Delivery Order");
		System.out.println("5. Print Delivery Note");
		System.out.println("0. Exit");
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		printMenu();
		int choice = 0;
		
		/*123@gmail.com 012333*/
		UserDAO userDAO = new UserDAO();
		do{
			System.out.print("\n\nEnter your choice: ");
			choice = Integer.parseInt(scanner.nextLine());

			switch(choice) {
				case 1:
					System.out.println("Enter user name - ");
					String userName = scanner.nextLine();
					String userEmail = "";
					do {
						if(!userEmail.equals("") && !userEmail.contains("@")) {
							System.out.println("\nPlease enter valid email\n");
						}
						System.out.println("Enter user email - ");
						userEmail = scanner.nextLine();
					}while(!userEmail.contains("@"));
					
					System.out.println("Enter user address - ");
					String userAddress = scanner.nextLine();
					String userPhoneNum = "";
					do {
						if(!userPhoneNum.equals("") && (userPhoneNum.length()<10 && userPhoneNum.length()>11)) {
							System.out.println("\nPhone number should be 10/11 digits only\n");
						}
						System.out.println("Enter user phone number - ");
						userPhoneNum = scanner.nextLine();
						
						//int check
						
					}while(userPhoneNum.length()<10 && userPhoneNum.length()>11);
					
					User user = new User(userName, userEmail, userPhoneNum, userAddress);
					if(userDAO.addUser(user)) {
						System.out.println("User has been added successfully");
					}
					break;
				case 2:
					printMenu();
					break;
				case 0: 
					System.out.println("Exiting the application...");
					break;
				case 3:
					userDAO.showAllUsers();
					break;
				case 4:
					try {
						order.main(args);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 5:
					break;
				default:
					System.out.println("Invalid option! Please try again");
					break;
			}
		}while(choice != 0);
	}

}
