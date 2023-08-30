package com.olappointment.dao;

import java.sql.SQLException;

import java.util.List;


import com.olappointment.exception.CustomerNotFoundException;

import com.olmechanicapp.model.Customer;


public interface CustomerDao {
	
	Customer findById(int customerId) throws CustomerNotFoundException, SQLException; 
	boolean insert(Customer customer) throws SQLException;
	List<Customer> displayAllCustomer() throws SQLException;




	
	
	boolean update(Customer customer) throws SQLException;
	
	boolean deleteCus(Customer customer) throws SQLException;

}