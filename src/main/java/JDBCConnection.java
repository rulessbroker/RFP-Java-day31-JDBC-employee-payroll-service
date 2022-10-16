package main.java;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class JDBCConnection {
	public static Connection connectToDatabase() throws SQLException {

		String DBName = "payroll_service";
		String URL = "jdbc:mysql://localhost:3306/" + DBName;
		String dbUserName = "root";
		String dbPass = "Rahul@123";
		Connection con = DriverManager.getConnection(URL, dbUserName, dbPass);
		Connection connection;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("can't find the driver in the classpath!");
		}

		try {
			connection = DriverManager.getConnection(URL, dbUserName, dbPass);

			return connection;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unused")
	private static void listDrivers() {
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = driverList.nextElement();
			System.out.println(driverClass.getClass().getName() + " ");
		}
	}
}
