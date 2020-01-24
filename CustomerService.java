package com.ecommerce.customer;

import java.sql.ResultSet;

public interface CustomerService {

	public boolean createCustomer(Customer c);
	public ResultSet validateCustomer(int cid,String name);
	public boolean updateCustomer(Customer c);
	public boolean deleteCustomer(Customer c);
	public ResultSet displayCustomer();
}
