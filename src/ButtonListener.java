package src;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class ButtonListener implements ActionListener {
    private int num;
    private JTextField textField;
    private JFrame frame;

    public ButtonListener(JTextField textField, JFrame frame) {
        this.num = 0;
        this.textField = textField;
        this.frame = frame;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //pulling number from the text field
        String pin = this.textField.getText();
        //hashes the given pin to be tested
        String generatedPin = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(pin.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPin = sb.toString();
        } catch (NoSuchAlgorithmException a) {
            a.printStackTrace();
        }
        pin = generatedPin;
        //calls a checkPin method in order to see if the given pin matches any accounts
        ArrayList<Account> accounts = new ArrayList<>();
        //if the pin matches an accounts pin, open the ATMGUI and close the PinPage
        this.frame.dispose();
        ATMGUI atm = new ATMGUI(pin);



    }
}
