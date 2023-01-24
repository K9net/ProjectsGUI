import javax.swing.*;
import java.awt.*;

public class SwingLearning {
    public static void main(String[] args) {
        SwingLearning gui = new SwingLearning();
        gui.go();
    }
    public void go(){
        JFrame frame = new JFrame();
        JButton button1 = new JButton("Нажми 1");
        JButton button2 = new JButton("Нажми 2");
        JButton button3 = new JButton("Нажми 3");
        JButton button4 = new JButton("Нажми 4");
        JButton button5 = new JButton("Нажми 5");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.NORTH, button1);
        frame.getContentPane().add(BorderLayout.EAST, button2);
        frame.getContentPane().add(BorderLayout.WEST, button3);
        frame.getContentPane().add(BorderLayout.CENTER, button4);
        frame.getContentPane().add(BorderLayout.SOUTH, button5);
        frame.setSize(200,200);
        frame.setVisible(true);
    }
}
