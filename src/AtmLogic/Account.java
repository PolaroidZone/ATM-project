package AtmLogic;
//this class contains all the methods needed to create a users account in a bank
//This class should allow a user to create a bank account using a user id and 4 digit pin

public class Account {

    private String userId;
    private int pin;
    public Account(String userId, int pin) {
        this.userId = userId;
        this.pin = pin;
    }

    public Account() {
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
