package services;

import models.Character;
import models.Party;

import java.util.ArrayList;



public class CombatService {
    public static ArrayList<Character> makeCombatBetweenRandomCharacters(Party userParty, Party iaParty) {
        Character userPartyCharacter = getRandomUserCharacter(userParty);
        Character iaRandomCharacter = getRandomIaCharacter(iaParty);

        do {
            var characterAttackDmg = userPartyCharacter.attack();

            iaRandomCharacter.setHp(iaRandomCharacter.getHp() - characterAttackDmg);

            if (iaRandomCharacter.getHp() <= 0) {
                iaRandomCharacter.setAlive(false);
            }

            var iaAttackDmg = iaRandomCharacter.attack();
            userPartyCharacter.setHp(userPartyCharacter.getHp() - iaAttackDmg);

            if (userPartyCharacter.getHp() <= 0) {
                userPartyCharacter.setAlive(false);
            }

        } while (iaRandomCharacter.isAlive() && userPartyCharacter.isAlive());



        if(userPartyCharacter.isAlive()){
            System.out.println("User character: " + userPartyCharacter.getName() + " has won vs " + iaRandomCharacter.getName());
        }

        if(iaRandomCharacter.isAlive()){
            System.out.println("IA character: " + iaRandomCharacter.getName() + " has won vs " + userPartyCharacter.getName());
        }


        var listOfDeadCharacters = new ArrayList<Character>();

        // TODO ! >>>>> Add if character is from IA or is From User
        for (Character character: userParty.getCharacters()) {
            if(!character.isAlive()) {
                listOfDeadCharacters.add(character);
            }
        }

        for (Character character: iaParty.getCharacters()) {
            if(!character.isAlive()) {
                listOfDeadCharacters.add(character);
            }
        }

        UserPartyService.showUserAvailableCharacters(listOfDeadCharacters);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



        return listOfDeadCharacters;
    }

    private static Character getRandomIaCharacter(Party iaParty) {
        var iaPartyCharacters = iaParty.getAliveCharacters();
        int atRandomIndex = 0;
        for (int i = 0; i < iaPartyCharacters.size(); i++) {
            atRandomIndex = (int) (Math.random() * iaPartyCharacters.size());
        }
        if(!iaPartyCharacters.get(atRandomIndex).hasPlay()){
            return iaPartyCharacters.get(atRandomIndex);
        }
        return null;
    }

    private static Character getRandomUserCharacter(Party userParty) {
        var userPartyCharacters = userParty.getAliveCharacters();
        int atRandomIndex = 0;
        for (int i = 0; i < userPartyCharacters.size(); i++) {
            atRandomIndex = (int) (Math.random() * userPartyCharacters.size());
        }
        if(!userPartyCharacters.get(atRandomIndex).hasPlay()){
            return userPartyCharacters.get(atRandomIndex);
        }
        return null;
    }
}
