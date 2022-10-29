package models;

import java.util.Random;

public class Warrior extends Character{

    int stamina;
    int strength; //random between 10-50, between 1-10

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {

        int minValue, maxValue, randomNum;
        Random random = new Random();

        minValue = 10;
        maxValue = 50;

        randomNum = random.nextInt(maxValue - minValue) + minValue;
        System.out.println(randomNum);

        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


    public Warrior(String name, int hp) {
        super(name, hp);
    }



    @Override
    public void attack() {

    }


}
