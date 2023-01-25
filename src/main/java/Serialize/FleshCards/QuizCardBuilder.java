package Serialize.FleshCards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class QuizCardBuilder {

    private JTextArea question;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    private JFrame frame;
    private JLabel cardListCount;

    public static void main(String[] args) {
        QuizCardBuilder builder = new QuizCardBuilder();
        builder.go();
    }

    public void go() {
        frame = new JFrame("Flesh cards");
        JPanel miniPanel = new JPanel();
        JPanel answerPanel = new JPanel();
        JPanel questionPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 20);
        question = new JTextArea(6,20);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(bigFont);

        JScrollPane sp1 = new JScrollPane(question);
        sp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        answer = new JTextArea(6,20);
        answer.setFont(bigFont);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);

        JScrollPane sp2 = new JScrollPane(answer);
        sp2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JButton button = new JButton("Next card");
        cardList = new ArrayList<QuizCard>();
        JLabel qLabel = new JLabel("Вопрос:");
        JLabel aLabel = new JLabel("Ответ:");
        cardListCount = new JLabel("Количество карточек: 0");

        miniPanel.setLayout(new BoxLayout(miniPanel,BoxLayout.Y_AXIS));
        questionPanel.add(qLabel);
        questionPanel.add(sp1);
        answerPanel.add(aLabel);
        answerPanel.add(sp2);
        miniPanel.add(questionPanel);
        miniPanel.add(answerPanel);
        buttonPanel.add(button);
        buttonPanel.add(cardListCount);
        miniPanel.add(buttonPanel);
        button.addActionListener(new NextCardListener());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Файл");
        JMenuItem newMenuItem = new JMenuItem("Создать новый список");
        JMenuItem saveMenuItem = new JMenuItem("Сохранить текущий список");
        newMenuItem.addActionListener(new NewMenuListener());
        saveMenuItem.addActionListener(new SaveMenuListener());
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, miniPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,600);
        frame.setVisible(true);
    }

    private class NextCardListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            QuizCard card = new QuizCard(question.getText(), answer.getText());
            cardList.add(card);
            cardListCount.setText("Количество карточек: " + cardList.size());
            clearCard();
        }
    }

    private class SaveMenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            QuizCard card = new QuizCard(question.getText(), answer.getText());
            cardList.add(card);

            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            saveFile(fileSave.getSelectedFile());
        }
    }

    private class NewMenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            cardList.clear();
            clearCard();
            cardListCount.setText("Количество карточек: 0");
        }
    }

    public void clearCard(){
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }

    private void saveFile(File file) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            int i = 1;
            for (QuizCard card: cardList){
                writer.write(i + ". " + card.getQuestion() + " / ");
                writer.write(card.getAnswer() + "\n");
                i++;
            }
            writer.close();
        } catch (IOException e){
            System.out.println("невозможно записать");
            e.printStackTrace();
        }
    }
}
