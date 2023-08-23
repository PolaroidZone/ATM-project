package AtmLogic;

import JDBCon.DatabaseConnector;

import static AccountGenerator.UniqueNumberGenerator.generateUniqueCard;
import static JDBCon.DatabaseConnector.*;

public class Deposit {
    protected AtmSession session;
    public Deposit() {
    }

    public boolean depositFunds(String accountId, double amount) {
        // TODO: Implement logic to deposit funds into the account
        // For example, update the account balance with the deposited amount
        getConnection();

        boolean isAvailable = checkBankAccount(Integer.parseInt(accountId));

        if(!isAvailable){
            int cardNumber = generateUniqueCard();
            boolean isCreated = DatabaseConnector.createBankAccount(cardNumber, Integer.parseInt(accountId), amount);
            if (isCreated) {
                System.out.println("Successfully created bank account");
                closeConnection();
                return true;
            } else {
                System.out.println("Error creating bank account");
                closeConnection();
                return false;
            }
        } else {
            if (getConnection() == null){
                System.out.println("There is no database connection available");
                return false;
            }else {
                if (DatabaseConnector.depositFunds(Integer.parseInt(accountId), amount)){
                    System.out.println("Successfully deposited funds: " + amount);
                    closeConnection();
                    return true;
                }else {
                    System.out.println("Error depositing funds");
                    closeConnection();
                    return false;
                }
            }
        }
    }
}
