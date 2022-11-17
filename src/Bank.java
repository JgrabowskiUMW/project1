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

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void banking(Account user) {
        Scanner scan = new Scanner(System.in);
        boolean clcye = true;
        int saveSlot = 0;
        for(int i = 0; i < accountList.size(); i++) {
            if(accountList.get(i).equals(user)) {
                saveSlot = i;
            }
        }
        while(clcye == true) {
            System.out.println("Welcome " + user.getFirstName() + " " + user.getLastName());
            System.out.println("Would you like to\n1.Deposit\n2.Withdrawal\n3.End Translation");
            int answer = scan.nextInt();
            switch(answer) {
                case 1:
                    System.out.println("How much do you want to deposit: ");
                    accountList.get(saveSlot).addToAccount(scan.nextInt());
                case 2:
                    System.out.println("How much do you want to deposit: ");
                    accountList.get(saveSlot).addToAccount(scan.nextInt());
                case 3:
                    clcye = false;
            }
        }
    }
}
