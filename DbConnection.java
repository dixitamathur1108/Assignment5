package com.ecommerce.customer;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	static Connection con;
	
	public static Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/d1","dixita","45924@Mysql98291");
			System.out.println("Database Connected....");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}

}
