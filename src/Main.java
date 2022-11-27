import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        //PinPage pinPage = new PinPage();

        /*File file = new File("accountinfo");
        Login accounts = new Login();
        accounts.startingAccounts(file);
        boolean keepOn = true;*/

        //accounts.checkPin();

        //while(keepOn == true) {
        //try to run

        //}

        //accounts.display();
        //src.ATMGUI window = new src.ATMGUI();
        //window.createWindow();

        Account me = new Account(1311, "1102", "Tamarcus", "Daniel", 5000);
        System.out.println(me.getPin());
    }

}
