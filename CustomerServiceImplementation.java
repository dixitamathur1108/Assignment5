package com.ecommerce.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CustomerServiceImplementation implements CustomerService{
	
	Connection con;
	PreparedStatement pre;

	int ra;
	ResultSet res;
	boolean flag=false;
	public CustomerServiceImplementation()
	{
		con=DbConnection.getConnection();
	}

	//Register a New Customer
	public boolean createCustomer(Customer c)
	{
		try {
			
			pre=con.prepareStatement("insert into customer values(?,?,?,?,?)");
			pre.setInt(1,c.getId());
			pre.setString(2,c.getName());
			pre.setString(3,c.getEmail());
			pre.setString(4,c.getAddress());
			pre.setString(5,c.getPhone());
			
			ra=pre.executeUpdate();
			if(ra>0)
					flag=true;
			else
				flag=false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public ResultSet validateCustomer(int cid,String name)
	{
		try {
			pre=con.prepareStatement("select * from customer where cus_id=? and name=?");
			pre.setInt(1,cid);
			pre.setString(2, name);
			res=pre.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public boolean updateCustomer(Customer c)
	{
		Scanner sc=new Scanner(System.in);
		int id;
		String address=null,email=null,phone=null;
		try {
			 
			pre=con.prepareStatement("select * from customer where cus_id=?");
			pre.setInt(1, c.getId());
			res=pre.executeQuery();
			while(res.next())
			{
				//id=res.getInt(1);
				address=res.getString(3);
				email=res.getString(4);
				phone=res.getString(5);
			}
			System.out.println("Do you want to update address?(press 1 for yes , 0 for no)");
			int addoption=sc.nextInt();
			if(addoption==1)
			{
				System.out.println("Enter new address:");
				address=sc.next();
			}
			
			System.out.println("Do you want to update email?(press 1 for yes , 0 for no)");
			int emailoption=sc.nextInt();
			if(emailoption==1)
			{
				System.out.println("Enter new email:");
				email=sc.next();
			}
			
			System.out.println("Do you want to update phone no.?(press 1 for yes , 0 for no)");
			int phoneoption=sc.nextInt();
			if(phoneoption==1)
			{
				System.out.println("Enter new phone no.:");
				phone=sc.next();
			}
			
			pre=con.prepareStatement("update customer set address=?,email=?,phone=? where cus_id=?");
			pre.setString(1,address); 
			pre.setString(2,email);
			pre.setString(3,phone);
			pre.setInt(4,c.getId());
			ra=pre.executeUpdate(); 
			if(ra>0) 
				flag=true;
			else 
				flag=false;
			System.out.println(flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
		}

	public boolean deleteCustomer(Customer c)
	{
		try {
			
			pre=con.prepareStatement("delete from customer where cus_id=?");
			pre.setInt(1,c.getId());
			
			ra=pre.executeUpdate();
			if(ra>0)
					flag=true;
			else
				flag=false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
		}
	
	public ResultSet displayCustomer()
	{
		try {
			pre=con.prepareStatement("select * from customer");
			res=pre.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
}
