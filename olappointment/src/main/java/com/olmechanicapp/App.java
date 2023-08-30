package com.olmechanicapp;

import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.olappointment.dao.AppointmentDao;
import com.olappointment.dao.CustomerDao;
import com.olappointment.dao.impl.AppointmentDaoImpl;
import com.olappointment.dao.impl.CustomerDaoImpl;
import com.olappointment.exception.AppointmentNotFoundException;
import com.olappointment.exception.CustomerNotFoundException;
import com.olmechanicapp.model.Appointment;
import com.olmechanicapp.model.Customer;

/**
 * Hello world!
 *
 */
public class App 
{	
	private static AppointmentDao appointmentdao = new AppointmentDaoImpl();
	private static CustomerDao dao = new CustomerDaoImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ParseException, SQLException {
        while (true) {
            System.out.println("************Enter Your choice************");
            System.out.println("1. Customers");
            System.out.println("2. Mechanic");
            System.out.println("3. Appointment");
            System.out.println("4. Service");
            System.out.println("5. Exit");
            
            // read the users choice and then proceeds to switch case
            int ch = Integer.parseInt(scanner.nextLine());
            
            switch (ch) {
            	//Customer
                case 1:
                    System.out.println("**** CUSTOMER Selection***");
                    System.out.println("1. Registration");
                    System.out.println("2. Display Single Record");
                    System.out.println("3. Delete Record");
                    System.out.println("4. Modify");
                    System.out.println("5. Display All");
                    System.out.println("6. Exit");
                    
                    int CUI = Integer.parseInt(scanner.nextLine());
                    
                    switch (CUI) {
                    
                    	//Registration
                        case 1:
                            System.out.println("**** Registration Started***");
                            regCustomer();
                            System.out.println("**** Registration Ended***");
                            break;
                        case 2:
                            System.out.println("**** Display Single Record ***");
                            findById();
                            System.out.println("**** Display Single Record **");
                            break;
                        case 3:
                            System.out.println("**** Delete Record***");
                            deleteCustomer();
                            System.out.println("**** Delete Record***");
                            break;
                        case 4:
                            System.out.println("***** Update Choice*****");
                            System.out.println("1. First Name");
                            System.out.println("2. Last Name");
                            System.out.println("3. Address");
                            System.out.println("4. Email");
                            System.out.println("5. Mobile No");
                            System.out.println("6. Exit");
                            
                            int UC = Integer.parseInt(scanner.nextLine());
                            
                            switch(UC) {
                            
	                            // Update First Name
	                            case 1:
	                            	System.out.println("******Update First Name******");
	                            	updateFirstName();
	                            	break;
	                            	
	                            // Update Last Name
	                            case 2:
	                            	System.out.println("******Update Last Name******");
	                            	updateLastName();
	                            	break;
	                            	
	                            // Update Address
	                            case 3:
	                            	System.out.println("******Update Address******");
	                            	updateAddress();
	                            	break;
	                            	
	                            // Update Email
	                            case 4:
	                            	System.out.println("******Update Email******");
	                            	updateEmail();
	                            	break;
	                            	
	                            // Update Mobile No
	                            case 5:
	                            	System.out.println("******Update Mobile No******");
	                            	updateMobileNo();
	                            	break;
	                            	
	                            case 6:
	                                System.exit(0);
	                            default:
	                                System.exit(0);
	                            	
	                     
	                            }
                            break;
                            
                        case 5:
                            System.out.println("**** Display All***");
                            displayAllCustomer();
                            System.out.println("**** Display All**");
                            break;
                        case 6:
                            System.exit(0);
                        default:
                            System.exit(0);
                    }
                    break;
                case 3:
                    System.out.println("**** APPOINTMENT Selection***");
                    System.out.println("1. Book An Appointment");
                    System.out.println("2. Modify Appointment Details");
                    System.out.println("3. Delete An Appointment");
                    System.out.println("4. View Single Record");
                    System.out.println("5. View All Record");
                    System.out.println("6. Exit");
                    
                    int AUI = Integer.parseInt(scanner.nextLine());
                    
                    switch (AUI) {
                        case 1:
                            System.out.println("**** Book An Appointment ***");
                            regAppointment();
                            break;
                        case 2:
                        	 System.out.println("***** Update Choice*****");
                             System.out.println("1. Date");
                             System.out.println("2. Name");
                             System.out.println("3. Service Required");
                             System.out.println("4. Vehicle No");
                             System.out.println("5. Exit");
                         
                             
                             int UC = Integer.parseInt(scanner.nextLine());
                             
                             switch(UC) {
                             
 	                            // Update Date
 	                            case 1:
 	                            	System.out.println("******Update Date******");
 	                            	updateDate();
 	                            	break;
 	                            	
 	                            // Update Name
 	                            case 2:
 	                            	System.out.println("******Update Name******");
 	                            	updateName();
 	                            	break;
 	                            	
 	                            // Update Vehicle No
 	                            case 3:
 	                            	System.out.println("******Update Service Required******");
 	                            	updateServiceRequired();
 	                            	break;
 	                            	
 	                            case 4:
	                            	System.out.println("******Update Vehicle No******");
	                            	updateVehicleNo();
	                            	break;
 	                            	
                        		case 5:
                        			System.exit(0);
                        			default:
                        			System.exit(0);
                        			}
                             break;
                    
                            
                        case 3:
                            System.out.println("**** Delete An Appointment***");
                            deleteAppointment();
                            break;
                        case 4:
                            System.out.println("**** View Single Record ***");
                            appfindById();
                            break;
                        case 5:
                            System.out.println("**** View All Record ***");
                            displayAllAppointment();
                            break;
                        case 6:
                            System.exit(0);
                        default:
                            System.exit(0);
                    }
                    break;
                // Add cases for Mechanic and Service if needed
                case 5:
                    System.exit(0);
                default:
                    System.exit(0);
            }
        }
    }

   
	private static void regCustomer() {
        System.out.println("\nEnter First Name:");
        String firstName = scanner.nextLine();
        System.out.println("\nEnter Last Name:");
        String lastName = scanner.nextLine();
        System.out.println("\nEnter Address:");
        String address = scanner.nextLine();
        System.out.println("\nEnter Emailid:");
        String emailid = scanner.nextLine();
        System.out.println("\nEnter MobileNo:");
        long mobileno = Long.parseLong(scanner.nextLine());

        Customer customer = new Customer(firstName, lastName, address, emailid, mobileno);
        try {
            if (dao.insert(customer)) {
                System.out.println("Inserted");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

		// To View Single record
    private static void findById() {
        System.out.println("\nEnter Id:");
        int customerId = Integer.parseInt(scanner.nextLine());
        try {
            Customer findById = dao.findById(customerId);
            System.out.println(findById);
        } catch (CustomerNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }

    private static void displayAllCustomer() {
        try {
            List<Customer> displayAllCustomer = dao.displayAllCustomer();
            for (Customer customer : displayAllCustomer) {
                System.out.println(customer);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
 // method for modify customer details
 	private static void updateFirstName() {
 		// TODO Auto-generated method stub
 		System.out.println("\nEnter Customer Id:");
         int customerId = Integer.parseInt(scanner.nextLine());
         
         System.out.println("\nEnter New First Name:");
         String firstName = scanner.nextLine();

         try {
         	//call findbyid method from customerDaoImpl to find provided id 
             Customer customer = dao.findById(customerId);
             //if id is correct it will give option to update new first name
             customer.setFirstName(firstName);
             
             //Call update method from CustomerDaoImpl class to update customer first name
             if (dao.update(customer)) {
             	//if first name is update successfully it will print first name update Successfully Message 
                 System.out.println("First Name Update Successfully");
             }
         } catch (CustomerNotFoundException | SQLException e) {
             System.err.println(e);
         }
 		
 	}
 	
 	private static void updateLastName() {
 		// TODO Auto-generated method stub
 		System.out.println("\nEnter Customer Id:");
         int customerId = Integer.parseInt(scanner.nextLine());
         System.out.println("\nEnter New Last Name:");
         String lastName = scanner.nextLine();

         try {
             Customer customer = dao.findById(customerId);
             customer.setLastName(lastName);

             if (dao.update(customer)) {
                 System.out.println("Update Successfully");
             }
         } catch (CustomerNotFoundException | SQLException e) {
             System.err.println(e);
         }
 		
 	}
 	
 	private static void updateAddress() {
 		// TODO Auto-generated method stub
 		System.out.println("\nEnter Customer Id:");
         int customerId = Integer.parseInt(scanner.nextLine());
         System.out.println("\nEnter New Address:");
         String address = scanner.nextLine();

         try {
             Customer customer = dao.findById(customerId);
             customer.setAddress(address);

             if (dao.update(customer)) {
                 System.out.println("Update Successfully");
             }
         } catch (CustomerNotFoundException | SQLException e) {
             System.err.println(e);
         }
 		
 	}
 	
 	private static void updateEmail() {
 		// TODO Auto-generated method stub
 		System.out.println("\nEnter Customer Id:");
         int customerId = Integer.parseInt(scanner.nextLine());
         System.out.println("\nEnter New Emailid:");
         String emailid = scanner.nextLine();

         try {
             Customer customer = dao.findById(customerId);
             customer.setEmailid(emailid);

             if (dao.update(customer)) {
                 System.out.println("Update Successfully");
             }
         } catch (CustomerNotFoundException | SQLException e) {
             System.err.println(e);
         }
 		
 	}
 	
 	private static void updateMobileNo() {
 		// TODO Auto-generated method stub
 		System.out.println("\nEnter Customer Id:");
         int customerId = Integer.parseInt(scanner.nextLine());
         System.out.println("\nEnter New Mobile No:");
         Long mobileNo = Long.parseLong(scanner.nextLine());

         try {
             Customer customer = dao.findById(customerId);
             customer.setMobileNo(mobileNo);

             if (dao.update(customer)) {
                 System.out.println("Update Successfully");
             }
         } catch (CustomerNotFoundException | SQLException e) {
             System.err.println(e);
         }
 		
 	}
 	
 	private static void deleteCustomer() {
    	System.out.println("\nEnter ID:");
        int id = Integer.parseInt(scanner.nextLine());
        Customer customer = new Customer(id);
        
        try {
            if (dao.deleteCus(customer)) {
                System.out.println("Deleted");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
}
 	
 	






// ---------------------------APPOINTMENT-----------------------------
 	private static void regAppointment() throws ParseException {
        System.out.println("\nEnter Date:");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
    	String strDate = scanner.nextLine();
    	Date date = sdf.parse(strDate);
       
        System.out.println("\nEnter Name:");
        String name = scanner.nextLine();
        System.out.println("\nEnter Service Required:");
        String serviceRequired = scanner.nextLine();
        System.out.println("\nEnter Vehicle No:");
        int vehicleNo = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter ID:");
        int id = Integer.parseInt(scanner.nextLine());
        

        Appointment appointment = new Appointment(date, name, serviceRequired, vehicleNo, id);
        try {
            if (appointmentdao.bookappointment(appointment)) {
                System.out.println("Inserted");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private static void appfindById() {
        System.out.println("\nEnter Appointment Id:");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        try {
            Appointment appfindById = appointmentdao.appfindById(appointmentId);
            System.out.println(appfindById);
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }

    private static void displayAllAppointment() {
        try {
            List<Appointment> displayAllAppointment = appointmentdao.displayAllAppointment();
            for (Appointment appointment : displayAllAppointment) {
                System.out.println(appointment);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
     }
        
    private static void deleteAppointment() throws SQLException {
    	System.out.println("\nEnter Customer ID:");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        Appointment appointment = new Appointment(appointmentId);
        
        try {
        	if (appointmentdao.deleteAppointment(appointment)) {
		    System.out.println("Deleted");
		}
        }catch (SQLException e) {
        	System.err.println(e);
        }
    }
    
 // method for modify appointment details
 	private static void updateDate() throws ParseException {
 		// TODO Auto-generated method stub
 		System.out.println("\nEnter Appointment Id:");
         int appointmentId = Integer.parseInt(scanner.nextLine());
         
         System.out.println("\nEnter New Date:");
         
         SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd") ;
     	String strDate1 = scanner.nextLine();
     	Date date1 = sdf1.parse(strDate1);
        

         try {
         	//call findbyid method from customerDaoImpl to find provided id 
        	 Appointment appointment = appointmentdao.appfindById(appointmentId);
             //if id is correct it will give option to update new first name
        	 appointment.setDate(date1);
             
             //Call update method from CustomerDaoImpl class to update customer first name
             if (appointmentdao.updateApp(appointment)) {
             	//if date is update successfully it will print date update Successfully Message 
                 System.out.println(" Date Update Successfully");
             }
         } catch (AppointmentNotFoundException | SQLException e) {
             System.err.println(e);
         }
 		
 	}
 	
 	private static void updateName() {
 		// TODO Auto-generated method stub
 		System.out.println("\nEnter Appointment Id:");
         int appointmentId = Integer.parseInt(scanner.nextLine());
         System.out.println("\nEnter Name:");
         String name = scanner.nextLine();

         try {
        	 Appointment appointment = appointmentdao.appfindById(appointmentId);
        	 appointment.setName(name);

             if (appointmentdao.updateApp(appointment)) {
                 System.out.println("Update Successfully");
             }
         } catch (AppointmentNotFoundException | SQLException e) {
             System.err.println(e);
         }
 		
 	}
 	
 	private static void updateServiceRequired() {
 		// TODO Auto-generated method stub
 		System.out.println("\nEnter Appointment Id:");
         int appointmentId = Integer.parseInt(scanner.nextLine());
         System.out.println("\nEnter New Service Required:");
         String serviceRequired = scanner.nextLine();

         try {
        	 Appointment appointment = appointmentdao.appfindById(appointmentId);
        	 appointment.setServiceRequired(serviceRequired);

             if (appointmentdao.updateApp(appointment)) {
                 System.out.println("Update Successfully");
             }
         } catch (AppointmentNotFoundException | SQLException e) {
             System.err.println(e);
         }
 		
 	}
 	
 	private static void updateVehicleNo() {
 		// TODO Auto-generated method stub
 		System.out.println("\nEnter Id:");
         int appointmentId = Integer.parseInt(scanner.nextLine());
         System.out.println("\nEnter New Vehicle No:");
         int vehicleNo = Integer.parseInt(scanner.nextLine());

         try {
        	 Appointment appointment = appointmentdao.appfindById(appointmentId);
        	 appointment.setVehicleNo(vehicleNo);

             if (appointmentdao.updateApp(appointment)) {
                 System.out.println("Update Successfully");
             }
         } catch (AppointmentNotFoundException | SQLException e) {
             System.err.println(e);
         }
 		
 	}
 	
 	
 	
 	
}
