
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

class DListener implements ActionListener {
    private JTextField textField;
    private Account current;
    private JFrame frame;
    public DListener(JTextField textField, Account current, JFrame frame) {
        this.textField = textField;
        this.current = current;
        this.frame = frame;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        double deposit = Double.parseDouble(this.textField.getText());
        current.addToAccount(deposit);
        double amount = current.getAmount();
        JOptionPane.showMessageDialog(null, "Your new balance is $" + amount);
        frame.dispose();
    }
}

public class DepositScreen {
    private Account current;
    JFrame frame = new JFrame("Deposit");
    JTextField textField = new JTextField();
    JButton button = new JButton("Enter");

    public DepositScreen (Account current) {
        button.addActionListener(new DListener(textField, current, frame));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        double amount = current.getAmount();
        frame.add(new JLabel("How much do you want to Deposit: "));
        frame.add(new JLabel("Your current balance is $" + amount));
        frame.add(textField);
        frame.add(button);

        frame.pack();
        frame.setVisible(true);

    }

}