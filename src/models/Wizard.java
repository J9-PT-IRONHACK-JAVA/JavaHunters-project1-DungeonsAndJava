package models;

import utils.Utils;

import java.util.UUID;

public class Wizard extends Character {

    int mana, intelligence;
    // * Random constructor
    public Wizard(String name) {
        super(name);
        setTypeOfCharacter("Wizard");
        wizardHp();
        setMana();
        setIntelligence();
    }

    // TODO: Custom constructor to implement when ready
    public Wizard(String id,String name, int hp, int mana, int intelligence) {

        super(id,name, hp);
        setTypeOfCharacter("Wizard");
        this.mana = mana;
        this.intelligence = intelligence;
    }

    public int getMana() {
        return mana;
    }

    public void setMana() {
        this.mana = Utils.getRandomNum(10, 50);
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence() {

        this.intelligence = Utils.getRandomNum(1, 50);
    }

    public void wizardHp() {
        int wizardHp = Utils.getRandomNum(50, 100);
        setHp(wizardHp);
    }

    @Override
    public void attack() {
        System.out.println("I'm a Wizard calling the attack() method.");
    }

    @Override
    public String dataToString() {

        String characterStats = "";

        String parseID, parseHp, parseMana, parseIntelligence;

        parseHp = String.valueOf(getHp());
        parseID = String.valueOf(getId());
        parseMana = String.valueOf(this.mana);
        parseIntelligence = String.valueOf(this.intelligence);

        characterStats += parseID + ", ";
        characterStats += getTypeOfCharacter() + ", ";
        characterStats += getName() + ", ";
        characterStats += parseHp + ", ";
        characterStats += parseMana + ", ";
        characterStats += parseIntelligence;

        return characterStats;
    }
    @Override
    public String toString() {
        String string;
        string = super.toString();
        return string + ","+

                getTypeOfCharacter() + ","+
                "Mana=" + mana +
                ", Intelligence=" + intelligence +
                '}';
    }
}
