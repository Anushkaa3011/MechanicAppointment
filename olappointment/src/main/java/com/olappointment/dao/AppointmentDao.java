package com.olappointment.dao;

import java.sql.SQLException;
import java.util.List;

import com.olappointment.exception.AppointmentNotFoundException;
import com.olmechanicapp.model.Appointment;

public interface AppointmentDao {
	
Appointment appfindById(int Id) throws AppointmentNotFoundException, SQLException; 
	
	List<Appointment> displayAllAppointment() throws SQLException;
	boolean bookappointment(Appointment appointment) throws SQLException;
	boolean updateApp(Appointment appointment) throws SQLException;
	boolean deleteAppointment(Appointment appointment) throws SQLException;

}
