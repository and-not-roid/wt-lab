package com.example.jdbc;

import java.sql.*;

public class metaDataJDBC {
    public static void main(String[] args) {
        Connection connection = null;

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

            // Get DatabaseMetaData object
            DatabaseMetaData dbMetaData = connection.getMetaData();

            // Retrieve and print database metadata
            System.out.println("Database Product Name: " + dbMetaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + dbMetaData.getDatabaseProductVersion());
            System.out.println("Database Driver Name: " + dbMetaData.getDriverName());
            System.out.println("Database Driver Version: " + dbMetaData.getDriverVersion());

            // Retrieve and print table names
            ResultSet tables = dbMetaData.getTables(null, null, "%", new String[]{"TABLE"});
            System.out.println("Tables in the database:");
            while (tables.next()) {
                System.out.println(tables.getString("TABLE_NAME"));
            }

        } catch (Exception e) {
            System.out.println("Error occurred while accessing database metadata");
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}