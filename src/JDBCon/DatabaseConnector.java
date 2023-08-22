package JDBCon;

import java.sql.*;

public class DatabaseConnector {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cse_atm";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database.");
            return connection;
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to close the database connection.");
            e.printStackTrace();
        }
    }

    public static boolean createUser(int userId, int pin) {
        String query = "INSERT INTO users (userId, pin) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            statement.setInt(2, pin);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Returns true if at least one row was affected, indicating successful user creation
        } catch (SQLException e) {
            System.out.println("Error creating user.");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean validateUser(int userId, int pin) {
        String query = "SELECT * FROM users WHERE userId = ? AND pin = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            statement.setInt(2, pin);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Returns true if the user exists, false otherwise
        } catch (SQLException e) {
            System.out.println("Error validating user.");
            e.printStackTrace();
            return false;
        }
    }


    public static boolean createBankAccount(int accountId, int userId, double balance) {
        String query = "INSERT INTO bank_accounts (accountId, userId, balance) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, accountId);
            statement.setInt(2, userId);
            statement.setDouble(3, balance);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Returns true if at least one row was affected, indicating successful account creation
        } catch (SQLException e) {
            System.out.println("Error creating bank account.");
            e.printStackTrace();
            return false;
        }
    }

    public static double getBankStatement(int accountId) {
        String query = "SELECT balance FROM bank_accounts WHERE accountId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, accountId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getDouble("balance");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving bank statement.");
            e.printStackTrace();
        }
        return 0.0; // Return 0.0 if the account or balance is not found
    }

    public static boolean depositFunds(int accountId, double amount) {
        String query = "UPDATE bank_accounts SET balance = balance + ? WHERE accountId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, amount);
            statement.setInt(2, accountId);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Returns true if at least one row was affected, indicating successful deposit
        } catch (SQLException e) {
            System.out.println("Error depositing funds.");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean withdrawFunds(int accountId, double amount) {
        String query = "UPDATE bank_accounts SET balance = balance - ? WHERE accountId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, amount);
            statement.setInt(2, accountId);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Returns true if at least one row was affected, indicating successful withdrawal
        } catch (SQLException e) {
            System.out.println("Error withdrawing funds.");
            e.printStackTrace();
            return false;
        }
    }


}
