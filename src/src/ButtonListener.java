package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private int num;
    private JTextField textField;

    public ButtonListener(JTextField textField) {
        this.num = 0;
        this.textField = textField;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //pulling number from the text field
        int num = Integer.parseInt(this.textField.getText());

    }
}
