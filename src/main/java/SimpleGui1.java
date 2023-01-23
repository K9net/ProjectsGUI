import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui1 implements ActionListener {
    JButton button;

    public static void main(String[] args) {
        SimpleGui1 gui = new SimpleGui1();
        gui.go();
    }
    public void go(){
        JFrame frame = new JFrame();
        button = new JButton("Кликни!");
        button.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100,1100);
        frame.setVisible(true);
        MyDrawPanel panel = new MyDrawPanel();
        frame.add(panel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("Я нажата!");
    }
}
