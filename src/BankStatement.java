import AtmLogic.BankAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static AccountGenerator.UniqueNumberGenerator.convertScientificToDecimal;
import static AtmLogic.GetStatement.getAccountStatement;

public class BankStatement extends JFrame {
    private JPanel panel1;
    private JPanel content;
    private JButton proceedButton;
    private JTextArea display;

    public BankStatement(String accountNumber) {
        setContentPane(content);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        /* increase the dimensions */
        setSize(500, 500);
        setLocationRelativeTo(null);

        handleDisplayStatement(accountNumber);
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginForm();
                dispose();
            }
        });
    }

    public void handleDisplayStatement(String accountNumber) {
        BankAccount account = getAccountStatement(accountNumber);
        assert account != null;
        String finalBalance = convertScientificToDecimal(account.getBalance());
        String statement = "Account Number: " + account.getAccountId() + "\n" +
                "Account Balance: " + finalBalance + "\n" +
                "Account User: " + account.getUserId() + "\n";

        display.setText(statement);
    }

}
