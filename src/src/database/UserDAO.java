package database;

import java.sql.*;

// UserDAO class handles user-related database operations like login and registration
public class UserDAO {

    // Method to authenticate user login
    public String loginUser(String username, String password) {
        String role = null; // will store role (Admin/User)

        try {
            // Get database connection
            Connection conn = DBConnection.getConnection();

            // SQL query to check username and password
            String sql = "SELECT role FROM users WHERE username=? AND password=?";
            PreparedStatement pst = conn.prepareStatement(sql);

            // Set values in query
            pst.setString(1, username);
            pst.setString(2, password);

            // Execute query
            ResultSet rs = pst.executeQuery();

            // If user exists, get role
            if (rs.next()) {
                role = rs.getString("role");
            }

            // Close connection
            conn.close();

        } catch (Exception e) {
            e.printStackTrace(); // Print error if occurs
        }

        return role; // returns Admin/User/null
    }

    // Method to register a new user
    public boolean registerUser(String username, String password, String role) {
        boolean isInserted = false; // flag to check success

        try {
            // Get database connection
            Connection conn = DBConnection.getConnection();

            // 🔹 Check if username already exists
            String checkSql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, username);

            ResultSet rs = checkStmt.executeQuery();

            // If username exists, return false
            if (rs.next()) {
                return false;
            }

            // 🔹 Insert new user with role
            String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, role);

            // Execute insert query
            int rows = pst.executeUpdate();

            // Check if insertion successful
            if (rows > 0) {
                isInserted = true;
            }

            // Close resources
            pst.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace(); // Print error
        }

        return isInserted; // return result
    }
}