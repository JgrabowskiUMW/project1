package src;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PinPage pinPage = new PinPage();

        File file = new File("accountinfo");
        Login accounts = new Login();
        accounts.startingAccounts(file);
        boolean keepOn = true;

        accounts.checkPin();

        //while(keepOn == true) {
        //try to run

        //}

        accounts.display();
        //ATMGUI window = new ATMGUI();
        //window.createWindow();
    }
}
