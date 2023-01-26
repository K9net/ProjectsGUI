package NetworkAndThreads.SimpleChat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    JTextField outgoing;
    PrintWriter writer;
    Socket socket;

    public static void main(String[] args) {
        new ChatClient().go();
    }

    public void go(){
        JFrame frame = new JFrame("Простой клиент чата");
        JPanel miniPanel = new JPanel();
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Отправить");
        sendButton.addActionListener(new SendButtonListener());
        miniPanel.add(outgoing);
        miniPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, miniPanel);
        setUpNetworking();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        frame.setVisible(true);
    }

    public void setUpNetworking(){
        try{
            socket = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(socket.getOutputStream());
            System.out.println("Соединение установлено");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                writer.println(outgoing.getText());
                writer.flush();
            } catch (Exception ex){
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }

}
