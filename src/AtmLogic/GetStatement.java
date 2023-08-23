package AtmLogic;

import JDBCon.DatabaseConnector;

//This class contains a method that gets the users account bank statement
public class GetStatement {

    public GetStatement() {
    }

    public static Double getAccountBalance(String accountId) {
        // TODO: Implement logic to retrieve the user's bank statement
        // For example, fetch transaction history or account details from a database
        if (DatabaseConnector.getConnection() == null) {
            System.out.println("Error generating statement");
            return 0.0;
        }  else {
            System.out.println("Statement: " + DatabaseConnector.getBalance(Integer.parseInt(accountId)));
            return DatabaseConnector.getBalance(Integer.parseInt(accountId));
        }
        // Display the statement or perform any other necessary actions
    }

    public static BankAccount getAccountStatement(String accountId) {
        // TODO: Implement logic to retrieve the user's bank statement
        DatabaseConnector.getConnection();
        if (DatabaseConnector.getConnection() == null) {
            System.out.println("Error generating statement");
            return null;
        }  else {
            BankAccount account = DatabaseConnector.getStatement(Integer.parseInt(accountId));
            System.out.println("Statement: " + account);
            DatabaseConnector.closeConnection();
            return account;
        }
    }

}
