package AtmLogic;

public class BankAccount {
    private String userId;
    private int accountId;
    private double balance;

    public BankAccount(String userId, int accountId, double balance) {
        this.userId = userId;
        this.accountId = accountId;
        this.balance = balance;
    }

    public BankAccount() {
    }

    // Getters and Setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
