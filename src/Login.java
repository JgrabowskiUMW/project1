package src;

import java.io.File;
import java.util.Scanner;

public class Login {

    Bank accounts;

    public void startingAccounts(File f) {
        accounts = new Bank(f);
    }

    public void display() {
        accounts.displayProfles();
    }

    public void checkPin(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Pin: ");
        int accountPin = Integer.parseInt(scan.nextLine());
        for(Account check: accounts.getAccountList()) {
            // Checks if pin is in system.
            if(check.getPin() == accountPin) {
                accounts.banking(check);
            }
        }

    }

}
