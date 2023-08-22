package AtmLogic;

import JDBCon.DatabaseConnector;

//This class contains a method that gets the users account bank statement
public class GetStatement {
    private Account account;
    private static AtmSession session;

    public GetStatement() {
    }

    public static Double getStatement(String accountId) {
        // TODO: Implement logic to retrieve the user's bank statement
        // For example, fetch transaction history or account details from a database
        if (DatabaseConnector.getConnection() == null) {
            System.out.println("Error generating statement");
            return 0.0;
        }  else {
            System.out.println("Statement: " + DatabaseConnector.getBankStatement(Integer.parseInt(accountId)));
            return DatabaseConnector.getBankStatement(Integer.parseInt(accountId));
        }
        // Display the statement or perform any other necessary actions
    }

}
