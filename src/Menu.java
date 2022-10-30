import utils.ConsoleColors;
import utils.Messages;
import utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    static String userName;
    static String teamName;
    static String computerName = "IA";
    static String computerTeamName = "House of the Dragons";
    static int difficulty;


    public static void startGame() throws FileNotFoundException {
        var sc = new Scanner(System.in);

        welcomeUserName();
        setGameSettings(sc);
        createPartyOfCharacters(sc);

        sc.close();
    }


    public static void welcomeUserName() {
        System.out.println("Welcome to the game user!!");
    }

    public static void setGameSettings(Scanner sc) throws FileNotFoundException {
        registerUserName(sc);
        registerUserTeamName(sc);

        // * difficulty registration
        System.out.println("Select difficulty (Select range between 0-2)\n0: EASY\n1: MIDDLE\n2: HARD");

        boolean toExit = true;
        while (toExit) {
            String input = sc.nextLine();

            switch (input) {
                case "0":
                    System.out.println("You select EASY Mode");
                    difficulty = 0;
                    toExit = false;
                    break;
                case "1":
                    System.out.println("You select MIDDLE Mode");
                    difficulty = 1;
                    toExit = false;
                    break;
                case "2":
                    System.out.println("You select HARD Mode");
                    difficulty = 2;
                    toExit = false;
                    break;
                default:
                    System.out.println("Select Correct choice");
            }
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

    public static void createPartyOfCharacters(Scanner sc) {
        System.out.println("Create team: Add characters to the team/party");
        // Create 5 random characters
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
