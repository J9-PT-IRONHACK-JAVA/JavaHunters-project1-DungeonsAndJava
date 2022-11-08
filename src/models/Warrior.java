package models;

import utils.Utils;

public class Warrior extends Character {

    int stamina = Utils.getRandomNum(10, 50);
    int strength = Utils.getRandomNum(1, 10);


    // * Random constructor
    public Warrior(String name) {
        super(name);
        setTypeOfCharacter("Warrior");
        warriorHp();
    }

    // TODO: Custom constructor to implement when ready


    public Warrior(String id, String name, int hp, int stamina, int strength) {
        super(id, name, hp);
        this.strength = strength;
        setTypeOfCharacter("Warrior");
        warriorHp();
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = Math.max(stamina, 0);
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
    public int attack() {
        int strength = getStrength();
        int stamina = getStamina();

        int dmgHeavyAttack = strength;
        int dmgWeakAttack = strength / 2;

        int attackDmg;


        if (stamina >= strength) {
            // * Heavy Attack
            int newStaminaAfterAttack = stamina - 5;
            setStamina(newStaminaAfterAttack);
            attackDmg = dmgHeavyAttack;
        } else {
            // * weak attack
            int newStaminaAfterAttack = stamina + 1;
            setStamina(newStaminaAfterAttack);
            attackDmg = dmgWeakAttack;
        }
        return attackDmg;
    }


    @Override
    public String dataToString() {

        String characterStats = "";

        String parseID, parseHp, parseStamina, parseStrength;
        ;

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
        return string + "," +
                getTypeOfCharacter() + "," +
                "stamina=" + stamina +
                ", strength=" + strength +
                '}';
    }
}
