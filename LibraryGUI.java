import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LibraryGUI {

    //create window
    public void createWindow() {
        JFrame frame = new JFrame("LibraryGUI");
        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(100,300,300,300));
        panel.setLayout(new GridLayout(0,1));

        panel.setOpaque(true);
        panel.setBackground(Color.WHITE);

        ImageIcon image = new ImageIcon(getClass().getResource("bookpic.jpg"));
        JLabel label = new JLabel(image);

        panel.add(label);
        frame.add(panel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
