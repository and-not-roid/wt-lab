package com.example.jdbc;

import java.sql.*;

public class udatableJDBC {
    public static void main(String[] args) {
    	
        // Database connection details
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String password = "123";

        // SQL query to execute
        String query = "SELECT * FROM Salgrade";

        // Initialize Connection, Statement, and ResultSet
        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Oracle JDBC Driver Registered!");

            // Establish connection
            try (
                    Connection connection = DriverManager.getConnection(url, user, password);
                    // Create an updatable ResultSet
                    Statement statement = connection.createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
                    ResultSet resultSet = statement.executeQuery(query);) {
                System.out.println("Connected to Oracle Database!");

                // Navigate through the ResultSet
                System.out.println("\n--- Forward Direction ---");
                while (resultSet.next()) {
                    displayRow(resultSet);
                }

                System.out.println("\n--- Backward Direction ---");
                while (resultSet.previous()) {
                    displayRow(resultSet);
                }

                System.out.println("\n--- Absolute Positioning (Row 2) ---");
                if (resultSet.absolute(2)) {
                    displayRow(resultSet);
                }

                // Update a row in the ResultSet
                System.out.println("\n--- Update Row (Row 2) ---");
                if (resultSet.absolute(2)) {
                    resultSet.updateString("Grade", "NewGrade");
                    resultSet.updateRow();
                    System.out.println("Row updated successfully.");
                }

            } catch (SQLException e) {
                System.out.println("SQL Exception occurred");
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found");
            e.printStackTrace();
        }
    }

    /**
     * Utility method to display a row from the ResultSet.
     */
    private static void displayRow(ResultSet rs) throws SQLException {
        String grade = rs.getString("Grade");
        String lsal = rs.getString("Lsal");
        String hsal = rs.getString("Hsal");
        System.out.println("Grade: " + grade + ", Lsal: " + lsal + ", Hsal: " + hsal);
    }
}