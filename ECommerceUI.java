package com.ecommerce.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ECommerceUI {

	Customer c=new Customer();
	Scanner sc=new Scanner(System.in);
	CustomerService service;

	public ECommerceUI()
	{
		//sc=new Scanner(System.in);
		
		service=new CustomerServiceImplementation();
	}
	public void registerCustomer()
	{
		System.out.println("Enter Customer id.");
		c.setId(sc.nextInt());
		System.out.println("Enter Customer Name.");
		c.setName(sc.next());
		System.out.println("Enter Customer email.");
		c.setEmail(sc.next());
		System.out.println("Enter Customer address.");
		c.setAddress(sc.next());
		System.out.println("Enter Customer Mobileno.");
		c.setPhone(sc.next());
		if(service.createCustomer(c))
			System.out.println("Customer registered successfully...");
		else
			System.out.println("Customer Not registered ...");
	}
	
	public void updateCustomer()
	{
		/*
		 * System.out.println("Enter Customer id."); c.setId(sc.nextInt());
		 * System.out.println("Enter Customer email."); c.setEmail(sc.next());
		 * System.out.println("Enter Customer address."); c.setAddress(sc.next());
		 * System.out.println("Enter Customer Mobileno."); c.setPhone(sc.next());
		 */
		System.out.println("Enter Customer id.");
		c.setId(sc.nextInt());
		if(service.updateCustomer(c))
			System.out.println("Customer updated successfully...");
		else
			System.out.println("Customer Not updated ...");
		
		
	}
	
	public void deleteCustomer()
	{
		System.out.println("Enter Customer id.");
		c.setId(sc.nextInt());
		if(service.deleteCustomer(c))
			System.out.println("Customer deleted successfully...");
		else
			System.out.println("Customer Not deleted...");
	}
	
	public void validateCustomer()
	{
		System.out.println("Enter Customer id.");
		int id=sc.nextInt();
		System.out.println("Enter customer name:");
		String name=sc.next();
		ResultSet res=service.validateCustomer(id,name);
		try {
			if(res.next()!=false)
				System.out.println("Welcom!! You are logged in.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void displayCustomer()
	{
		ResultSet res=service.displayCustomer();
		try {
			while(res.next())
			{
				System.out.println();
				System.out.print("\t"+res.getInt(1));
				System.out.print("\t"+res.getString(2));
				System.out.print("\t"+res.getString(3));
				System.out.print("\t"+res.getString(4));
				System.out.print("\t"+res.getString(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		//Customer c=new Customer();
		String ch=null;
		ECommerceUI e=new ECommerceUI();
		while(true)
		{
			System.out.println();
			System.out.println("Enter Your Choice");
			System.out.println("1. Registring New Customer");
			System.out.println("2. Login as Existing Customer");
			System.out.println("3. Update existing customer");
			System.out.println("4. Delete existing customer");
			System.out.println("5. Display details of customer");
			System.out.println("6. Exit");
			ch=sc.next();
			switch(ch)
			{
				case "1":
				{
					e.registerCustomer();
					break;
				}
				case "2":
				{
					e.validateCustomer();
					break;
				}
				case "3":
				{
					e.updateCustomer();
					break;
				}
				case "4":
				{
					e.deleteCustomer();
					break;
				}
				case "5":
				{
					e.displayCustomer();
					break;
				}
				case "6":
				{
					System.out.println("Thank You");
					System.exit(0);
				}
			}
		}
	
	}

}
