package AtmLogic;

import JDBCon.DatabaseConnector;

import static AccountGenerator.UniqueNumberGenerator.generateUniqueCard;
import static JDBCon.DatabaseConnector.checkBankAccount;
import static JDBCon.DatabaseConnector.getConnection;

public class Deposit {
    protected AtmSession session;
    public Deposit() {
    }

    public String depositFunds(String accountId, double amount) {
        // TODO: Implement logic to deposit funds into the account
        // For example, update the account balance with the deposited amount
        getConnection();


        boolean isAvailable = checkBankAccount(Integer.parseInt(accountId));

        if(!isAvailable){
            int cardNumber = generateUniqueCard();
            boolean isCreated = DatabaseConnector.createBankAccount(cardNumber, Integer.parseInt(accountId), amount);
            if (isCreated) {
                System.out.println("Successfully created bank account");
                return "There was no bank account available but we created one for you";
            } else {
                System.out.println("Error creating bank account");
                return "Cant create bank account at the moment try again later";
            }
        } else {
            if (getConnection() == null){
                System.out.println("There is no database connection available");
                return "This service is currently unavailable please try again later";
            }else {
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
}
