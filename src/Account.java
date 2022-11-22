package src;

public class Account {

    private String firstName;
    private String lastName;
    private double amount;
    private static int accountNumber;
    private int pin;

    public Account(int u, int p, String f, String l, double a) {
        accountNumber = u;
        pin = p;
        firstName = f;
        lastName = l;
        amount = a;
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

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
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
