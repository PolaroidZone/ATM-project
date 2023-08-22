import AtmLogic.AtmSession;
import AtmLogic.GetStatement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static JDBCon.DatabaseConnector.withdrawFunds;

public class WithdrawFunds extends JFrame implements ActionListener {
    private JPanel panel1;
    private JPanel content;
    private JTextField balamce;
    private JRadioButton a200RadioButton;
    private JRadioButton a100RadioButton;
    private JRadioButton a50RadioButton;
    private JButton withdrawButton;
    private JTextField customvalue;
    private JButton a1Button;
    private JButton a5Button;
    private JButton a4Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton proceedButton;
    private JButton a0Button;
    private JButton correctButton;

    public WithdrawFunds() {
        super("Withdraw Funds");
        setContentPane(content);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(a200RadioButton);
        radioGroup.add(a100RadioButton);
        radioGroup.add(a50RadioButton);

        //get session
        AtmSession session = new AtmSession();
        String backAccount = String.valueOf(session.getCurrentAccount());

        balamce.setEditable(false);
        customvalue.setEditable(false);

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = getRadioAmount();
                System.out.println("Selected amount: $" + amount);

                handleWithdraw(Integer.parseInt(backAccount), amount);
            }
        });
        
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Integer.parseInt(customvalue.getText());
                System.out.print(amount);
                handleWithdraw(Integer.parseInt(backAccount), amount);
            }
        });


        //ATM buttons
        a0Button.addActionListener(this);
        a1Button.addActionListener(this);
        a2Button.addActionListener(this);
        a3Button.addActionListener(this);
        a4Button.addActionListener(this);
        a5Button.addActionListener(this);
        a6Button.addActionListener(this);
        a7Button.addActionListener(this);
        a8Button.addActionListener(this);
        a9Button.addActionListener(this);
        correctButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Button onclick options actions
        if (e.getSource() == a0Button) {
            customvalue.setText(customvalue.getText() + "0");
        } else if (e.getSource() == a1Button) {
            customvalue.setText(customvalue.getText() + "1");
        } else if (e.getSource() == a2Button) {
            customvalue.setText(customvalue.getText() + "2");
        } else if (e.getSource() == a3Button) {
            customvalue.setText(customvalue.getText() + "3");
        } else if (e.getSource() == a4Button) {
            customvalue.setText(customvalue.getText() + "4");
        } else if (e.getSource() == a5Button) {
            customvalue.setText(customvalue.getText() + "5");
        } else if (e.getSource() == a6Button) {
            customvalue.setText(customvalue.getText() + "6");
        } else if (e.getSource() == a7Button) {
            customvalue.setText(customvalue.getText() + "7");
        } else if (e.getSource() == a8Button) {
            customvalue.setText(customvalue.getText() + "8");
        } else if (e.getSource() == a9Button) {
            customvalue.setText(customvalue.getText() + "9");
        } else if (e.getSource() == correctButton) {
            customvalue.setText("");
        } else {
            System.out.println("Error");
        }
    }

    private int getRadioAmount() {
        int amount = 0; // Initialize the amount

        // Retrieve the selected radio button's label
        if (a200RadioButton.isSelected()) {
            return  amount = 200;
        } else if (a100RadioButton.isSelected()) {
            return  amount = 100;
        } else if (a50RadioButton.isSelected()) {
            return amount = 50;
        }
        return amount;
    }

    private void handleWithdraw(int account, double amount) {
        double balance = GetStatement.getStatement();
        if (amount > balance) {
            JOptionPane.showMessageDialog(this, "Insufficient funds");
        } else {
            boolean results = withdrawFunds(account ,amount);
            if (results) {
                JOptionPane.showMessageDialog(this, "Successfully withdrew funds: $" + amount);
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
                loginForm.setLocationRelativeTo(null);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error withdrawing funds");
            }
        }
    }

}
