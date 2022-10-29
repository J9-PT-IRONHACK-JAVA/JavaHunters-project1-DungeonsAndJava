package models;

import java.util.ArrayList;

public class Party {
    private ArrayList<Character> characters;

    public Party(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "Party{" +
                "characters=" + characters +
                '}';
    }
}
