package com.delivery.menu;

import java.util.Scanner;

import com.delivery.user.User;
import com.delivery.user.UserDAO;

public class Menu {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to DeliveryExpert system");
		System.out.println("===============MENU===============");
		System.out.println("1. Add user");
		System.out.print("Insert input: ");
		int choice = Integer.parseInt(scanner.nextLine());
		
		/*123@gmail.com 012333*/
		UserDAO userDAO = new UserDAO();
		switch(choice) {
			case 1:
				
				System.out.println("Enter user name - ");
				String userName = scanner.nextLine();
				System.out.println("Enter user email - ");
				String userEmail = scanner.nextLine();
				System.out.println("Enter user address - ");
				String userAddress = scanner.nextLine();
				System.out.println("Enter user phone number - ");
				String userPhoneNum = scanner.nextLine();
				
				User user = new User(userName, userEmail, userPhoneNum, userAddress);
				if(userDAO.addUser(user)) {
					System.out.println("User has been added successfully");
				}
				break;
			default:
				break;
		}
	}

}
