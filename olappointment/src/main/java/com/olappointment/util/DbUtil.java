package com.olappointment.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private final static String DRIVER_CLASS= "";
	private final static String URL="jdbc:mysql://localhost:3306/olappointment";
	private final static String USERNAME="root";
	private final static String PASSWORD="@nU_2001";
	private static Connection connection=null;
	public static Connection getConnection() {
		try {
			connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connection Success....");
		} catch (SQLException e) {
			System.err.println("Connection Not Established...");
			System.err.print(e);
		}
		return connection;
	}
	/*
	 * public static void main(String[] args) {
	 * System.out.println(DbUtil.getConnection()); }
	 */

}
