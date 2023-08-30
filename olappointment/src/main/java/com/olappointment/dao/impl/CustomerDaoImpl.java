package com.olappointment.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.olappointment.dao.CustomerDao;
import com.olappointment.exception.AppointmentNotFoundException;
import com.olappointment.exception.CustomerNotFoundException;
import com.olappointment.util.DbUtil;
import com.olmechanicapp.model.Appointment;
import com.olmechanicapp.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
	//display all record query
			private final static String SELECT_ALL = "SELECT * FROM CUSTOMER";
			
			
			//display single record query using id 
			private final static String SELECT_BY_ID = "SELECT * FROM CUSTOMER WHERE id=?";
			
			
			//Customer registration(insert query)
			private final static String INSERT = "insert into customer(firstName,lastName,address, emailid, mobileNo) values(?,?,?,?,?)";
			
			
			//Modify query
			private final static String UPDATE = "UPDATE CUSTOMER SET firstName=?, lastName=?, address=?, emailid=?, mobileNo=? WHERE id=?";
			
			
			//Delete query
			private final static String DELETE = "DELETE FROM CUSTOMER WHERE id = ? ";
			

			private Connection connection = DbUtil.getConnection();

		    @Override
		    public List<Customer> displayAllCustomer() throws SQLException {
		        List<Customer> customers = new ArrayList<>();
		        Statement stmt = connection.createStatement(); 
		        ResultSet rs = stmt.executeQuery(SELECT_ALL);
		        
		        while (rs.next()) {
		            Customer customer = new Customer();
		            // Reading the data from the row and setting the data to the Customer object
		            customer.setId(rs.getInt("id"));
		            customer.setFirstName(rs.getString("firstName"));
		            customer.setLastName(rs.getString("lastName"));
		            customer.setAddress(rs.getString("address"));
		            customer.setEmailid(rs.getString("emailid"));
		            customer.setMobileNo(rs.getLong("mobileNo")); // Use consistent case
		            // Adding to the list
		            customers.add(customer);
		        }
		        rs.close();
		        stmt.close();
		        return customers;
		    }


		    @Override
		    public Customer findById(int CustomerId) throws CustomerNotFoundException, SQLException {
		        Customer customer = null;
		        PreparedStatement stmt = connection.prepareStatement(SELECT_BY_ID);
		        stmt.setInt(1, CustomerId);
		        ResultSet rs = stmt.executeQuery();
		        System.out.println("Rs  : "  + rs);
		        if (rs.next()) {
		            
		        	customer = new Customer();
		            customer.setId(rs.getInt("id"));
		            customer.setFirstName(rs.getString("firstName"));
		            customer.setLastName(rs.getString("lastName"));
		            customer.setAddress(rs.getString("address"));
		            customer.setEmailid(rs.getString("emailid"));
		            customer.setMobileNo(rs.getLong("mobileNo")); // Use consistent case
		        } else {
		            throw new CustomerNotFoundException("Customer Not Found With Id: " + CustomerId);
		        }
		        rs.close();
		        stmt.close();
		        return customer;
		    }
		    
			

			@Override
			public boolean insert (Customer customer) throws SQLException {
				boolean result=false;
				PreparedStatement stmt = connection.prepareStatement(INSERT);
				stmt.setString(1,customer.getFirstName() );
				stmt.setString(2,customer.getLastName() );
				stmt.setString(3,customer.getAddress() );
				stmt.setString(4,customer.getEmailid());
				stmt.setLong(5,customer.getMobileNo());
				if(stmt.executeUpdate()>0) {
					result = true;
				}
				stmt.close();
				return result;
			}
			
			
			@Override
			public boolean update(Customer customer) throws SQLException {
				PreparedStatement stmt = connection.prepareStatement(UPDATE);
				
				stmt.setString(1,customer.getFirstName() );
				stmt.setString(2,customer.getLastName() );
				stmt.setString(3,customer.getAddress() );
				stmt.setString(4, customer.getEmailid());
				stmt.setLong(5, customer.getMobileNo());
				stmt.setInt(6,customer.getId() );
				
				int updated = stmt.executeUpdate();
				stmt.close();
				
				return updated > 0;	
				
		}
			
			//@Override
			public boolean deleteCustomer(Customer customer) throws SQLException {
				PreparedStatement stmt = connection.prepareStatement(DELETE);
		        stmt.setInt(1, customer.getId());
				
				int deleted = stmt.executeUpdate();
				
				stmt.close();
				return deleted > 0;

		}


			
			
			//@Override
			public boolean deleteCus(Customer customer) throws SQLException {
				PreparedStatement stmt = connection.prepareStatement(DELETE);
		        stmt.setInt(1, customer.getId());
				
				int deleted = stmt.executeUpdate();
				
				stmt.close();
				return deleted > 0;

		}



 
}
