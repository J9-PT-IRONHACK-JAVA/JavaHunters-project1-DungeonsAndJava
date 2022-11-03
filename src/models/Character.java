package models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Character implements Attacker {
    private UUID id = UUID.randomUUID();
    private String name, typeOfCharacter, strId;
    private int hp;
    private boolean isAlive = true;

    // * Random constructor
    public Character(String name) {
        this.name = name;
    }

    // TODO: Custom constructor to implement when ready


    public Character(String strId, String name, int hp) {
        this.strId = strId;
        this.name = name;
        this.hp = hp;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getTypeOfCharacter() {return typeOfCharacter;}

    public void setTypeOfCharacter(String typeOfCharacter) {this.typeOfCharacter = typeOfCharacter;}
    public String getStrId() {
        return strId;
    }

    public void setStrId(String strId) {
        this.strId = strId;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", isAlive=" + isAlive +
                '}';
    }

    public  String dataToString(){
        return null;
    };

}
