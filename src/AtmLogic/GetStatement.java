package AtmLogic;

import JDBCon.DatabaseConnector;

//This class contains a method that gets the users account bank statement
public class GetStatement {
    private Account account;
    private static AtmSession session;

    public GetStatement(Account account) {
        this.account = account;
    }

    public static Double getStatement() {
        // TODO: Implement logic to retrieve the user's bank statement
        // For example, fetch transaction history or account details from a database
        Account currentAccount = session.getCurrentAccount();
        if (DatabaseConnector.getConnection() == null) {
            System.out.println("Error generating statement");
            return 0.0;
        }  else {
            String accountId = currentAccount.getUserId();
            System.out.println("Statement: " + DatabaseConnector.getBankStatement(Integer.parseInt(accountId)));
            return DatabaseConnector.getBankStatement(Integer.parseInt(accountId));
        }
        // Display the statement or perform any other necessary actions
    }

}
