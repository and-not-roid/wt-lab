package com.example.jdbc;

import java.sql.*;

public class SelectJDBC {

	public static void main(String[] args) {
		
		try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Oracle JDBC Driver Registered!");

            // Establish connection
            Connection connection = DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:XE", "system", "123");
            System.out.println("Connected to Oracle Database!");

            // Create Statement object
            Statement statement = connection.createStatement();

            // Execute SELECT query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Salgrade");

            // Process the result set
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString("Grade") + " " +
                                resultSet.getString("Lsal") + " " +
                                resultSet.getString("Hsal"));
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Connection closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
