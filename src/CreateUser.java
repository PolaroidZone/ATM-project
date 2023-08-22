import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static JDBCon.DatabaseConnector.createUser;

public class CreateUser extends JFrame implements ActionListener {
    private JPanel panel1;
    private JPanel content;
    private JPanel header;
    private JTextField accountNumber;
    private JPasswordField accountPin;
    private JButton createAccountButton;
    private JButton cancelButton;

    public CreateUser() {
        setContentPane(content);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        /* increase the dimensions */
        setSize(500, 500);

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
            }
        } else if (e.getSource() == cancelButton) {
            System.exit(0);
        }
    }
}
