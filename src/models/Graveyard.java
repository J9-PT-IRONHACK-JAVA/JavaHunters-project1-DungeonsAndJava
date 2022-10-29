package models;

import java.util.ArrayList;

public class Graveyard {

    ArrayList<Character> graveyard;

    public Graveyard(ArrayList<Character> graveyard) {
        this.graveyard = graveyard;
    }

    public ArrayList<Character> getGraveyard() {
        return graveyard;
    }

    public void setGraveyard(ArrayList<Character> graveyard) {
        this.graveyard = graveyard;
    }

    @Override
    public String toString() {
        return "Graveyard{" +
                "graveyard=" + graveyard +
                '}';
    }
}
