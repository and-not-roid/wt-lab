package com.example.jdbc;

import java.sql.*;



public class procedureJDBC {
    public static void main(String[] args) {
        Connection connection = null;
        CallableStatement callableStatement = null;

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

            // Enable DBMS_OUTPUT
            Statement statement = connection.createStatement();
            statement.execute("BEGIN DBMS_OUTPUT.ENABLE(); END;");

            // Prepare the callable statement to call DBMS_OUTPUT.PUT_LINE
            String plsqlBlock = "{call DBMS_OUTPUT.PUT_LINE(?)}";
            callableStatement = connection.prepareCall(plsqlBlock);

            // Set the message to be printed
            callableStatement.setString(1, "Hello from DBMS_OUTPUT!");

            // Execute the PL/SQL block
            callableStatement.execute();

            // Retrieve and print the output
            callableStatement = connection.prepareCall("{call DBMS_OUTPUT.GET_LINE(?, ?)}");
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.registerOutParameter(2, Types.INTEGER);

            while (true) {
                callableStatement.execute();
                String line = callableStatement.getString(1);
                int status = callableStatement.getInt(2);

                if (status == 1) break; // No more lines

                System.out.println(line);
            }

        } catch (Exception e) {
            System.out.println("Error occurred while accessing DBMS_OUTPUT");
            e.printStackTrace();
        } finally {
            try {
                if (callableStatement != null) callableStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}