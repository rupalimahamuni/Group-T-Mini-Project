package com.group_t.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserRegistration implements ECommerce {
	
	PreparedStatement ps = null;
	Connection con = null;
	static String username,password;
	
	@Override
	public void userRegistration(String firstName, String lastName, String username, String password ) {
	
		try {
			ConnectionDetails details = new ConnectionDetails();
			con = details.getConnectionDetails();
			ps = con.prepareStatement("INSERT INTO users (firstname, lastname, username, password) VALUES (?,?,?,?)");
			
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, username);
			ps.setString(4, password);
			
			int i = ps.executeUpdate();
			System.out.println("Record updated...");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void userSignUp() {
		
		Scanner sc = new Scanner(System.in); 
		System.out.println("Are you New Customer ? Please write YES or NO ");
		String str = sc.nextLine();
		if("YES".equalsIgnoreCase(str)) {
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter FirstName ");
		String str1 = sc1.nextLine();
		
		System.out.println("Enter LastName ");
		String str2 = sc1.nextLine();
		
		System.out.println("Enter Username ");
		String str3 = sc1.nextLine();
		
		System.out.println("Enter Password ");
		String str4 = sc1.nextLine();
		userRegistration(str1, str2, str3, str4);
	}else {
		userLogin();
	}
	}
	
	
	@Override
	public void userLogin() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Username ");
		username = sc.nextLine();
		
		System.out.println("Enter Password ");
		password = sc.nextLine();
		
		try {
			
			ConnectionDetails details = new ConnectionDetails();
			con = details.getConnectionDetails();
			ps = con.prepareStatement("SELECT * FROM users");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			if((username.equals(rs.getString(3))) && (password.equals(rs.getString(4)))) {
				System.out.println("checked");
			}
			else {
				System.out.println("invalid");
			}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void adminLogin() {
	
		
	}

	public static void main(String[] args) {
		
		UserRegistration userRegistration = new UserRegistration();
		userRegistration.userSignUp();
	}

	@Override
	public void signUp() {
		
		
	}

}
