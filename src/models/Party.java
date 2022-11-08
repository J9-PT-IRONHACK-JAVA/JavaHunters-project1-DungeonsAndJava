package models;

import java.util.ArrayList;

public class Party {
    private ArrayList<Character> characters;

    public Party(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public Party(){

    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public ArrayList<Character> getAliveCharacters(){
        ArrayList<Character> charactersAlive = new ArrayList<>();
        for (Character character: characters) {
            if(character.isAlive()){
                charactersAlive.add(character);
            }
        }
        return charactersAlive;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        String string;
        string = "";

        for(Character character1: this.characters){
            string += character1.toString() + "\n";
        }
        return string;
    }
}
