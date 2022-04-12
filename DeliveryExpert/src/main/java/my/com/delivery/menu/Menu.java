package my.com.delivery.menu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import my.com.delivery.user.User;
import my.com.delivery.user.UserDAO;
import my.com.delivery.order.DeliveryStaff;
import my.com.delivery.order.Order;
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
					System.out.println("***********************************");
					System.out.println("           Delivery Expert         ");
					System.out.println("***********************************");

					System.out.println("Enter user phone number: ");
					userPhoneNum = scanner.nextLine(); // need to do checking if user exist or not
					
					//if (userPhoneNum == user.getPhoneNum())
			
					// Enter date and validate the data format
					System.out.println("Please enter the delivery date (dd/MM/yyyy): ");
					String sDate1 = scanner.nextLine();

					try {
						Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
					} catch (Exception e) {

					}

					// Enter pick up address
					System.out.println("Please enter the pickup address: ");
					String Paddress = scanner.nextLine();

					// Enter pickup pos code and validate the pos code
					int Pcode;
					do {
						System.out.println("Please enter the pickup postcode: ");
						Pcode = scanner.nextInt();

						if (Pcode <= 40000 || Pcode >= 68100) 
							System.out.println(Pcode + " is an invalid postcode. Please try again.");
							
						else
							break;
											
					} while (true);

					

					// Enter delivery address
					System.out.println("Please enter the delivery address: ");
					scanner.nextLine();
					String Daddress = scanner.nextLine();

					// Enter delivery pos code and validate the pos code
					int Dcode;
					do {
						System.out.println("Please enter the delivery postcode: ");
						Dcode = scanner.nextInt();

						if (Dcode <= 40000 || Dcode >= 68100) 
							System.out.println(Dcode + " is an invalid postcode. Please try again.");
					
						else
							break;
											
					} while (true);

					// Enter 1 or 2 to choose Parcel or Document	
					String item;

					do {
						System.out.println("Please choose the item type: ");
						System.out.println("1. Parcel");
						System.out.println("2. Document");
						int itemChoice = scanner.nextInt();

						if (itemChoice == 1) {
								System.out.println("You have selected Parcel.");
								item = "Parcel";
								break;
						}
						else if (itemChoice == 2){
								System.out.println("You have selected Document.");
								item = "Document";
								break;
						}
						else{
								System.out.println("Invalid Input. Please try again.");
								
						}
					} while (true);

					// Enter the item weight in grams
					System.out.println("Please enter the item weight (g): ");
					double weight = scanner.nextDouble();

					double distance = 0;
					// Enter distance and need to be limit to 100km
					do {
						System.out.println("Please enter the distance (km): ");
						distance = scanner.nextDouble();
						scanner.nextLine();
						
						if (distance > 100)
							System.out.println("Exceed the limit of 100 km. Please try again.");

						else
							break;

					} while (true);

					// Whether want to add same day delivery fee
					boolean sameDayDelivery = false;
					do {
						System.out.println("Additional RM10.00 for same day delivery. (y/n)");
						String decision1 = scanner.nextLine();

						if (decision1.equals("y")) {
							decision1 = "Yes";
							sameDayDelivery = true;
							break;
						}

						else if (decision1.equals("n")) {
							decision1 = "No";
							break;
						}

						else {
							System.out.println("Invalid Input. Please try again.");

						}
					} while (true);

					// Whether want to add delivery insurance
					boolean insurance = false;
					
					do{
					System.out.println("Additional RM15.00 for delivery insurance. (y/n)");
					String decision2 = scanner.nextLine();
					

					if (decision2.equals("y")) {
						decision2 = "Yes";
						insurance = true;
						break;
					}

					else if (decision2.equals("n")) {
						decision2 = "No";
						break;
					}

					else {
						System.out.println("Invalid Input. Please try again.");
					}
					}while(true);
					
					Order newOrder = new Order(sDate1, Paddress, Daddress, sameDayDelivery, insurance, Pcode, Dcode, item,
							weight, distance);

					newOrder.toString();

					// Assign delivery staff
					System.out.print("Enter delivery staff's name: ");
					String name = scanner.nextLine();
					System.out.print("Enter delivery staff's number: ");
					String num = scanner.nextLine();
					
					DeliveryStaff staff = new DeliveryStaff(name, num);
					staff.toString();
					newOrder.setStaff(staff);
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
