package com.example.jdbc;

import java.sql.*;

public class resultSetJDBC {
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

            // Execute a query to get a ResultSet
            String query = "SELECT * FROM YOUR_TABLE_NAME"; // Replace with your table name
            resultSet = statement.executeQuery(query);

            // Get ResultSetMetaData object
            ResultSetMetaData rsMetaData = resultSet.getMetaData();

            // Retrieve and print ResultSet metadata
            int columnCount = rsMetaData.getColumnCount();
            System.out.println("Number of Columns: " + columnCount);

            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + ": " + rsMetaData.getColumnName(i) +
                                   " of type " + rsMetaData.getColumnTypeName(i));
            }

        } catch (Exception e) {
            System.out.println("Error occurred while accessing ResultSet metadata");
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}