import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class Login {

    Bank accounts;

    public void startingAccounts(File f) {
        accounts = new Bank(f);
    }

    /**
     * Displays profiles of all accounts.
     */
    public void display() {
        accounts.displayProfiles();
    }

    /**
     * Checks Pin that user inputs
     */
    public void checkPin(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Pin: ");
        String accountPin = scan.nextLine();
        for(Account check: accounts.getAccountList()) {
            // Checks if pin is in system.
            if(check.getPin().equals(accountPin)) {
                accounts.banking(check);
            }
        }

    }

    public static class PinPage{
        //create frame, text field to enter the pin, and a button to continue
        JFrame frame = new JFrame("Pin Page");
        JTextField textField = new JTextField();
        JButton enter = new JButton("Enter");

        public PinPage() {
            //add actionListener to the JButton
            enter.addActionListener(new ButtonListener(textField, frame));

            //create layout and allow for the GUI to close on exit
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

            //add a label, the text field, and the button to the frame
            frame.add(new JLabel("Please Enter Your Pin Below: "));
            frame.add(textField);
            frame.add(enter);

            frame.pack();
            frame.setVisible(true);

        }

    }
}
