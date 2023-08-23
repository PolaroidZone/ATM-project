import AtmLogic.Account;
import AtmLogic.Deposit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static JDBCon.DatabaseConnector.depositFunds;

public class DepositeFunds extends JFrame implements ActionListener {
    private JPanel panel1;
    private JPanel content;
    private JTextField textField1;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton a0Button;
    private JButton depositButton;
    private JButton correctButton;
    private JButton cancelButton;

    Account account = new Account();

    public DepositeFunds(String accountNumber){
        setContentPane(content);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setLocationRelativeTo(null);
        /* increase the dimensions */
        setSize(500,500);
        setLocationRelativeTo(null);

        a0Button.addActionListener(this);
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(textField1.getText());
                if (amount <= 0.0) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount");
                    textField1.setText("");
                } else {
                    Deposit deposit = new Deposit();
                    boolean isDeposit = deposit.depositFunds(accountNumber, amount);
                    if (isDeposit) {
                        JOptionPane.showMessageDialog(null, "Deposited funds successfully");
                        handleOnComplete();
                    } else {
                        JOptionPane.showMessageDialog(null, "Our service is currently unavailable please try again later");
                        handleOnComplete();
                    }
                }
            }
        });

        correctButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new TransactionForm(accountNumber);
               dispose();
            }
        });

        a1Button.addActionListener(this);
        a2Button.addActionListener(this);
        a3Button.addActionListener(this);
        a4Button.addActionListener(this);
        a5Button.addActionListener(this);
        a6Button.addActionListener(this);
        a7Button.addActionListener(this);
        a8Button.addActionListener(this);
        a9Button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == a1Button){
            textField1.setText(textField1.getText() + "1");
        }else if (e.getSource() == a2Button) {
            textField1.setText(textField1.getText() + "2");
        }else if (e.getSource() == a3Button) {
            textField1.setText(textField1.getText() + "3");
        }else if (e.getSource() == a4Button) {
            textField1.setText(textField1.getText() + "4");
        }else if (e.getSource() == a5Button) {
            textField1.setText(textField1.getText() + "5");
        }else if (e.getSource() == a6Button) {
            textField1.setText(textField1.getText() + "6");
        }else if (e.getSource() == a7Button) {
            textField1.setText(textField1.getText() + "7");
        }else if (e.getSource() == a8Button) {
            textField1.setText(textField1.getText() + "8");
        }else if (e.getSource() == a9Button) {
            textField1.setText(textField1.getText() + "9");
        }else if (e.getSource() == a0Button) {
            textField1.setText(textField1.getText() + "0");
        }
    }

    private void handleOnComplete() {
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
        loginForm.setLocationRelativeTo(null);
        dispose();
    }
}
