import JDBCon.DatabaseConnector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static JDBCon.DatabaseConnector.getConnection;

public class TransactionForm extends JFrame implements ActionListener {
    private JPanel panel1;
    private JPanel content;
    private JPanel Header;
    private JPanel navigator;
    private JPanel Navigato_message;
    private JButton withdrawFundsButton;
    private JButton depositeFundsButton;
    private JButton checkBalanceButton;
    private JButton printBankStatementButton;
    private JButton changePinButton;
    private JButton cancelButton;

    private final String cardNumber;

    private final String pinNumber;

    public TransactionForm (String cardNumber, String pinNumber){
        setContentPane(content);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setLocationRelativeTo(null);
        /* increase the dimensions */
        setSize(500,500);

        withdrawFundsButton.addActionListener(this);
        depositeFundsButton.addActionListener(this);
        checkBalanceButton.addActionListener(this);
        printBankStatementButton.addActionListener(this);
        changePinButton.addActionListener(this);
        cancelButton.addActionListener(this);

        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdrawFundsButton){
            withdrawFunds(Integer.parseInt(cardNumber), Integer.parseInt(pinNumber));
        }else if (e.getSource() == depositeFundsButton){

        } else if (e.getSource() == checkBalanceButton) {

        } else if (e.getSource() == printBankStatementButton) {

        } else if (e.getSource() == changePinButton) {

        } else if (e.getSource() == cancelButton) {
            new LoginForm();
        }
    }

    private void withdrawFunds(int cardNumber, int pinNumber) {
        //Check if the user is a database user
        //Get database connection
        getConnection();
        //Check if the user exists
        Boolean isExist = DatabaseConnector.validateUser(Integer.parseInt(String.valueOf(cardNumber)), Integer.parseInt(String.valueOf(pinNumber)));

        if (!isExist){
            JOptionPane.showMessageDialog(null, "Invalid card number or pin");
        }else{
            //Open the transaction form
            dispose();
        }
    }

    //Setting the credentials
    private String getCardNumber () {
        return cardNumber;
    }

    public String getPinNumber() {
        return pinNumber;
    }
}
