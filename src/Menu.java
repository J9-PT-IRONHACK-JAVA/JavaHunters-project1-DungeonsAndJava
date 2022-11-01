import services.DifficultyService;
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
    static String computerName = "AI";
    static String computerTeamName = "House of the Dragons";
    static int difficulty;

    static ArrayList<String> iaParty;
    private static DifficultyService difficultyService = new DifficultyService();



    public static void startGame() throws FileNotFoundException {
        var sc = new Scanner(System.in);

        welcomeUserName();
        setGameSettings(sc);
        createPartyOfCharacters(sc);

        sc.close();
    }


    public static void welcomeUserName() {
        System.out.println("Welcome to Dungeons And Java!");
    }

    public static void setGameSettings(Scanner sc) throws FileNotFoundException {
        registerUserName(sc);
        registerUserTeamName(sc);
        registerGameDifficulty(sc);
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
        System.out.println("Create your team: Add your characters to the team/party");
        // Create 5 random characters
    }

    private static void registerGameDifficulty(Scanner sc) throws FileNotFoundException {
        Utils.typewriterFromString(Messages.askGameDifficulty(ConsoleColors.YELLOW_BOLD));

        difficulty = DifficultyService.getDifficulty(sc);
        if(difficulty == 3) {
            Utils.typewriterFromString(Messages.retryRegisterGameDifficulty(ConsoleColors.RED));
            registerGameDifficulty(sc);
        }

        iaParty = difficultyService.getIaPartyByDifficulty(difficulty);
        for (String lineParty : iaParty) {
            System.out.println(lineParty);
        }
    }
}
