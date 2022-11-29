
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// for depositing money into an account
class DepositAction implements ActionListener {
    private int amount;
    private JButton button;

    DepositAction(JButton button) {
        this.button = button;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

//for withdrawing money from an account
class WithdrawAction implements ActionListener {
    private int amount;
    private JButton button;

    WithdrawAction(JButton button) {
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
// for checking the balance of an account
class CheckBalanceAction implements ActionListener {
    private JButton button;
    private Account current;

    CheckBalanceAction(JButton button) {
        this.button = button;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

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
    ATMGUI() {
        //creates a JFrame and sets the close action
        JFrame frame = new JFrame("Welcome!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creates a new GridLayout for the main display of the ATM
        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(4,2);
        grid.setLayout(layout);

        //adds the buttons and their label to the grid
        addButton(grid, "Check Balance", frame);
        addButton(grid, "Deposit", frame);
        addButton(grid, "Withdraw", frame);
        addButton(grid, "Logout", frame);

        //adding the grid to the frame and then setting the visibility so the frame will be displayed
        frame.getContentPane().add(grid);
        frame.pack();
        frame.setVisible(true);
    }

    public static void addButton(JPanel grid, String name, JFrame frame) {
        // creates a button then adds an action listener based on the function of the button
        JButton button = new JButton();
        if (name.equals("Check Balance")) {
            CheckBalanceAction check = new CheckBalanceAction(button);
            button.addActionListener(check);
        }
        else if (name.equals("Deposit")) {
            DepositAction deposit = new DepositAction(button);
            button.addActionListener(deposit);
        }
        else if (name.equals("Withdraw")) {
            WithdrawAction withdraw = new WithdrawAction(button);
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

