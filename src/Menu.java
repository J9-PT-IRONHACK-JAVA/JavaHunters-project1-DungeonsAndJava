import models.Character;
import models.Party;
import services.CombatService;
import services.IAPartyService;
import services.UserPartyService;
import utils.ConsoleColors;
import utils.Messages;
import utils.Utils;
import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Menu {
    static String userName;
    static String teamName;
    static int difficulty;
    private static final IAPartyService IAPartyService = new IAPartyService();
    private static final UserPartyService userPartyService = new UserPartyService();
    private static final CombatService combatService = new CombatService();
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
        customCharacterCreation(sc);
        var userParty = registerUserParty(sc);
        var iaParty = registerIAParty(sc);
        startFight(userParty, iaParty);
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

    private static void customCharacterCreation(Scanner sc) {
        Utils.typewriterFromString(Messages.askCharacterCreation(ConsoleColors.YELLOW_BOLD));
        var hasCharacterSelection = sc.nextLine();

        if(hasCharacterSelection.equals("0")) {
            Character character;
            String CharacterToString;

            character = userPartyService.createNewCharacter(sc);
            CharacterToString = character.dataToString();
            userPartyService.saveCharacterToDb(CharacterToString);

            Utils.typewriterFromString(Messages.askNewCharacterCreation(ConsoleColors.YELLOW_BOLD));
            var createNewCharacter = sc.nextLine();
            if(createNewCharacter.equals("0")) {
                customCharacterCreation(sc);
            }
        }
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
            /*case "1":
                Character character;
                String CharacterToString;

                character = UserPartyService.createNewCharacter(sc);
                CharacterToString = character.dataToString();
                userPartyService.saveCharacterToDb(CharacterToString);
                break;*/
            case "1":
                UserPartyService.showUserAvailableCharacters(charactersArray);
                userParty = UserPartyService.saveCharactersToParty(charactersArray,members,sc);
                System.out.println(userParty.toString());
                break;
            case "2":
                /*
                boolean sameRange, correctRange;
                sameRange = UserPartyService.partySameRandomRange(members ,charactersArray);
                correctRange = UserPartyService.partySameRandomRange(members ,charactersArray);
                */

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
        var difficultySelection = sc.nextInt();

        if(IAPartyService.getDifficulty(sc) == difficultySelection) {
            Utils.typewriterFromString(Messages.retryRegisterGameDifficulty(ConsoleColors.RED));
            registerIAParty(sc);
        }

        var charactersArray = IAPartyService.getIaPartyByDifficulty(difficulty);
        var userPartySize = localUserParty.getCharacters().size();
        Party iaParty = UserPartyService.saveRandomParty(true, true, userPartySize, charactersArray);

        return iaParty;
    }

    static void startFight(Party userParty, Party iaParty) {
        var combat = new ArrayList<Character>();
        do {
            combat = combatService.makeCombatBetweenRandomCharacters(userParty, iaParty);
        } while (userParty.getAliveCharacters().size() > 0 && iaParty.getAliveCharacters().size() > 0);

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<< Graveyard:");
        System.out.println(combat);
    }
}
