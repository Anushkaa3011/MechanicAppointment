package com.olmechanicapp.model;

import java.util.Date;

public class Appointment {
		private int appointmentId;
		private Date date;
		private String name;
		private String serviceRequired;
		private int vehicleNo;
		private int id;
		
		
		
		
		public int getAppointmentId() {
			return appointmentId;
		}
		public void setAppointmentId(int appointmentId) {
			this.appointmentId = appointmentId;
		}
		
		
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
 		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getServiceRequired() {
			return serviceRequired;
		}
		public void setServiceRequired(String serviceRequired) {
			this.serviceRequired = serviceRequired;
		}
		
		
		public int getVehicleNo() {
			return vehicleNo;
		}
		public void setVehicleNo(int vehicleNo) {
			this.vehicleNo = vehicleNo;
		}
		
		
		public Appointment(int appointmentId, Date date, int customerId, String name, String serviceRequired, int vehicleNo) {
			//super();
			this.appointmentId = appointmentId;
			this.date = date;
			//this.customerId = customerId;
			this.name = name;
			this.serviceRequired = serviceRequired;
			this.vehicleNo = vehicleNo;
		}
		public Appointment(Date date, String name, String serviceRequired, int vehicleNo) {
			//super();
			this.date = date;
			//this.customerId = customerId;
			this.name = name;
			this.serviceRequired = serviceRequired;
			this.vehicleNo = vehicleNo;
			
			
		}
		
		
	 
		public Appointment(Date date, String name, String serviceRequired, int vehicleNo, int id) {
			super();
			this.date = date;
			this.name = name;
			this.serviceRequired = serviceRequired;
			this.vehicleNo = vehicleNo;
			this.id = id;
		}
		public Appointment(int id) {
			//super();
			this.id = id;
		}
		public Appointment() {
			//super();
		}
		@Override
		public String toString() {
			return "Appointment [appointmentId=" + appointmentId + ", date=" + date + ", name=" + name
					+ ", serviceRequired=" + serviceRequired + ", vehicleNo=" + vehicleNo + "]";
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		
		
		
		
		
		
		
		
		
		
		


}
