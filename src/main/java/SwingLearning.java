import javax.swing.*;
import java.awt.*;

public class SwingLearning {
    public static void main(String[] args) {
        SwingLearning gui = new SwingLearning();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame("SwingLearning");
        JPanel panel = new JPanel();
        panel.setBackground(Color.orange);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.getContentPane().add(BorderLayout.EAST, panel);

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        JLabel label = new JLabel("Просто надпись");
        JTextField textField = new JTextField("Type text", 20);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.cyan);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        frame.getContentPane().add(BorderLayout.WEST, panel2);
        panel2.add(label);
        panel2.add(textField);
        System.out.println(textField.getText());

        JTextArea textArea = new JTextArea(10,20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel2.add(scrollPane);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }
}
