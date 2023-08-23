package AtmLogic;

import JDBCon.DatabaseConnector;

import static JDBCon.DatabaseConnector.closeConnection;
import static JDBCon.DatabaseConnector.getConnection;

public class Withdraw {
    protected Account account;
    protected AtmSession session;
    public Withdraw() {
    }

    public boolean withdrawFunds(String accountId,double amount) {
        getConnection();
        // TODO: Implement logic to withdraw funds from the account
        // For example, deduct the withdrawn amount from the account balance

        if (getConnection() == null){
            System.out.println("There is no database connection available");
            return false;
        }else {
            if (DatabaseConnector.withdrawFunds(Integer.parseInt(accountId), amount)) {
                System.out.println("Successfully withdrew funds: " + amount);
                closeConnection();
                return true;
            } else {
                System.out.println("Error withdrawing funds");
                closeConnection();
                return false;
            }
        }
    }
}
