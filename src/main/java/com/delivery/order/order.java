package com.delivery.order;
//import package

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class order {
	public static void main(String[] args)throws Exception { // don't have the private public? why straight to driver
		
		Scanner sc=new Scanner(System.in);  
		
		System.out.println("***********************************");
		System.out.println("           Delivery Expert         ");
		System.out.println("***********************************");
		
		//Enter date and validate the data format
		System.out.println("Please enter the date (dd/MM/yyyy): ");
		String sDate1 = sc.nextLine(); 		
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		System.out.println("You have entered: "+ sDate1);
		System.out.println("***********************************");
		
		
		//Enter pick up address
		System.out.println("Please enter the pickup address: ");
		String Paddress = sc.nextLine();
		System.out.println("You have entered: "+ Paddress);
		System.out.println("***********************************");
		
		
		//Enter pickup pos code and validate the pos code
		System.out.println("Please enter the pickup postcode: ");
		int Pcode = sc.nextInt();	
		
		if (Pcode >= 40000 && Pcode <= 68100) {
			
			System.out.println(Pcode + " is a valid postcode.");
			System.out.println("***********************************");
		}
		else {
			
			System.out.println(Pcode + " is an invalid postcode. Exit Program.");
			System.exit(0);
		}
	
		
		//Enter delivery address
		System.out.println("Please enter the delivery address: ");
		sc.nextLine();
		String Daddress = sc.nextLine();
		System.out.println("You have entered: "+ Daddress);
		System.out.println("***********************************");
		
		
		//Enter delivery pos code and validate the pos code
		System.out.println("Please enter the delivery postcode: ");
		int Dcode = sc.nextInt();
		System.out.println("You have entered: "+ Dcode);
		sc.nextLine();
		
		if (Dcode >= 40000 && Pcode <= 68100) {
			
			System.out.println(Dcode + " is a valid postcode.");
			System.out.println("***********************************");
		}
		else {
			
			System.out.println(Dcode + " is an invalid postcode. Exit Program.");
			System.exit(0);
		}
	
		
		
		//Enter 1 or 2 to choose Parcel or Document
		System.out.println("Please choose the item type: ");
		System.out.println("1. Parcel");
		System.out.println("2. Document");
		int choice = sc.nextInt();
		
		switch (choice) {
        case 1:
        	System.out.println("You have selected Parcel."); 
            break;
        case 2:
        	System.out.println("You have selected Document."); 
            break;
        default:
        	System.out.println("Invalid Input. Exit Program."); 
        	System.exit(0);
		}
		System.out.println("***********************************");
		
		
		//Enter the item weight in grams
		System.out.println("Please enter the item weight (g): ");
		double weight = sc.nextDouble();
		System.out.println("You have entered: "+ weight+ " g"); 
		System.out.println("***********************************");
		
		
		//Enter distance and need to be limit to 100km
		System.out.println("Please enter the distance (km): ");
		double distance = sc.nextDouble();
		
		if (distance <= 100) {
			System.out.println("You have entered: "+ distance + " km");
			System.out.println("***********************************");
		}
		else {
			System.out.println("Exceed the limit of 100 km. Exit Program.");
			System.exit(0);
		}
		
		
		//Whether want to add same day delivery fee
		System.out.println("Additional RM10.00 for same day delivery. (y/n)");
		sc.nextLine();
		String decision1 = sc.nextLine();
		
		if (decision1.equals("y")) {
			System.out.println("You have entered: "+ decision1);
			System.out.println("***********************************");
		} 
		
		else if(decision1.equals("n")) {
			System.out.println("You have entered: "+ decision1);
			System.out.println("***********************************");
		}
		
		else {
			System.out.println("Invalid Input. Exit Program.");
			System.out.println("***********************************");
			System.exit(0);
		}
		
		
		
		//Whether want to add delivery insurance
		System.out.println("Additional RM15.00 for delivery insurance. (y/n)");
		String decision2 = sc.nextLine();
		
		if (decision2.equals("y")) {
			System.out.println("You have entered: "+ decision2);
			System.out.println("***********************************");
		} 
		
		else if(decision2.equals("n")) {
			System.out.println("You have entered: "+ decision2);
			System.out.println("***********************************");
		}
		
		else {
			System.out.println("Invalid Input. Exit Program.");
			System.out.println("***********************************");
			System.exit(0);
		}
		
		
		//Call the calculation method
		double final_total =  Calculate(choice, weight, distance, decision1, decision2);
		
		
		//Print out the total charges
		System.out.println("Total charges is RM " + final_total);
		System.out.println("***********************************");
		

		}
		

		
		
	
	static double Calculate(int C_choice, double C_weight, double C_distance, String C_decision1, String C_decision2) {

		double C_total = 0;

		if (C_choice == 1) {
			
			//Parcel  < 1001g
			if (C_weight < 1001) {
				
				if (C_distance < 10) {
					C_total = 5;
				}
				else if (C_distance >= 10 && C_distance <= 30) {
					C_total = 8;
				}
				else {
					C_total = 10;
				}
				
			}
			
			
			//Parcel  1001g - 2000g
			if (C_weight >= 1001 && C_weight <=2000) {
				
				if (C_distance < 10) {
					C_total = 15;
				}
				else if (C_distance >= 10 && C_distance <= 30) {
					C_total = 18;
				}
				else {
					C_total = 25;
				}
				
			}
			
			
			//Parcel  2001g - 3000g
			if (C_weight >= 2001 && C_weight <= 3000) {
				
				if (C_distance < 10) {
					C_total = 23;
				}
				else if (C_distance >= 10 && C_distance <= 30) {
					C_total = 28;
				}
				else {
					C_total = 35;
				}
				
			}
			
			
			//Parcel  3001g - 5000g
			if (C_weight >=3001 && C_weight <=5000) {
				
				if (C_distance < 10) {
					C_total = 35;
				}
				else if (C_distance >= 10 && C_distance <= 30) {
					C_total = 40;
				}
				else {
					C_total = 50;
				}
				
			}
			
			
			
			//Parcel  > 5000g
			if (C_weight > 5000) {
				
				if (C_distance < 10) {
					C_total = 45;
				}
				else if (C_distance >= 10 && C_distance <= 30) {
					C_total = 50;
				}
				else {
					C_total = 60;
				}
				
			}
		
			
			if (C_decision1.equals("y")) {
				
				C_total = C_total + 10;
			}
			
			if (C_decision2.equals("y")) {
				
				C_total = C_total + 15;
			}
			
			return C_total;
			
			
			
		}		
		else {
			
			
			
			//Document  < 300g
			if (C_weight < 1001) {
				C_total = 3;
			}
			
			
			//Document  300g - 1000g
			if (C_weight >= 300 && C_weight <=1000) {
				
				if (C_distance < 10) {
					C_total = 4;
				}
				else if (C_distance >= 10 && C_distance <= 30) {
					C_total = 5;
				}
				else {
					C_total = 6;
				}
				
			}
			
			
			//Document  1001g - 3000g
			if (C_weight >= 2001 && C_weight <= 3000) {
				
				if (C_distance < 10) {
					C_total = 6;
				}
				else if (C_distance >= 10 && C_distance <= 30) {
					C_total = 8;
				}
				else {
					C_total = 10;
				}
				
			}
			
			
			//Document  3001g - 5000g
			if (C_weight >=3001 && C_weight <=5000) {
				
				if (C_distance < 10) {
					C_total = 12;
				}
				else if (C_distance >= 10 && C_distance <= 30) {
					C_total = 18;
				}
				else {
					C_total = 25;
				}
				
			}
			
			
			
			//Document  > 5000g
			if (C_weight > 5000) {
				
				if (C_distance < 10) {
					C_total = 25;
				}
				else if (C_distance >= 10 && C_distance <= 30) {
					C_total = 30;
				}
				else {
					C_total = 35;
				}
				
			}
			
			
			
			if (C_decision1 == "y") {
				
				C_total = C_total + 10;

			}
			
			if (C_decision2 == "y") {
				
				C_total = C_total + 15;

			}
			
			return C_total;		
			
		}
			
			
			
	}
			
		
		
}
		
		
		
		
		
		
