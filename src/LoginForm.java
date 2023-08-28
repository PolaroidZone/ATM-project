import AtmLogic.Account;
import AtmLogic.AtmSession;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LoginForm extends JFrame implements ActionListener {
    private JPanel panel1;
    private JPanel content;
    private JPanel pane;
    private JTextField card;
    private JPasswordField pin;
    private JButton proceedButton;
    private JButton End;
    private JButton newUserButton;
    AtmSession atmSession = new AtmSession();

    public LoginForm (){
        setContentPane(content);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        /* increase the dimensions */
        setSize(500,500);
        setLocationRelativeTo(null);

        proceedButton.addActionListener(this);
        End.addActionListener(this);
        newUserButton.addActionListener(this);
        newUserButton.setVisible(false);

    }

    //Create an on-click event for the proceed button
    //Check if the fields have input

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == proceedButton){
            String cardNumber = card.getText();
            String pinNumber = String.valueOf(pin.getPassword());
            if (Objects.equals(cardNumber, "") || Objects.equals(pinNumber, " ")){
                JOptionPane.showMessageDialog(null, "Please enter your card number and pin");
            }else{
                //call the login method
                login(cardNumber, pinNumber);
            }
        } else if (e.getSource() == End){
            System.exit(0);
        } else if (e.getSource() == newUserButton) {
            CreateUser createUser = new CreateUser();
            createUser.setVisible(true);
            createUser.setLocationRelativeTo(null);
            dispose();
        }
    }

    private void login(String accountNumber, String pinNumber) {
        //Check if the user exists
        try {
            boolean isExists = atmSession.login(accountNumber, Integer.parseInt(pinNumber));

            if (!isExists){
                JOptionPane.showMessageDialog(null, "Invalid card number or pin");
            }else{
                //Open the next window
                new TransactionForm(accountNumber);
                dispose();
            }
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Invalid card number or pin");
        }

    }

}
