package Serialize;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialize implements Serializable {
    private int width;
    private int height;
    private transient int weight;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static void main(String[] args) {
        Serialize serialize = new Serialize();
        serialize.setHeight(20);
        serialize.setWidth(20);
        serialize.setWeight(300);

        try {
            FileOutputStream fs = new FileOutputStream("test.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(serialize);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
