package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection;

    // Static block to initialize connection
    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute SELECT queries
    public static ResultSet executeQuery(String query) {
        try {
            PreparedStatement stmt = connection.prepareStatement(query); // Prepare statement
            ResultSet rs = stmt.executeQuery(); // Execute query
            return rs; // Return result set
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to execute INSERT, UPDATE, DELETE queries
    public static int executeUpdate(String query) {
        try {
            PreparedStatement stmt = connection.prepareStatement(query); // Prepare statement
            return stmt.executeUpdate(); // Execute update
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Method to get the connection
    public static Connection getConnection() {
        return connection;
    }
}
