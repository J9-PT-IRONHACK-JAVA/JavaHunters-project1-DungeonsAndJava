package services;

import models.Character;
import models.Party;
import models.Warrior;
import models.Wizard;
import repository.UserPartyRepository;
import repository.UserPartyRepositoryImp;
import utils.ConsoleColors;
import utils.Messages;
import utils.Utils;

import java.io.Console;
import java.io.FileNotFoundException;
import java.util.*;

public class UserPartyService {

    private final UserPartyRepository userPartyRepository;

    public UserPartyService() {
        userPartyRepository = new UserPartyRepositoryImp();
    }

    public static int selectAmountOfMembers(Scanner sc){
        int amountOfMembers;
        Utils.typewriterFromString(Messages.partyMembers(ConsoleColors.BLUE_BOLD_BRIGHT), 5);
        amountOfMembers = sc.nextInt();
        return amountOfMembers;
    }

    public static Party saveRandomParty(boolean correctRange, boolean sameRange, int partyMembers, List<Character> dbCharacters) {
        ArrayList<Character> tempCharacterList = new ArrayList<>();
        Random random = new Random();
        boolean exist;
        exist = false;

        if(correctRange) {
            if(sameRange) {
                //tempCharacterList.addAll(dbCharacters);
                Random numberGenerator = new Random();
                int nextRandom = numberGenerator.nextInt(partyMembers + 1);
                Set<Integer> validate = new HashSet<>();
                validate.add(nextRandom);

                for (int i = 0; i < partyMembers; i++) {
                    while(validate.contains(nextRandom)) {
                        nextRandom = numberGenerator.nextInt(partyMembers + 1);
                    }

                    validate.add(nextRandom);
                    tempCharacterList.add(dbCharacters.get(nextRandom));
                }

            }else {
                while(tempCharacterList.size() < partyMembers){
                    int randomNum = random.nextInt(partyMembers + 1);
                    if(tempCharacterList.size() == 0){
                        tempCharacterList.add(dbCharacters.get(randomNum));
                    }else{
                        for (int i = 0; i < tempCharacterList.size(); i++) {

                            if(tempCharacterList.get(randomNum).getName().equals(dbCharacters.get(randomNum).getName())) {
                                exist = true;
                            }
                        }
                        if(!exist){
                            tempCharacterList.add(dbCharacters.get(randomNum));
                        }

                    }
                }
            }
        }else System.out.println("You should add new members to db to a random party");
        Party newParty = new Party(tempCharacterList);
        return newParty;
    }

    public static boolean partySameRandomRange(int partyMembers, List<Character> dbCharacters){
        boolean sameRange;
        int dbAmountOfCharacters;

        dbAmountOfCharacters = dbCharacters.size();
        sameRange = (partyMembers == dbAmountOfCharacters) ? true: false;
        return sameRange;
    }

    public static Character createNewCharacter(Scanner sc) {
        String name, type;
        Character newCharacter = null;
        System.out.println("""
                \tCharacter type
                [  1 --> Warrior ]
                [  2 --> Wizard  ]
                """);
        type = sc.nextLine();

        System.out.println("Character name");

        name = sc.nextLine();

        if(type.equals("1")) {
            newCharacter = new Warrior(name);
        } else if (type.equals("2")) {
            newCharacter = new Wizard(name);
        }

        System.out.println("New Character has been created..."+newCharacter.toString());
        return newCharacter;
    }

    public void saveCharacterToDb(String line) {
        userPartyRepository.saveCharacterToDb(line);
    }

    public List<Character> loadUserCharactersFromDb() throws FileNotFoundException {
        String tempName, tempId;
        int parseHp, parseStamina, parseStrength, parseMana, parseIntelligence;
        List<Character> availableCharacters = new ArrayList<>();
        String[] tempsStats = new String[6];

        var targetFile = userPartyRepository.loadUserCharactersFromDb();
        Scanner reader = new Scanner(targetFile);

        do {
            String line = reader.nextLine();
            String noSpaceLine = line.replaceAll("\\s+","");
            String[] formattedLine = noSpaceLine.split(",");

            for (int  i= 0; i < formattedLine.length; i++) {
                tempsStats[i] = formattedLine[i];
            }

            tempId = tempsStats[0];
            tempName = tempsStats[2];
            parseHp = Integer.parseInt(tempsStats[3]);

            if(tempsStats[1].equals("Warrior")){
                parseStamina = Integer.parseInt(tempsStats[4]);
                parseStrength = Integer.parseInt(tempsStats[5]);

                Warrior tempWarrior = new Warrior(tempId, tempName, parseHp, parseStamina, parseStrength);

                availableCharacters.add( tempWarrior );
            }
            else if (tempsStats[1].equals("Wizard")){
                parseMana = Integer.parseInt(tempsStats[4]);
                parseIntelligence = Integer.parseInt(tempsStats[5]);

                Wizard tempWizard = new Wizard(tempId, tempName, parseHp, parseMana, parseIntelligence);

                availableCharacters.add( tempWizard );
            }

        } while (reader.hasNextLine());

        reader.close();
        return availableCharacters;
    }

    public static void showUserAvailableCharacters(List<Character> availableCharacters) {
        System.out.println(" ");
        System.out.println(" ");
        System.out.printf(utils.ConsoleColors.PURPLE_BOLD_BRIGHT + "%10s %20s %10s %10s %20s " +
                                                "%20s",
                "NUMBER" , "NAME", "TYPE", "HP", "MANA/STAM", "INTEL/STREN" + ConsoleColors.RESET);
        System.out.println(" ");
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT +
                "---------------------------------------------------------------------------------------------" + ConsoleColors.RESET);
        int i;
        i = 1;

        for(Character character: availableCharacters)
        {
            if(character.getTypeOfCharacter().equals("Wizard")){
                Wizard tempWizard = (Wizard) character;
                System.out.format(ConsoleColors.CYAN_BOLD_BRIGHT + "%10s %20s %10s %10s %20s %20s",i,
                        tempWizard.getName(),
                        tempWizard.getTypeOfCharacter(), tempWizard.getHp(), tempWizard.getMana(),
                        tempWizard.getIntelligence() + ConsoleColors.RESET);
            }
            else if( character.getTypeOfCharacter().equals("Warrior") ){
                Warrior tempWarrior = (Warrior) character;
                System.out.format(ConsoleColors.CYAN_BOLD_BRIGHT + "%10s %20s %10s %10s %20s %20s",i ,
                        tempWarrior.getName(),
                        tempWarrior.getTypeOfCharacter(), tempWarrior.getHp(), tempWarrior.getStamina(),
                        tempWarrior.getStrength() + ConsoleColors.RESET);
            }
            System.out.println();
            i++;
        }
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT +
                           "---------------------------------------------------------------------------------------------" + ConsoleColors.RESET);
        System.out.println(" ");
        System.out.println(" ");
    }

    public static Party saveCharactersToParty(List<Character> dbCharacters, int amountOfPartyMembers, Scanner sc) {
        int choice, limit;
        boolean exist;
        Character selectedCharacter;
        limit = dbCharacters.size();
        ArrayList<Character> tempList = new ArrayList();

        while( tempList.size() != amountOfPartyMembers  ){
            exist = false;
            Utils.typewriterFromString(Messages.enterCharacterNumber, 5);
            System.out.println("Enter the character number");
            choice = sc.nextInt();
            if(choice < 1 || choice > limit){
                System.out.println("Bad selection");
            }else{

                selectedCharacter = dbCharacters.get(choice-1);
                if(tempList.size() == 0){
                    tempList.add(selectedCharacter);
                }else{
                    for (int i = 0; i < tempList.size(); i++) {

                        if(selectedCharacter.getName().equals(tempList.get(i).getName())) {
                            exist = true;
                            System.out.println("Cannot repeat the same character");
                        }
                    }
                    if(!exist){
                        tempList.add(selectedCharacter);
                    }

                }

            }
        }

        Party userParty = new Party(tempList);
        return userParty;
    }
}
