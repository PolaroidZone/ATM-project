package AtmLogic;

import JDBCon.DatabaseConnector;

public class Withdraw {
    protected Account account;
    protected AtmSession session;
    public Withdraw(Account account) {
        this.account = account;
    }

    public String withdrawFunds(double amount) {
        // TODO: Implement logic to withdraw funds from the account
        // For example, deduct the withdrawn amount from the account balance
        Account currentAccount = session.getCurrentAccount();

        if (DatabaseConnector.getConnection() == null){
            System.out.println("There is no database connection available");
            return "This service is not available at the moment please try again later";
        }else {
            String accountId = currentAccount.getUserId();
            if (DatabaseConnector.withdrawFunds(Integer.parseInt(accountId), amount)) {
                System.out.println("Successfully withdrew funds: " + amount);
                return "Successfully withdrew funds: " + amount;
            } else {
                System.out.println("Error withdrawing funds");
                return "Cant withdrawing funds at the moment try later";
            }
        }
    }
}
