package com.example.jdbc;

import java.sql.*;

public class insertJDBC {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Oracle JDBC Driver Registered!");

            // Establish connection
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "123");
            System.out.println("Connected to Oracle Database!");

            // Create Statement object
            statement = connection.createStatement();

            // Execute SELECT query
            String query = "SELECT * FROM JDBC_TEST";
            resultSet = statement.executeQuery(query);

            System.out.println("Before inserting data");

            // Process the result set
            while (resultSet.next()) {
                String myid = resultSet.getString("myid");
                String name = resultSet.getString("name");
                String place = resultSet.getString("place");
                System.out.println("myid: " + myid + ", name: " + name + ", place: " + place);
            }

            // Insert data
            PreparedStatement pstmtInsert = connection.prepareStatement("INSERT INTO JDBC_TEST VALUES(?,?,?)");
            pstmtInsert.setString(1, "102");
            pstmtInsert.setString(2, "Alice");
            pstmtInsert.setString(3, "USA");
            pstmtInsert.executeUpdate();
            System.out.println("Data inserted");

            // Update data
            PreparedStatement pstmtUpdate = connection.prepareStatement("UPDATE JDBC_TEST SET name = ?, place = ? WHERE myid = ?");
            pstmtUpdate.setString(1, "Bob");
            pstmtUpdate.setString(2, "Canada");
            pstmtUpdate.setString(3, "102");
            pstmtUpdate.executeUpdate();
            System.out.println("Data updated");

            // Delete data
            PreparedStatement pstmtDelete = connection.prepareStatement("DELETE FROM JDBC_TEST WHERE myid = ?");
            pstmtDelete.setString(1, "101");
            pstmtDelete.executeUpdate();
            System.out.println("Data deleted");

            // Re-execute SELECT query to see changes
            resultSet = statement.executeQuery(query);
            System.out.println("After modifications");
            while (resultSet.next()) {
                String myid = resultSet.getString("myid");
                String name = resultSet.getString("name");
                String place = resultSet.getString("place");
                System.out.println("myid: " + myid + ", name: " + name + ", place: " + place);
            }
        } catch (Exception e) {
            System.out.println("Oracle JDBC Driver not found");
            e.printStackTrace();
        
        }
    }
}
   