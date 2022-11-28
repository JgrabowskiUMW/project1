
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private int num;
    private JTextField textField;
    private JFrame frame;

    public ButtonListener(JTextField textField, JFrame frame) {
        this.num = 0;
        this.textField = textField;
        this.frame = frame;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //pulling number from the text field
        int num = Integer.parseInt(this.textField.getText());


        //hashes the given pin to be tested

        //calls a checkPin method in order to see if the given pin matches any accounts

        //if the pin matches an accounts pin, open the ATMGUI and close the PinPage
        this.frame.dispose();
        ATMGUI atm = new ATMGUI();



    }
}
