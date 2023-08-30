package com.olmechanicapp.model;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String emailid;
	private long mobileNo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Customer(int id, String firstName, String lastName, String address, String emailid, long mobileNo) {
		//super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailid = emailid;
		this.mobileNo = mobileNo;
	}
	public Customer(String firstName, String lastName, String address, String emailid, long mobileNo) {
		//super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailid = emailid;
		this.mobileNo = mobileNo;
	}
	
	
	public Customer(int id) {
		//super();
		this.id = id;
	}
	public Customer() {
		//super();
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", emailid=" + emailid + ", mobileNo=" + mobileNo + "]";
	}
	
	

}
