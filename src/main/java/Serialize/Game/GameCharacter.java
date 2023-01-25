package Serialize.Game;

import java.io.Serializable;
import java.util.Arrays;

public class GameCharacter implements Serializable {
    private int power;
    private String[] weapons;
    private String type;
    private int health;
    private int mana;

    GameCharacter(int power, int health, int mana, String type, String[] weapons){
        this.power = power;
        this.health = health;
        this.mana = mana;
        this.type = type;
        this.weapons = weapons;
    }

    public void getAll(){
        System.out.println("Сила = " + power + " Здоровье = " + health + " Мана = " + mana + " Тип = " + type +
                " Оружия = " + Arrays.toString(weapons));
    }

    public int getPower() {
        return power;
    }

    public String[] getWeapons() {
        return weapons;
    }

    public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }
}
