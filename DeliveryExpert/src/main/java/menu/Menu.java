package main.java.menu;

import java.util.Scanner;

import main.java.order.order;
import main.java.user.User;
import main.java.user.UserDAO;

public class Menu {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to DeliveryExpert system");
		System.out.println("===============MENU===============");
		System.out.println("1. Add New User");
		System.out.println("2. New Delivery Order");
		System.out.println("3. Print Delivery Note");
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
				
			case 2:
			try {
				order.main(args);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			case 3:
				
				break;
			default:
				break;
		}
	}

}
