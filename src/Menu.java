import models.Character;
import java.util.Random;

import models.Party;
import models.Warrior;
import models.Wizard;
import org.w3c.dom.ranges.Range;
import utils.ConsoleColors;
import utils.Messages;
import utils.Utils;

import java.io.*;
import java.nio.charset.CharsetEncoder;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.w3c.dom.ranges.Range.*;

public class Menu {

    static String userName;
    static String teamName;
    static String computerName = "AI";
    static String computerTeamName = "House of the Dragons";
    static int difficulty;


    public static void startGame() throws FileNotFoundException {
        var sc = new Scanner(System.in);

        welcomeUserName();
        setGameSettings(sc);

        sc.close();
    }


    public static void welcomeUserName() {
        System.out.println("Welcome to Dungeons And Java!");
    }

    public static void setGameSettings(Scanner sc) throws FileNotFoundException {
        registerUserName(sc);
        registerUserTeamName(sc);

        // * difficulty registration
        System.out.println("Choose wisely your desired difficulty level from 0 to 2\n0: A Walk In The Park\n1: Middle" +
                " Of The Road\n2: Nightmare!");
        //Put the dificult inside a method?
        boolean toExit = true;
        while (toExit) {
            String input = sc.nextLine();

            switch (input) {
                case "0":
                    System.out.println("You selected: A Walk In The Park");
                    difficulty = 0;
                    toExit = false;
                    break;
                case "1":
                    System.out.println("You selected: Middle Of The Road");
                    difficulty = 1;
                    toExit = false;
                    break;
                case "2":
                    System.out.println("You selected: Nightmare!");
                    difficulty = 2;
                    toExit = false;
                    break;
                default:
                    System.out.println("Selection unrecognised. Remember mortal, select from 0 to 2!");
            }
            teamUp(sc);
        }

        var readFile = readFromFile("src/repository/database/IAdB/difficulty-" + difficulty + ".csv");

        for (String file : readFile) {
            System.out.println(file);
        }

    }

    private static void registerUserName(Scanner sc) {
        Utils.typewriterFromString(Messages.askUserNameMsg);
        userName = sc.nextLine();
    }

    private static void registerUserTeamName(Scanner sc) {
        Utils.typewriterFromString(Messages.askTeamNameMsg(userName, ConsoleColors.GREEN_BOLD));
        teamName = sc.nextLine();
        Utils.typewriterFromString(Messages.endUserRegistrationMsg(userName, teamName, ConsoleColors.BLUE));
    }

    public static void createPartyOfCharacters(String partyName) {
        System.out.println("Create your team: Add your characters to the team/party");
        // Create 5 random characters
    }
    public static int selectAmountOfMembers(Scanner sc){

        int amountOfMembers;
        Utils.typewriterFromString(Messages.partyMembers(ConsoleColors.GREEN_BOLD));
        amountOfMembers = sc.nextInt();
        return   amountOfMembers;

    }
    public static void teamUp(Scanner sc) throws FileNotFoundException {

        int members;
        String typeOfParty;
        members = selectAmountOfMembers(sc);
        List<Character> charactersArray = loadUserCharactersFromDb();
        //clean sc int buffer
        sc.nextLine();

        Utils.typewriterFromString(Messages.partyType(ConsoleColors.GREEN_BOLD));
        typeOfParty = sc.nextLine();

        switch ( typeOfParty ) {
            case "1":
                Character character;
                String CharacterToString;

                character = createNewCharacter(sc);
                CharacterToString = character.dataToString();
                saveCharacterToDb(CharacterToString);

                break;
            case "2":
                showUserAvaibleCharacters(charactersArray);
                Party newPArty =  saveCharactersToParty(charactersArray,members,sc);
                System.out.println(newPArty.toString());
                break;
            case "3":

                boolean sameRange, correctRange;

                sameRange = partySameRandomRange( members ,charactersArray);
                correctRange = partySameRandomRange(members ,charactersArray);

                Party newRandomPrty = saveRandomParty(sameRange, correctRange, members, charactersArray);
                System.out.println(newRandomPrty.toString());
                break;
            default:
                System.out.println("Selection unrecognised. Remember mortal, select from 1 to 3!");
        }

    }

    public static Party saveRandomParty(boolean correctRange, boolean sameRange, int partyMembers, List<Character>dbCharacters){

        ArrayList <Character> tempCharacterList = new ArrayList<>();
        Random random = new Random();
        boolean exist;
        exist = false;
        int cont;

        if( correctRange ){
            if( sameRange ){
                tempCharacterList.addAll(dbCharacters);
                for(Character character: tempCharacterList){
                    character.toString();
                }
            }else{
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

        sameRange = ( partyMembers == dbAmountOfCharacters)? true: false;
        return sameRange;

    }
    public static boolean partyCorrectRandomRange(int partyMembers, List<Character> dbCharacters){

        boolean correctRange;
        int dbAmountOfCharacters;

        dbAmountOfCharacters = dbCharacters.size();

        correctRange = ( partyMembers > dbAmountOfCharacters)? false: true;
        return correctRange;

    }

    public static Character createNewCharacter(Scanner sc){

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

    public static void saveCharacterToDb(String line) {
        try{
            FileWriter fw = new FileWriter("src/repository/database/userDb/user.csv",true);
            fw.write(line+"\n");
            fw.close();
        }catch(Exception e){System.out.println(e);}
        System.out.println("Success...");
    }

    public static List<Character> loadUserCharactersFromDb() throws FileNotFoundException {

        String filePath, tempName, tempId;
        UUID id;
        int hp, stamina, strength, parseHp, parseStamina, parseStrength, parseMana, parseIntelligence;
        ;
        Character loadedCharacter;

        filePath = "src/repository/database/userDb/user.csv";
        String[] tempsStats = new String[6];
        List<Character> avaibleCharacters = new ArrayList<>();

        File targetFile = new File( filePath );
        Scanner reader = new Scanner(targetFile);
        var readFile = new ArrayList<String>();

        do {

            String line = reader.nextLine();
            String noSpaceLine = line.replaceAll("\\s+","");
            String[] formatedLine = noSpaceLine.split(",");

            for (int  i= 0; i < formatedLine.length; i++) {
                tempsStats[i] = formatedLine[i];
            }

            tempId = tempsStats[0];
            tempName = tempsStats[2];
            parseHp = Integer.parseInt(tempsStats[3]);

            if(tempsStats[1].equals("Warrior")){

                parseStamina = Integer.parseInt(tempsStats[4]);
                parseStrength = Integer.parseInt(tempsStats[5]);

                Warrior tempWarrior = new Warrior(tempId, tempName, parseHp, parseStamina, parseStrength);

                avaibleCharacters.add( tempWarrior );
            }
            else if (tempsStats[1].equals("Wizard")){

                parseMana = Integer.parseInt(tempsStats[4]);
                parseIntelligence = Integer.parseInt(tempsStats[5]);

                Wizard tempWizard = new Wizard(tempId, tempName, parseHp, parseMana, parseIntelligence);

                avaibleCharacters.add( tempWizard );

            }

        } while (reader.hasNextLine());

        reader.close();
       return avaibleCharacters;
    }


    public static void showUserAvaibleCharacters(List<Character> avaibleCharacters){
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%10s %10s %10s %8s %20s %17s", "NUMBER", "NAME", "TYPE", "HP", "MANA/STAM", "INTEL/STREN");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
    //iterates over the list
        int i;
        i = 1;

        for(Character character: avaibleCharacters)
        {

            if(character.getTypeOfCharacter().equals("Wizard")){
                Wizard tempWizar = (Wizard) character;
                System.out.format("%7s %12s %14s %7s %15s %22s",i, tempWizar.getName(), tempWizar.getTypeOfCharacter(), tempWizar.getHp(), tempWizar.getMana(), tempWizar.getIntelligence());
            }
            else if( character.getTypeOfCharacter().equals("Warrior") ){
                Warrior tempWarrior = (Warrior) character;
                System.out.format("%7s %12s %14s %7s %15s %22s",i ,tempWarrior.getName(), tempWarrior.getTypeOfCharacter(), tempWarrior.getHp(), tempWarrior.getStamina(), tempWarrior.getStrength());
            }
            System.out.println();
            i++;
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }
    public static Party saveCharactersToParty(List<Character> dbCharacters, int amountOfPartyMembers, Scanner sc){

        int choise, limit;
        boolean exist, added;
        Character selectedCharacter;

        added = false;
        limit = dbCharacters.size();
        ArrayList<Character> tempList = new ArrayList();

        while( tempList.size() != amountOfPartyMembers  ){
            exist = false;
            System.out.println("Enter the character number");
            choise = sc.nextInt();
            if(choise < 1 || choise > limit){
                System.out.println("Bad selection");
            }else{

                selectedCharacter = dbCharacters.get(choise-1);
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
    private static ArrayList<String> readFromFile(String path) throws FileNotFoundException {
        File targetFile = new File(path);
        Scanner reader = new Scanner(targetFile);
        var readFile = new ArrayList<String>();

        do {
            readFile.add(reader.nextLine());
        } while (reader.hasNextLine());

        reader.close();
        return readFile;
    }

}
