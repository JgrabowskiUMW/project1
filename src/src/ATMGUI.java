package src;

import javax.swing.*;
import java.awt.*;

public class ATMGUI {
    ATMGUI(String pin) {
        JFrame frame = new JFrame();
        JLabel label = new JLabel(pin);

        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.pack();
        frame.setVisible(true);
    }
}

