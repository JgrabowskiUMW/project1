package src;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//Class to create bank object that has a file and an array list with accounts
public class Bank {

    private File filePath;
    private ArrayList<Account> accountList;

    //Bank constructor that takes a file
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
                accountList.add(new Account(user, pin, first, last, amount));
                //scanFile.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Save method that saves out the accounts in the arraylist to the file
    public void save() {
        File file = new File("accountinfo");
        try {
            PrintWriter out = new PrintWriter(file);
            for (Account a : accountList) {
                a.save(out);
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();;
        }
    }

    //Method to get the entries in the array list
    public ArrayList<Account> getAccountList() {
        return accountList;
    }
}
