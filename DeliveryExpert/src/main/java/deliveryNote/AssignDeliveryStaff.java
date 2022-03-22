package main.java.deliveryNote;
import java.util.*;

public class AssignDeliveryStaff {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter delivery staff's name: ");
		String name = scanner.nextLine();
		System.out.print("Enter delivery staff's number: ");
		String num = scanner.nextLine();
		
		DeliveryStaff staff = new DeliveryStaff(name, num);
	}
}
