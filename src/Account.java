package src;

import java.io.PrintWriter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
//Class to create an account object
public class Account {

    private String firstName;
    private String lastName;
    private double amount;
    private int accountNumber;
    private String pin;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    //Constructor to create an account
    public Account(int u, String p, String f, String l, double a) {
        accountNumber = u;
        firstName = f;
        lastName = l;
        amount = a;
        pin = p;
    }
    //Print writer to print out the account object in the file.
    public void save(PrintWriter out) {
        String a = String.format("%2.2f", amount);
        out.print(accountNumber + "\n" + pin + "\n" + firstName + "\n" + lastName + "\n" + a + "\n");
    }

    //Get and set methods.
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getAmount() {
        return amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    //Method that gets the 4 number pin and applies algorithm to it to hash the pin so in the file it appears as a string of characters.
    public void setPin(String pin) {
        this.pin = pin;
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
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        this.pin = generatedPin;
    }

    //Method to deposit money into account
    public void addToAccount(double deposit) {
        amount += deposit;
    }

    //Method to withdraw money from account
    public void withdrawFromAccount(double withdraw) {
        df.format(amount-=withdraw);
    }

    //toString method to print the account object a certain way.
    public String toString() {
        String n = "First Name: " + this.firstName + "\n" + "Last Name: " + this.lastName + "\n" + "Account Number: " + this.accountNumber;
        return n;
    }
}
