package Serialize.Game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameSaver {
    public static void main(String[] args) {
        GameCharacter first = new GameCharacter(300, 1000, 500, "Троль",
                new String[]{"Волына, перчатки, хлыст"});
        GameCharacter second = new GameCharacter(100, 2000, 1100, "Маг",
                new String[]{"Трость, мантия, кольцо"});
        GameCharacter third = new GameCharacter(500, 1500, 700, "Боец",
                new String[]{"Снайперская винтовка, сабля"});

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("GameSaver.ser"));
            os.writeObject(first);
            os.writeObject(second);
            os.writeObject(third);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("GameSaver.ser"));
            GameCharacter firstRestore = (GameCharacter) is.readObject();
            GameCharacter secondRestore = (GameCharacter) is.readObject();
            GameCharacter thirdRestore = (GameCharacter) is.readObject();
            is.close();
            firstRestore.getAll();
            secondRestore.getAll();
            thirdRestore.getAll();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
