package SwingComponents;

import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
        //Рисовка изображения
//        Image image = new ImageIcon("src/main/resources/Image.jpg").getImage();
//        g.drawImage(image,5,5,this);

        //Рисовка фигуры
        //g.fillRect(0,0,this.getWidth(),this.getHeight());
            int red = (int) (Math.random()*255);
            int green = (int) (Math.random()*255);
            int blue = (int) (Math.random()*255);

            Color randomColor = new Color(red,green,blue);
            g.setColor(randomColor);
            g.fillOval(50,50,100,100);

        //Рисовка фигуры в 2D
//        Graphics2D g2d = (Graphics2D) g;
//        GradientPaint gradient = new GradientPaint(70,70,Color.blue,150,150,Color.orange);
//        g2d.setPaint(gradient);
//        g2d.fillOval(70,70,100,100);
    }
}
