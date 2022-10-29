package models;

import utils.Utils;

import java.util.Random;

public class Warrior extends Character{

    int stamina, strength;

    public Warrior(String name) {

        super(name);
        setStamina();
        setStrength();
        warriorHp();
    }

    //Custom costructor to implement!!!
    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
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

    public void warriorHp(){

        int warriorHp = Utils.getRandomNum(100, 200);
        setHp(warriorHp);
    }


    @Override
    public String toString() {
        String string;
        string = super.toString();
        return  string+
                "Warrior{" +
                "stamina=" + stamina +
                ", strength=" + strength +
                '}';
    }

    @Override
    public void attack() {
        System.out.println("Juan");
    }


}
