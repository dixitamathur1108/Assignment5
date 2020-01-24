package com.ecommerce.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		try {
			
			pre=con.prepareStatement("update customer set address=?,email=?,phone=? where cus_id=?");
			pre.setString(1,c.getAddress());
			pre.setString(2,c.getEmail());
			pre.setString(3,c.getPhone());
			pre.setInt(4,c.getId());
			
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
