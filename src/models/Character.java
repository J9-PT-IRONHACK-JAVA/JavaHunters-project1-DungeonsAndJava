package models;

import java.util.UUID;

public abstract class Character implements Attacker{
    private UUID id = UUID.randomUUID();
    private String name;
    private int hp;
    private boolean isAlive = true;

    public Character( String name){
        this.name = name;
    }

    //Custom costructor to implement!!!
    public Character(String name, int hp) {
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

    public void setHp(int hp){
        this.hp = hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
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

}
