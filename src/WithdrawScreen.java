

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

class WListener implements ActionListener {
    private JTextField textField;
    private Account current;
   public WListener(JTextField textField, Account current) {
        this.textField = textField;
        this.current = current;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int withdraw = Integer.parseInt(this.textField.getText());
        current.withdrawFromAccount(withdraw);
    }
}

public class WithdrawScreen {
    private Account current;
    JFrame frame = new JFrame("Withdraw");
    JTextField textField = new JTextField();
    JButton button = new JButton("Enter");

    public WithdrawScreen (Account current) {
        button.addActionListener(new WListener(textField, current));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
         double amount = current.getAmount();
         frame.add(new JLabel("How much do you want to withdraw: "));
         frame.add(new JLabel("Your current balance is " + amount));
         frame.add(textField);
         frame.add(button);

         frame.pack();
         frame.setVisible(true);

    }

}
