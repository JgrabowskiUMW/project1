package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

class WListener implements ActionListener {
    private JTextField textField;
    private Account current;
    private JFrame frame;
   public WListener(JTextField textField, Account current, JFrame frame) {
        this.textField = textField;
        this.current = current;
        this.frame = frame;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        double withdraw = Double.parseDouble(this.textField.getText());
        if (current.getAmount() < withdraw) {
            double amount = current.getAmount();
            JOptionPane.showMessageDialog(null, "Error: Insufficient funds for withdraw.\n" +
                    "the most you can withdraw is $" + amount);

        }
        else {
            current.withdrawFromAccount(withdraw);
            double amount = current.getAmount();
            JOptionPane.showMessageDialog(null, "Your new balance is $" + amount);
            frame.dispose();
        }
    }
}

public class WithdrawScreen {
    private Account current;
    JFrame frame = new JFrame("Withdraw");
    JTextField textField = new JTextField();
    JButton button = new JButton("Enter");

    public WithdrawScreen (Account current) {
        button.addActionListener(new WListener(textField, current, frame));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
         double amount = current.getAmount();
         frame.add(new JLabel("How much do you want to withdraw: "));
         frame.add(new JLabel("Your current balance is $" + amount));
         frame.add(textField);
         frame.add(button);

         frame.pack();
         frame.setVisible(true);

    }

}
