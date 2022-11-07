import models.Character;
import models.Party;
import services.IAPartyService;
import services.UserPartyService;
import utils.ConsoleColors;
import utils.Messages;
import utils.Utils;

import java.io.*;
import java.util.*;

public class Menu {
    static String userName;
    static String teamName;
    static String computerName = "AI";
    static String computerTeamName = "House of the Dragons";
    static int difficulty;
    private static final IAPartyService IAPartyService = new IAPartyService();
    private static final UserPartyService userPartyService = new UserPartyService();
    private static Party localUserParty;

    public static void startGame() throws FileNotFoundException, InterruptedException {
        var sc = new Scanner(System.in);

        welcomeUserName();
        showProgressBar();
        setGameSettings(sc);

        sc.close();
    }

    public static void showProgressBar() throws InterruptedException {
        Utils.progressBar(ConsoleColors.CYAN);
    }

    public static void welcomeUserName() {
        System.out.println("Welcome to Dungeons And Java!");
    }

    public static void setGameSettings(Scanner sc) throws FileNotFoundException {
        registerUserName(sc);
        registerUserTeamName(sc);
        var userParty = registerUserParty(sc);

        System.out.println("USER PARTY");
        System.out.println(userParty.toString());

        var iaParty = registerIAParty(sc);

        System.out.println("IA PARTY");
        System.out.println(iaParty.toString());
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

    public static Party registerUserParty(Scanner sc) throws FileNotFoundException {
        int members;
        String typeOfParty;
        members = UserPartyService.selectAmountOfMembers(sc);
        List<Character> charactersArray = userPartyService.loadUserCharactersFromDb();
        sc.nextLine();

        Utils.typewriterFromString(Messages.partyType(ConsoleColors.GREEN_BOLD));
        typeOfParty = sc.nextLine();

        Party userParty = new Party();

        switch ( typeOfParty ) {
            case "1":
                Character character;
                String CharacterToString;

                character = UserPartyService.createNewCharacter(sc);
                CharacterToString = character.dataToString();
                userPartyService.saveCharacterToDb(CharacterToString);
                break;
            case "2":
                UserPartyService.showUserAvailableCharacters(charactersArray);
                userParty = UserPartyService.saveCharactersToParty(charactersArray,members,sc);
                System.out.println(userParty.toString());
                break;
            case "3":
                /* boolean sameRange, correctRange;
                sameRange = UserPartyService.partySameRandomRange(members ,charactersArray);
                correctRange = UserPartyService.partySameRandomRange(members ,charactersArray);*/

                userParty = UserPartyService.saveRandomParty(true, true, members, charactersArray);
                break;
            default:
                System.out.println("Selection unrecognised. Remember mortal, select from 1 to 3!");
        }

        localUserParty = userParty;
        return userParty;
    }

    private static Party registerIAParty(Scanner sc) throws FileNotFoundException {
        Utils.typewriterFromString(Messages.askGameDifficulty(ConsoleColors.YELLOW_BOLD));

        if(IAPartyService.getDifficulty(sc) == 3) {
            Utils.typewriterFromString(Messages.retryRegisterGameDifficulty(ConsoleColors.RED));
            registerIAParty(sc);
        }

        var charactersArray = IAPartyService.getIaPartyByDifficulty(difficulty);
        var userPartySize = localUserParty.getCharacters().size();
        Party iaParty = UserPartyService.saveRandomParty(true, true, userPartySize, charactersArray);

        return iaParty;
    }
}
