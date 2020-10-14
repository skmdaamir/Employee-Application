package com.payroll.EmployeeApplication;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class EmployeeImplementation implements EmployeeDAO
{
	Connection conn = null;
	Statement stmt = null;
	ResultSet result = null;
	PreparedStatement psmt = null;
	
	
	
	
	

	public Employee FindEmployye(int id) 
	{
		System.out.println("====================================================================================================");
		Employee e = new Employee();
		
		try 
		{
			
			psmt=conn.prepareStatement("Select * FROM Employee.Employee WHERE E_id = (?)");
			
			psmt.setInt(1,id);	
			
			result = psmt.executeQuery();
			while(result.next()) {
				e.setId(result.getInt(1));
				e.setName(result.getString(2));
				e.setSalary(result.getDouble(3));
				e.setGender(result.getString(4));
			}
			
			
			System.out.println("Record find...");
			
		} 
		catch (SQLException ex) 
		{
			// TODO Auto-generated catch block
			
			System.out.println("The id you enter is not in database");
		}
	
		return e;
	}

	public void AddEmployee(Employee e) 
	{
		System.out.println("====================================================================================================");
	
		try {
			psmt =conn.prepareStatement("insert into Employee.Employee (E_id,E_Name,E_Salary,Gender) Values (?, ? ,? , ? )");
			psmt.setInt(1, e.getId());
			psmt.setString(2, e.getName());
			psmt.setDouble(3, e.getSalary());
			psmt.setString(4, e.getGender());
			
			psmt.executeUpdate();
			
			System.out.println("Reord Inserted....");
			
		} 
		catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	public void UpdateEmployee(Employee e) 
	{
		System.out.println("====================================================================================================");

		try 
		{
			psmt= conn.prepareStatement("UPDATE Employee.Employee SET E_Name = (?), E_Salary = (?), Gender = (?) WHERE E_Id = (?)");
			
			
			psmt.setString(1, e.getName());
			psmt.setDouble(2, e.getSalary());
			psmt.setString(3, e.getGender());
			psmt.setInt(4, e.getId());
			
			psmt.executeUpdate();
			
			System.out.println("Reord Update....");
		}
		catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	public void DeleteEmployee(int id) 
	{
		System.out.println("====================================================================================================");

		try 
		{
			psmt = conn.prepareStatement("DELETE FROM Employee.Employee WHERE E_id = ?");
			psmt.setInt(1, id);
			psmt.executeUpdate();
			
			System.out.println("Reord Delete....");
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void PrintEmployee() 
	{
		System.out.println("====================================================================================================");

		try 
		{
			stmt = conn.createStatement();
			result=stmt.executeQuery("SELECT * FROM Employee.Employee");
			
			while (result.next())			//look whether row is available then return true/false
			{
				int i =result.getInt(1);
				String name = result.getString(2);
				double d=result.getDouble(3);
				String gen = result.getString(4);

				
				System.out.println(i + " " + name + " " + d + " " + " "+ gen );
			}	 
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public Collection<Employee> SortByNameEmployee() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	public void startconnection() 
	{
		System.out.println("====================================================================================================");

		
		try 
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Employee", "sa", "password_123");
			System.out.println("Connection complete...");
		} 
		
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

		
		
	}

	public void ProcedureEmployee() 
	{

		System.out.println("====================================================================================================");
		CallableStatement stmt;
		try {
			stmt = conn.prepareCall("{call ForFemaleEmployees(?)}");
			 
			stmt.setString(1,"F");  
			stmt.execute();

			System.out.println("success"); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  
		
	}

}	
	


