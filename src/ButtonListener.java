package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
        //checks the given hashed pin against those in accountinfo
        ArrayList<Account> accounts = new ArrayList<>();
        Bank bank = new Bank(new File("accountinfo"));
        accounts = bank.getAccountList();
        Account current = null;
        Boolean open = false;
        for (int i = 0; i < accounts.size(); i++) {
            Account test = accounts.get(i);
            String testPin = test.getPin();
            if (testPin.equals(pin)) {
                current = test;
                open = true;
                //if the pin matches an accounts pin, open the ATMGUI and close the PinPage
                this.frame.dispose();
                ATMGUI atm = new ATMGUI(pin);
            }
        }
        if (open==false) {
            JOptionPane.showMessageDialog(null, "Invalid pin, please try again.");
        }
    }
}
