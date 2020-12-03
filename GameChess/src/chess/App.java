package chess;

import javax.swing.*;
import java.awt.*;

public class App extends JPanel{

    public void paint(Graphics s)
    {
        s.fillRect(100,100,400,400);
        s.clearRect(100,100,50,50);
    }


    public static void main(String[] args)
    {
        JFrame frame=new JFrame();
        frame.setSize(600,600);
        frame.getContentPane().add(new App());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
