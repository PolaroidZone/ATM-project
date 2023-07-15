package AtmLogic;

import JDBCon.DatabaseConnector;

//This class contains a method that gets the users account bank statement
public class BankStatement {
    private Account account;
    private AtmSession session;

    private DatabaseConnector databaseConnector;
    public BankStatement(Account account) {
        this.account = account;
    }

    public Double getStatement() {
        // TODO: Implement logic to retrieve the user's bank statement
        // For example, fetch transaction history or account details from a database
        Account currentAccount = session.getCurrentAccount();
        if (DatabaseConnector.getConnection() == null) {
            System.out.println("Error generating statement");
            return 0.0;
        }  else {
            String accountId = currentAccount.getUserId();
            System.out.println("Statement: " + DatabaseConnector.getBankStatement(accountId));
            return DatabaseConnector.getBankStatement(accountId);
        }
        // Display the statement or perform any other necessary actions
    }

}
