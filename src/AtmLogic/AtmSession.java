package AtmLogic;


import static JDBCon.DatabaseConnector.*;

///the Atm session consists of the session creation which is the login and the session termination which is the logout
public class AtmSession {
    private boolean loggedIn;
    private Account currentAccount;
    public AtmSession() {
        loggedIn = false;
        currentAccount = null;
    }

    public boolean login(String userId, int pin) {

        getConnection();

        // Check if the user is already logged in
        if (getConnection() == null) {
            System.out.println("There is no database connection.");
            return false;
        }else if (loggedIn){
            System.out.println("User is already logged in. Please logout first.");
            return true;
        } else {
            try {
                if (validateUser(Integer.parseInt(userId), pin)) {
                    loggedIn = true;
                    currentAccount = new Account(userId, pin);
                    System.out.println("Login successful.");
                    return true;
                } else {
                    System.out.println("Invalid user credentials.");
                    closeConnection();
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Error validating user." + e);
                closeConnection();
                return false;
            }
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
            closeConnection();
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
