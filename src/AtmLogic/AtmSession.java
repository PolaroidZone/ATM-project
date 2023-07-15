package AtmLogic;

import JDBCon.DatabaseConnector;

///the Atm session consists of the session creation which is the login and the session termination which is the logout
public class AtmSession {
    private boolean loggedIn;
    private Account currentAccount;
    private DatabaseConnector database;
    public AtmSession() {
        loggedIn = false;
        currentAccount = null;
    }

    public boolean login(String userId, int pin) {
        // Check if the user is already logged in
        if (loggedIn) {
            System.out.println("User is already logged in. Please logout first.");
            return false;
        }else if (DatabaseConnector.getConnection() == null){
            System.out.println("There is no database connection.");
            return false;
        } else {
            currentAccount = new Account(userId, pin);
            loggedIn = true;
            System.out.println("Login successful.");
            return true;
        }

        // TODO: Implement logic to verify the user's credentials
        // For example, check if the userId and pin match with an existing account in the bank

        // Assuming the verification process is successful

    }

    public void logout() {
        if (loggedIn) {
            // Perform any necessary cleanup or session termination steps
            loggedIn = false;
            currentAccount = null;
            System.out.println("Logout successful.");
            DatabaseConnector.closeConnection();
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

}
