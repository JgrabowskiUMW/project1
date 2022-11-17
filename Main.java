import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File file = new File("accountinfo");
        Bank accounts = new Bank(file);
        boolean keepOn = true;

        while(keepOn == true) {


        }
        accounts.createAccounts();
        accounts.displayProfles();
        //ATMGUI window = new ATMGUI();
        //window.createWindow();
    }
}
