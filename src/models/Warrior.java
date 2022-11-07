package models;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Warrior extends Character {

    int stamina, strength;




    // * Random constructor
    public Warrior(String name) {
        super(name);
        setTypeOfCharacter("Warrior");
        setStamina();
        setStrength();
        warriorHp();

    }

    // TODO: Custom constructor to implement when ready


    public Warrior(String id, String name, int hp, int stamina, int strength) {
        super(id, name, hp);
        this.stamina = stamina;
        this.strength = strength;
        setTypeOfCharacter("Warrior");
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina() {
        this.stamina = Utils.getRandomNum(10, 50);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength() {

        this.strength = Utils.getRandomNum(1, 10);
    }

    public void warriorHp() {

        int warriorHp = Utils.getRandomNum(100, 200);
        setHp(warriorHp);
    }

    @Override
    public void attack() {
        System.out.println("I'm a Warrior calling the attack() method.");
    }

    @Override
    public String dataToString() {

       String characterStats = "";

        String parseID, parseHp, parseStamina, parseStrength;;

        parseHp = String.valueOf(getHp());
        parseID = String.valueOf(getId());
        parseStamina = String.valueOf(this.stamina);
        parseStrength = String.valueOf(this.strength);

        characterStats += parseID + ", ";
        characterStats += getTypeOfCharacter() + ", ";
        characterStats += getName() + ", ";
        characterStats += parseHp + ", ";
        characterStats += parseStamina + ", ";
        characterStats += parseStrength;

        return characterStats;
    }

    @Override
    public String toString() {
        String string;
        string = super.toString();
        return string + ","+
               getTypeOfCharacter() +","+
                "stamina=" + stamina +
                ", strength=" + strength +
                '}';
    }
}
