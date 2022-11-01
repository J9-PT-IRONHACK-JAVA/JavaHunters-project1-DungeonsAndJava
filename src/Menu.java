import models.Character;
import models.Warrior;
import models.Wizard;
import utils.ConsoleColors;
import utils.Messages;
import utils.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {

    static String userName;
    static String teamName;
    static String computerName = "AI";
    static String computerTeamName = "House of the Dragons";
    static int difficulty;


    public static void startGame() throws FileNotFoundException {
        var sc = new Scanner(System.in);

        Warrior test = new Warrior("dani");
        System.out.println(test.dataToString());

        writeCSV(test.dataToString());
        //welcomeUserName();
        //setGameSettings(sc);

        //sc.close();
    }


    public static void welcomeUserName() {
        System.out.println("Welcome to Dungeons And Java!");
    }

    public static void setGameSettings(Scanner sc) throws FileNotFoundException {
        //registerUserName(sc);
        //registerUserTeamName(sc);
        /*
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
            }*/
            teamUp(sc);/*
        }

        var readFile = readFromFile("src/repository/database/IAdB/difficulty-" + difficulty + ".csv");

        for (String file : readFile) {
            System.out.println(file);
        }*/

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

    public static void teamUp(Scanner sc){

        int teamMembers;
        String typeOfParty;

        Utils.typewriterFromString(Messages.partyMembers(ConsoleColors.GREEN_BOLD));
        teamMembers = sc.nextInt();
        //clean sc int buffer
        sc.nextLine();

        Utils.typewriterFromString(Messages.partyType(ConsoleColors.GREEN_BOLD));
        typeOfParty = sc.nextLine();

        switch ( typeOfParty ) {
            case "1":
                Character character;
                 character = createNewCharacter(sc);
                //System.out.println(character.toString());
                break;
            case "2":
                System.out.println("2");

                break;
            case "3":
                System.out.println("3");

                break;
            default:
                System.out.println("Selection unrecognised. Remember mortal, select from 1 to 3!");
        }

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
        return newCharacter;
    }

    public static void writeCSV(String line) {
        try{
            FileWriter fw=new FileWriter("src/repository/database/userDb/user.csv");
            fw.write(line);
            fw.close();
        }catch(Exception e){System.out.println(e);}
        System.out.println("Success...");
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
