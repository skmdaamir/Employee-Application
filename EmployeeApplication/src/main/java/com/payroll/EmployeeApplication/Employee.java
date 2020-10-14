package com.payroll.EmployeeApplication;

public class Employee 
{
	private int id;
	private String name;
	private String gender;
	private double salary;
	
	
	//parametrized constructor
	public Employee(int id, String name, String gender, double salary) 
	{
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.salary = salary;
	}
	
	//default constructor
	public Employee() 
	{

	}

	//get set method
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getGender() 
	{
		return gender;
	}
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	public double getSalary() 
	{
		return salary;
	}
	public void setSalary(double salary) 
	{
		this.salary = salary;
	}
	
	public String toString() 
    { 
        return id + " " + name + " " + salary + " " + gender + " " ; 
    } 
	

}
