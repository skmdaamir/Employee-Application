package com.payroll.EmployeeApplication;

import java.util.Collection;

public interface EmployeeDAO

{
	Employee FindEmployye(int id);
	
	void AddEmployee(Employee e);
	
	void UpdateEmployee(Employee e);
	
	void DeleteEmployee(int id);
	
	void PrintEmployee();
	
	void ProcedureEmployee();
	
	Collection<Employee> SortByNameEmployee();
	
	

}
