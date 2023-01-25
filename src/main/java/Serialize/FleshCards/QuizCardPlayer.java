package Serialize.FleshCards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class QuizCardPlayer {

    private JTextArea display;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    private QuizCard currentCard;
    private int currentCardIndex;
    private JFrame frame;
    private JButton nextButton;
    private boolean isShowAnswer;

    public static void main(String[] args) {
        QuizCardPlayer reader = new QuizCardPlayer();
        reader.go();
    }

    public void go(){
        frame = new JFrame("Игра Вопрос-Ответ");
        JPanel miniPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 20);

        display = new JTextArea(10,20);
        display.setFont(bigFont);
        display.setLineWrap(true);
        display.setWrapStyleWord(true);
        display.setEditable(false);

        JScrollPane sp1 = new JScrollPane(display);
        sp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        nextButton = new JButton("Показать ответ");

        miniPanel.add(sp1);
        miniPanel.add(nextButton);
        nextButton.addActionListener(new NextCardLisnter());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Файл");
        JMenuItem loadMenuItem = new JMenuItem("Загрузить карточки");
        loadMenuItem.addActionListener(new OpenMenuListener());
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, miniPanel);
        frame.setSize(640, 400);
        frame.setVisible(true);
    }

    class NextCardLisnter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(isShowAnswer){
                display.setText(currentCard.getAnswer());
                nextButton.setText("Следующая карточка");
                isShowAnswer = false;
            } else {
                if(currentCardIndex < cardList.size()){
                    showNextCard();
                } else{
                    display.setText("Просмотр карточек окончен!");
                    nextButton.setEnabled(false);
                }
            }
        }
    }

    class OpenMenuListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(frame);
            loadFile(fileChooser.getSelectedFile());
        }
    }

    private void showNextCard(){
        currentCard = cardList.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentCard.getQuestion());
        nextButton.setText("Показать ответ");
        isShowAnswer = true;
    }

    private void loadFile(File file){
        cardList = new ArrayList<QuizCard>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null){
                makeCard(line);
            }
            reader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        showNextCard();
    }

    private void makeCard(String lineToParse){
        String[] result = lineToParse.split("/");
        QuizCard card = new QuizCard(result[0], result[1]);
        cardList.add(card);
        System.out.println("Карточка создана");
    }
}
