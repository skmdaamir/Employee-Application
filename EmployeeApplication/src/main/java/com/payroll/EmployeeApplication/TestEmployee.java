package com.payroll.EmployeeApplication;

public class TestEmployee 
{
	public static void main(String[] args) 
	{
		Employee e = new Employee(4, "Rock", "M", 2000);
		System.out.println(e);
		EmployeeImplementation e1 = new EmployeeImplementation();
		
		e1.startconnection();
		
		//e1.AddEmployee(e);
		
		System.out.println(e1.FindEmployye(6));
		
		//e1.DeleteEmployee(5);
		
		//e1.UpdateEmployee(e);
		
		e1.ProcedureEmployee();
		
		
		
		e1.PrintEmployee();
		
	}

}
