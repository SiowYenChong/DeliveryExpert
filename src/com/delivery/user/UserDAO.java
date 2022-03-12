package com.delivery.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	public boolean addUser(User user) {
		boolean result = false;
		List<User>userList = getAllUsers();
		for(User user1: userList) {
			if(user1.getEmail().equals(user.getEmail()) || user1.getPhoneNum().equals(user.getPhoneNum())) {
				System.out.println("User's email or phone number is already exist.");
				return false;
			}
		}
		try {
			FileOutputStream f = new FileOutputStream(new File("users.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
			List <User> users = new ArrayList<>();
			users.add(user);
			// Write objects to file
			o.writeObject(users);

			o.close();
			f.close();
			result = true;
		}catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;	
	}
	public User getUserByPhoneNum(String phoneNum) {
		User user = null;
		try {
		FileInputStream fi = new FileInputStream(new File("users.txt"));
		ObjectInputStream oi = new ObjectInputStream(fi);
		// Read objects
		
		List <User> userList = (List <User>) oi.readObject();
		for(User user1 : userList) {
			if(user1.getPhoneNum().equals(phoneNum)) {
				user = user1;
			}
		}
		}catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	public List<User> getAllUsers() {
		List <User> userList = new ArrayList<>();
		try {
		FileInputStream fi = new FileInputStream(new File("users.txt"));
		ObjectInputStream oi = new ObjectInputStream(fi);
		// Read objects
		
		userList = (List <User>) oi.readObject();
		
		}catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	public static void main(String[] args) {
		User u1 = new User("Claire", "123@gmail.com", "01023455", "Malaysia");
		User u2 = new User("Maryam", "124@gmail.com", "01303455", "India");
		User u3 = new User("Koon", "125@gmail.com", "01323455", "Malaysia");
		
		UserDAO userDao = new UserDAO();
		boolean add1 = userDao.addUser(u1);
		boolean add2 = userDao.addUser(u2);
		boolean add3 = userDao.addUser(u3);
		
		System.out.println(add1 + " " + add2 + " " + add3);
		System.out.println(userDao.getUserByPhoneNum("01023455"));
		System.out.println(userDao.getUserByPhoneNum("01303455"));
		/*
		try {
			FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(p1);
			o.writeObject(p2);

			o.close();
			f.close();

			FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			Person pr1 = (Person) oi.readObject();
			Person pr2 = (Person) oi.readObject();

			System.out.println(pr1.toString());
			System.out.println(pr2.toString());

			oi.close();
			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 */
	}
	
	
}
