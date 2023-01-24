import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SwingComponents implements ActionListener, ItemListener, ListSelectionListener {
    JTextArea textArea;
    JCheckBox checkBox;
    JList<String> list;

    public static void main(String[] args) {
        SwingComponents gui = new SwingComponents();
        gui.go();
    }

    public void go(){
        JFrame frame = new JFrame("Swing components");
        JPanel panel = new JPanel();
        JButton button = new JButton("Click me");
        button.addActionListener(this);
        textArea = new JTextArea(10,20);
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(scrollPane);

        checkBox = new JCheckBox("Click here");
        checkBox.addItemListener(this);
        panel.add(checkBox);

        String[] listEntries = {"alpha", "beta", "gamma", "delta", "epsilon", "theta", "eta", "zeta"};
        list = new JList<>(listEntries);
        JScrollPane scrollPane1 = new JScrollPane(list);
        scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        list.setVisibleRowCount(5);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(this);
        panel.add(scrollPane1);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textArea.append("Button clicked \n");
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(checkBox.isSelected())
            textArea.append("Checkbox selected \n");
        else textArea.append("Not selected \n");
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()) {
            textArea.append(list.getSelectedValue() + "\n");
        }
    }
}
