
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Account {

    private String firstName;
    private String lastName;
    private double amount;
    private static int accountNumber;
    private String pin;

    public Account(int u, String p, String f, String l, double a) {
        accountNumber = u;
        firstName = f;
        lastName = l;
        amount = a;
        pin = p;
        /*String generatedPin = null;
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
        pin = generatedPin;*/
    }
    public Account (String pin) {
        this.pin = pin;
       /* String generatedPin = null;
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
        this.pin = generatedPin; */
    }
    public void save(PrintWriter out) {
        out.print(accountNumber + "\n" + pin + "\n" + firstName + "\n" + lastName + "\n" + amount + "\n");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPin() {
        return pin;
    }

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

    public void addToAccount(double deposit) {
        amount += deposit;
    }

    public void withdrawFromAccount(double withdraw) {
        if(amount - withdraw < 0)
            System.out.println("Balance is insufflation to withdraw from.");
        else
            amount -= withdraw;
    }
}
