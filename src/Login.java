package src;

import java.io.File;
import java.util.ArrayList;

public class Login {

    Bank accounts;

    public void startingAccounts(File f) {
        accounts = new Bank(f);
    }

    public void display() {
        accounts.displayProfles();
    }

}
