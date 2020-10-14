package com.payroll.EmployeeApplication;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class TestDBConnection 
{
	public static void main(String[] args) throws SQLException
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet result = null;
		PreparedStatement psmt = null;
		//1.to get driver class instance - using the java.lang.class
			try {
				
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				System.out.println("Driver object successfully created.......");
			
			//2.To obtain database connection
				conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=", "sa", "password_123");
				System.out.println("Connection complete...");
				}
				catch (ClassNotFoundException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 	
	}
}

			