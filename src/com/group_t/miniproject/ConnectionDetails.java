package com.group_t.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDetails {

Connection con = null;
	
	public Connection getConnectionDetails() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/details","root","root");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
