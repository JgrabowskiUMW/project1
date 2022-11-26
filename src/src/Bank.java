package src.src;

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
        try {
            Scanner scanFile = new Scanner(filePath);

            // Scans user data from file.
            while(scanFile.hasNextLine()) {
                int user = Integer.parseInt(scanFile.nextLine());
                String pin = scanFile.nextLine();
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

    /**
     * Displays all accounts information.
     */
    public void displayProfiles() {
        for(Account display: accountList) {
            System.out.printf("%2s%n%2s%n%2d%n%2d%n$%2.2f%n%n", display.getFirstName(), display.getLastName(), display.getAccountNumber(), display.getPin(), display.getAmount());
        }
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void banking(Account user) {
        Scanner scan = new Scanner(System.in);
        // cycle is used to allow user to continue to deposit or withdrawal
        boolean cycle = false;
        // saveSlot is user who is logging in.
        int saveSlot = 0;
        for(int i = 0; i < accountList.size(); i++) {
            if(accountList.get(i).equals(user)) {
                saveSlot = i;
                cycle = true;
            }
        }
        // If cycle is false.
        if(!cycle) {
            System.out.println("No account");
        }
        while(cycle) {
            System.out.println("Welcome " + user.getFirstName() + " " + user.getLastName());
            System.out.println("Would you like to\n1.Deposit\n2.Withdrawal\n3.End Translation");
            int answer = scan.nextInt();
            switch(answer) {
                case 1:
                    System.out.println("How much do you want to deposit: ");
                    accountList.get(saveSlot).addToAccount(scan.nextDouble());
                    System.out.println(String.format("%.2f", accountList.get(saveSlot).getAmount()));
                    break;
                case 2:
                    System.out.println("How much do you want to withdrawal: ");
                    accountList.get(saveSlot).withdrawFromAccount(scan.nextDouble());
                    System.out.println(String.format("%.2f", accountList.get(saveSlot).getAmount()));
                    break;
                case 3:
                    cycle = false;
                    break;
            }
        }
    }
}
