package Serialize;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserialize {
    public static void main(String[] args) {
        try{
            FileInputStream fs = new FileInputStream("test.ser");
            ObjectInputStream os = new ObjectInputStream(fs);
            Object serialize = os.readObject();
            Serialize test1 = (Serialize) serialize;
            os.close();
            System.out.println(test1.getWidth());
            System.out.println(test1.getHeight());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
