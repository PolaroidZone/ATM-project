package AtmLogic;

import JDBCon.DatabaseConnector;

public class Deposit {
    protected Account account;
    protected AtmSession session;
    public Deposit(Account account) {
        this.account = account;
    }

    public String depositFunds(double amount) {
        // TODO: Implement logic to deposit funds into the account
        // For example, update the account balance with the deposited amount
        Account currentAccount = session.getCurrentAccount();

        if (DatabaseConnector.getConnection() == null){
            System.out.println("There is no database connection available");
            return "This service is currently unavailable please try again later";
        }else {
            String accountId  = currentAccount.getUserId();
            if (DatabaseConnector.depositFunds(Integer.parseInt(accountId), amount)){
                System.out.println("Successfully deposited funds: " + amount);
                return "Successfully deposited funds: " + amount;
            }else {
                System.out.println("Error depositing funds");
                return "Cant deposit funds at the moment try again later";
            }
        }
    }
}
