import AccountGenerator.UniqueNumberGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static AccountGenerator.UniqueNumberGenerator.generateUniqueNumber;
import static JDBCon.DatabaseConnector.createUser;
import static JDBCon.DatabaseConnector.getConnection;

public class CreateUser extends JFrame implements ActionListener {
    private JPanel panel1;
    private JPanel content;
    private JPanel header;
    private JTextField accountNumber;
    private JPasswordField accountPin;
    private JButton createAccountButton;
    private JButton cancelButton;

    private int accountNumberInt;

    public CreateUser() {
        setContentPane(content);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        /* increase the dimensions */
        setSize(500, 500);

        //generate a unique account number
        int accountNumberInt = generateUniqueNumber();

        accountNumber.setEditable(false);
        accountNumber.setText(String.valueOf(accountNumberInt));

        createAccountButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createAccountButton) {
            String accountNumber = this.accountNumber.getText();
            String accountPin = String.valueOf(this.accountPin.getPassword());
            if (accountNumber.equals("") || accountPin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your account number and pin");
            } else {
                //call the login method
                getConnection();
                try {
                    boolean userCreated = createUser(Integer.parseInt(accountNumber), Integer.parseInt(accountPin));
                    if (userCreated) {
                        JOptionPane.showMessageDialog(null, "Account created successfully.");
                        LoginForm loginForm = new LoginForm();
                        loginForm.setVisible(true);
                        loginForm.setLocationRelativeTo(null);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to create account.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid account number and pin");
                }

            }
        } else if (e.getSource() == cancelButton) {
            System.exit(0);
        }
    }
}
