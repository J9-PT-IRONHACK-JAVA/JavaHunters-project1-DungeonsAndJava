package models;

import utils.Utils;

import java.util.UUID;

public class Wizard extends Character {

    int mana = Utils.getRandomNum(10, 50);
    int intelligence = Utils.getRandomNum(1, 50);

    // * Random constructor
    public Wizard(String name) {
        super(name);
        setTypeOfCharacter("Wizard");
        wizardHp();
    }

    // TODO: Custom constructor to implement when ready
    public Wizard(String id,String name, int hp, int mana, int intelligence) {

        super(id,name, hp);
        setTypeOfCharacter("Wizard");
        this.mana = mana;
        this.intelligence = intelligence;
        wizardHp();
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = Math.max(mana, 0);
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
    public int attack() {
        int intelligence = getIntelligence();
        int mana = getMana();

        int dmgFireballAttack = intelligence;
        int dmgStaffAttack = 2;

        int attackDmg;

        if(mana >= intelligence){
            // * Fireball
            int newManaAfterAttack = mana - 5;
            setMana(newManaAfterAttack);
            attackDmg = dmgFireballAttack;
        } else {
            // * Staff hit
            int newManaAfterAttack = mana + 1;
            setMana(newManaAfterAttack);
            attackDmg = dmgStaffAttack;
        }

        return attackDmg;
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
        return string + ", "+
                getTypeOfCharacter() + ", "+
                "Mana " + mana +
                ", Intelligence " + intelligence;
    }
}
