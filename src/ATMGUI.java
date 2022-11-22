package src;

import javax.swing.*;
import java.awt.*;

public class ATMGUI {

    //create window
    public void createWindow() {
        JFrame frame = new JFrame("LibraryGUI");
        frame.setLayout(new BorderLayout(10, 50));
        frame.setSize(800, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100,300,300,300));
        panel.setLayout(new CardLayout());
        panel.setOpaque(true);
        panel.setBackground(Color.WHITE);

        frame.add(panel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
}
