import AtmLogic.Account;
import AtmLogic.AtmSession;
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
    Account account = new Account();
    public TransactionForm (String accountNumber){
        setContentPane(content);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setLocationRelativeTo(null);
        /* increase the dimensions */
        setSize(500,500);

        account.setUserId(accountNumber);

        withdrawFundsButton.addActionListener(this);
        depositeFundsButton.addActionListener(this);
        checkBalanceButton.addActionListener(this);
        printBankStatementButton.addActionListener(this);
        changePinButton.addActionListener(this);
        cancelButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String uid = account.getUserId();
        if (e.getSource() == withdrawFundsButton){
            new WithdrawFunds(uid);
        }else if (e.getSource() == depositeFundsButton){
            new DepositeFunds(uid);
        } else if (e.getSource() == checkBalanceButton) {

        } else if (e.getSource() == printBankStatementButton) {

        } else if (e.getSource() == changePinButton) {

        } else if (e.getSource() == cancelButton) {
            new LoginForm();
            dispose();
        }
    }

}
