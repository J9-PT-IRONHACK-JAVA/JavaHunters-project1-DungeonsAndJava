package services;

import models.Character;
import models.Party;
import utils.ConsoleColors;
import utils.Messages;
import utils.Utils;

import java.io.Console;
import java.util.ArrayList;



public class CombatService {
    public static ArrayList<Character> makeCombatBetweenRandomCharacters(Party userParty, Party iaParty) throws InterruptedException {
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
            Utils.typewriterFromString(ConsoleColors.WHITE_BOLD_BRIGHT + "👤 " + userPartyCharacter.getName() + " has " +
                                                                       "won vs " + iaRandomCharacter.getName() + " " +
                                       "💀🤖" + ConsoleColors.RESET, 50);
            System.out.println(" ");
        }

        if(iaRandomCharacter.isAlive()){
            Utils.typewriterFromString(ConsoleColors.WHITE_BOLD_BRIGHT + "🤖 " + iaRandomCharacter.getName() + " has " +
                                       "won vs " + userPartyCharacter.getName() + " 💀👤" + ConsoleColors.RESET, 50);
            System.out.println(" ");
        }

        if(userPartyCharacter.isAlive()){
            System.out.println(" ");
            Utils.typewriterFromString(Messages.userWinCombat, 5);
            System.out.println(" ");
        }

        if(iaRandomCharacter.isAlive()){
            Utils.typewriterFromString(Messages.aiWinComabt, 5);
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

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ℹ️ Graveyard status ⬇️");
        UserPartyService.showUserAvailableCharacters(listOfDeadCharacters);

        Thread.sleep(5000);
        if(userParty.getAliveCharacters().size() == 0){
            Utils.typewriterFromString(Messages.aiWonGame, 5);
        }

        if (iaParty.getAliveCharacters().size() == 0) {
            Utils.typewriterFromString(Messages.userWonGame,5);
        }

        try {
            Thread.sleep(4000);
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
