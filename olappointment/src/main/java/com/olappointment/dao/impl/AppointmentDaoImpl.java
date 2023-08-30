package com.olappointment.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.olappointment.dao.AppointmentDao;
import com.olappointment.exception.AppointmentNotFoundException;
import com.olappointment.util.DbUtil;
import com.olmechanicapp.model.Appointment;

public class AppointmentDaoImpl implements AppointmentDao {
	
	//display all record query
	private final static String SELECT_ALL_APPOINMENT = "SELECT * FROM Appointment";
	
	//display single record query using id 
	private final static String SELECT_BY_ID_APPOINTMENT = "SELECT * FROM Appointment WHERE id=?";
	
	//Customer registration(insert query)
	private final static String INSERT_APPOINTMENT = "insert into Appointment(date,name,serviceRequired,vehicleNo,id) values(?,?,?,?,?)";
	
	//Modify query
	private final static String UPDATE_APPOINTMENT = "UPDATE Appointment SET date=?, name=?, serviceRequired=?, vehicleNo=? WHERE id=?";
	
	//Delete query
	private final static String DELETE_APPOINTMENT = "DELETE FROM Appointment WHERE id = ? ";
	
	private Connection connection = DbUtil.getConnection();

	
	public Appointment appfindById(int Id) throws AppointmentNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Appointment appointment = null;
        PreparedStatement stmt = connection.prepareStatement(SELECT_BY_ID_APPOINTMENT);
        stmt.setInt(1, Id);
        ResultSet rs = stmt.executeQuery();
        System.out.println("Rs  : "  + rs);
        if (rs.next()) {
            
        	appointment = new Appointment();
        	appointment.setAppointmentId(rs.getInt("id"));
        	appointment.setDate(rs.getDate("date"));
        	appointment.setName(rs.getString("Name"));
        	appointment.setServiceRequired(rs.getString("ServiceRequired"));
        	appointment.setVehicleNo(rs.getInt("vehicleNo"));
        	appointment.setId(rs.getInt("id"));
        	 // Use consistent case
        } else {
            throw new AppointmentNotFoundException("Customer Not Found With Id: " + Id);
        }
        rs.close();
        stmt.close();
        return appointment;
		}


	
	public boolean bookappointment(Appointment appointment) throws SQLException {
		// TODO Auto-generated method stub
		boolean result=false;
		PreparedStatement stmt = connection.prepareStatement(INSERT_APPOINTMENT);
		stmt.setDate(1, new java.sql.Date(appointment.getDate().getTime()));
		stmt.setString(2,appointment.getName() );
		stmt.setString(3,appointment.getServiceRequired() );
		stmt.setInt(4,appointment.getVehicleNo() );
		stmt.setInt(5,appointment.getId() );
		
		if(stmt.executeUpdate()>0) {
			result = true;
		}
		stmt.close();
		return result;
		
		
	}


	public List<Appointment> displayAllAppointment() throws SQLException {
		// TODO Auto-generated method stub
		List<Appointment> appointments = new ArrayList<>();
        java.sql.Statement stmt = connection.createStatement(); // Use java.sql.Statement here
        ResultSet rs = stmt.executeQuery(SELECT_ALL_APPOINMENT);
        
        while (rs.next()) {
            Appointment appointment = new Appointment();
            // Reading the data from the row and setting the data to the Customer object
            appointment.setAppointmentId(rs.getInt("id"));
        	appointment.setDate(rs.getDate("date"));
            appointment.setName(rs.getString("name"));
            appointment.setServiceRequired(rs.getString("serviceRequired"));
            appointment.setVehicleNo(rs.getInt("vehicleNo"));
            appointment.setId(rs.getInt("id"));
             // Use consistent case
            // Adding to the list
            appointments.add(appointment);
        }
        rs.close();
        stmt.close();
        return appointments;
		
	}
	
	public boolean updateApp(Appointment appointment) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(UPDATE_APPOINTMENT);
		stmt.setDate(1, new java.sql.Date(appointment.getDate().getTime())); 
			stmt.setString(2,appointment.getName() );
		stmt.setString(3, appointment.getServiceRequired());
		stmt.setInt(4, appointment.getVehicleNo());
		stmt.setInt(5, appointment.getId());
		 
		
		
		int updated = stmt.executeUpdate();
		stmt.close();
		
		return updated > 0;	
		
}
	
	//@Override
	public boolean deleteAppointment(Appointment appointment) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(DELETE_APPOINTMENT);
        stmt.setInt(1, appointment.getAppointmentId());
		
		int deleted = stmt.executeUpdate();
		
		stmt.close();
		return deleted > 0;

}

}
