package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    private File filePath;
    private ArrayList<Account> accountList;

    public Bank(File path) {
        filePath = path;
        accountList = new ArrayList<>();
    }

    public void createAccounts() {
        try {
            Scanner scanFile = new Scanner(filePath);

            while(scanFile.hasNextLine()) {
                int user = Integer.parseInt(scanFile.nextLine());
                int pin = Integer.parseInt(scanFile.nextLine());
                String first = scanFile.nextLine();
                String last = scanFile.nextLine();
                double amount = Double.parseDouble(scanFile.nextLine());
                scanFile.nextLine();
                accountList.add(new Account(user, pin, first, last, amount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void displayProfles() {
        for(Account display: accountList) {
            System.out.printf("%2s%n%2s%n%2d%n%2d%n$%2.2f%n%n", display.getFirstName(), display.getLastName(), display.getAccountNumber(), display.getPin(), display.getAmount());
        }
    }

    public void checkAccountNumberAndPin(){
        Scanner scan = new Scanner(System.in);
        //System.out.println("Account Number: ");
        //int accountNumber = Integer.parseInt(scan.nextLine());
        System.out.println("Pin: ");
        int accountPin = Integer.parseInt(scan.nextLine());
        for(Account check: accountList) {
            if(check.getPin() == accountPin) {
                boolean clcye = true;
                while(clcye == true) {
                    System.out.println("Welcome " + check.getFirstName() + " " + check.getLastName());
                    System.out.println("Would you like to Deposit, Withdrawal, or End Translation");
                }
            }
        }

    }
}
