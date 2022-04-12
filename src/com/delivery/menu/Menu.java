package com.delivery.menu;

import java.util.Scanner;
import com.delivery.user.User;
import com.delivery.user.UserDAO;

//phone num no exceed 11 digit
//email must come with @
//view user

//11 Test cases
/*
 * 1. Print menu
 * 2. Add user
 * 3. Add user with existing phone number
 * 4. Add user with existing email
 * 5. Add user with <10 digit phone number
 * 6. Add user with >11 digit phone number
 * 7. Add user with invalid email id
 * 8. View Users
 * 9. Menu Option (2)
 * 10. Exit Option
 * 11. Verify data after adding user
 * 
 * */

public class Menu {
	public static void printMenu() {
		System.out.println("Welcome to DeliveryExpert system");
		System.out.println("===============MENU===============");
		System.out.println("1. Add user");
		System.out.println("2. Menu");
		System.out.println("3. View users");
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
				default:
					System.out.println("Invalid option! Please try again");
					break;
			}
		}while(choice != 0);
	}

}
