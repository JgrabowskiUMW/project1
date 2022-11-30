package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

// for depositing money into an account
class DepositAction implements ActionListener {
    private int amount;
    private JButton button;
    private Account current;

    DepositAction(JButton button, Account current) {
        this.button = button;
        this.current = current;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        DepositScreen depositScreen = new DepositScreen(current);
    }
}

//for withdrawing money from an account
class WithdrawAction implements ActionListener {
    private int amount;
    private JButton button;
    private Account current;

    WithdrawAction(JButton button, Account current) {
        this.button = button;
        this.current = current;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        WithdrawScreen open = new WithdrawScreen(current);

    }
}
// for checking the balance of an account
class CheckBalanceAction implements ActionListener {
    private JButton button;
    private Account current;
    private JFrame frame;

    CheckBalanceAction(JButton button, Account current, JFrame frame) {
        this.button = button;
        this.current = current;
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        double amount = this.current.getAmount();
        JOptionPane.showMessageDialog(null, "Your balance is " + amount);
    }
}
//button listener for logging out of the account (Closing Program)
class LogAction implements ActionListener {
    private JButton button;
    private JFrame frame;

    LogAction(JButton button, JFrame frame) {
        this.button = button;
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        PinPage pinPage = new PinPage();
    }
}
public class ATMGUI {
    private String pin;
    ATMGUI(String pin) {
        //creates bank object to retrieve account list
        Bank bank = new Bank(new File("accountinfo"));
        ArrayList<Account> accountList = new ArrayList<>();
        accountList = bank.getAccountList();

        //creates account by testing given pin against pins from the list
        Account current = null;
        for (int i = 0; i < accountList.size(); i++) {
            Account test = accountList.get(i);
            String testPin = test.getPin();
            if (testPin.equals(pin)) {
                current = test;
            }
        }

        //creates a JFrame and sets the close action
        JFrame frame = new JFrame("Welcome!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creates a new GridLayout for the main display of the ATM
        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(4,2);
        grid.setLayout(layout);

        //adds the buttons and their label to the grid
        addButton(grid, "Check Balance", frame, current);
        addButton(grid, "Deposit", frame, current);
        addButton(grid, "Withdraw", frame, current);
        addButton(grid, "Logout", frame, current);

        //adding the grid to the frame and then setting the visibility so the frame will be displayed
        frame.getContentPane().add(grid);
        frame.pack();
        frame.setVisible(true);
    }

    public static void addButton(JPanel grid, String name, JFrame frame, Account current) {
        // creates a button then adds an action listener based on the function of the button
        JButton button = new JButton();
        if (name.equals("Check Balance")) {
            CheckBalanceAction check = new CheckBalanceAction(button, current, frame);
            button.addActionListener(check);
        }
        else if (name.equals("Deposit")) {
            DepositAction deposit = new DepositAction(button, current);
            button.addActionListener(deposit);
        }
        else if (name.equals("Withdraw")) {
            WithdrawAction withdraw = new WithdrawAction(button, current);
            button.addActionListener(withdraw);

        }
        else {
            LogAction log = new LogAction(button, frame);
            button.addActionListener(log);
        }

        //adds the new buttons along with a label to the grid given
        grid.add(button);
        grid.add(new JLabel(name));


    }
}

