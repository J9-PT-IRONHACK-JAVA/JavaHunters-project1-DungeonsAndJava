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


        // TODO ! >>>>> Be able to add all the dead characters. At this moment is just adding one of them.

        var listOfDeadCharacters = new ArrayList<Character>();

        if(!userPartyCharacter.isAlive()){
            listOfDeadCharacters.add(userPartyCharacter);
        }

        if(!iaRandomCharacter.isAlive()){
            listOfDeadCharacters.add(iaRandomCharacter);
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
