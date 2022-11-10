import models.Character;
import models.Party;
import services.CombatService;
import services.IAPartyService;
import services.UserPartyService;
import utils.ConsoleColors;
import utils.Messages;
import utils.Utils;

import javax.sound.sampled.LineUnavailableException;
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


    public static void startGame() throws IOException, InterruptedException, LineUnavailableException {
        var sc = new Scanner(System.in);

            /*Utils.makeSound("./assets/backgroundMusic.wav");
            Thread.sleep(4000);
            System.out.println(" ");
            System.out.println(" ");
            Utils.typewriterFromString( "  " + ConsoleColors.PURPLE_BOLD_BRIGHT + "Carlos de Miguel 🦸‍, Adrián " +
                                        "Paniagua 🧙‍ & Dani Roman 🧝 " +
                                               "presents...", 50);
            System.out.println(" ");
            System.out.println(" ");
            Utils.typewriterFromString( "  " + "With the collaboration of Ironhack Barcelona 🏫 and...", 50);
            System.out.println(" ");
            System.out.println(" ");
            Utils.typewriterFromString( "  " + "IntelliJ IDEA ⚒️ ..." + ConsoleColors.RESET, 50);
            System.out.println(" ");
            System.out.println(" ");
            Thread.sleep(2500);


        welcomeUserName();
        showProgressBar();*/
        setGameSettings(sc);

        sc.close();
    }

    public static void showProgressBar() throws InterruptedException {
        Utils.progressBar(ConsoleColors.CYAN);
    }

    public static void welcomeUserName() {
        System.out.println(Messages.ShowLogo);
    }

    public static void setGameSettings(Scanner sc) throws FileNotFoundException, InterruptedException {
        registerUserName(sc);
        registerUserTeamName(sc);
        boolean continueGame;

        do {
            customCharacterCreation(sc);
            var userParty = registerUserParty(sc);
            var iaParty = registerIAParty(sc);
            startFight(userParty, iaParty);
            continueGame = repeatGame(sc);

        } while ( continueGame );

        // TODO: final function with the credits
    }

    public static boolean repeatGame(Scanner sc){
        boolean continuee = false;
        int choise = 0;

        while( choise != 1 && choise != 2 ){
            System.out.println("Not bad at all.. whould you like to repeat it \n [1--Of course]\n[2--No, that was enougth...]");
            choise = sc.nextInt();
        }

        if(choise == 1) continuee = true;
        return continuee;
    }

    private static void registerUserName(Scanner sc) {
        Utils.typewriterFromString(Messages.askUserNameMsg, 5);
        userName = sc.nextLine();
    }

    private static void registerUserTeamName(Scanner sc) throws InterruptedException {
        Utils.typewriterFromString(Messages.askTeamNameMsg, 5);
        teamName = sc.nextLine();
        Utils.typewriterFromString(Messages.endUserRegistrationMsg,5);
        Thread.sleep(4000);
    }

    private static void customCharacterCreation(Scanner sc) {
        boolean continueGame = false;
        int hasCharacterSelection = 0;

        do {
            Utils.typewriterFromString(Messages.askCharacterCreation(ConsoleColors.BLUE_BOLD_BRIGHT), 5);
            hasCharacterSelection = sc.nextInt();
            if(hasCharacterSelection == 0 || hasCharacterSelection == 1) {
                continueGame = true;

                if(hasCharacterSelection == 0) {
                    Character character;
                    String CharacterToString;

                    character = userPartyService.createNewCharacter(sc);
                    CharacterToString = character.dataToString();
                    userPartyService.saveCharacterToDb(CharacterToString);

                    boolean continueCreatingCharacters = true;
                    do {
                        Utils.typewriterFromString(Messages.askNewCharacterCreation(ConsoleColors.BLUE_BOLD_BRIGHT), 5);
                        var createNewCharacter = sc.nextInt();

                        if(createNewCharacter == 0) {
                            character = userPartyService.createNewCharacter(sc);
                            CharacterToString = character.dataToString();
                            userPartyService.saveCharacterToDb(CharacterToString);
                        } else if(createNewCharacter == 1)  {
                            continueCreatingCharacters = false;
                        }

                    }while (continueCreatingCharacters);
                }
            }
        } while (!continueGame);
    }

    public static Party registerUserParty(Scanner sc) throws FileNotFoundException {
        int members;
        String typeOfParty;
        members = UserPartyService.selectAmountOfMembers(sc);
        List<Character> charactersArray = userPartyService.loadUserCharactersFromDb();

        if(members > charactersArray.size()) {
            Utils.typewriterFromString(Messages.noAvailableCharacters(charactersArray.size(), ConsoleColors.RED_BOLD_BRIGHT), 5);
            registerUserParty(sc);
        }

        // si el amountOfMembers es > al numero de miembros que hay en la base de datos del usuario
        // que ponga un numero mas bajo del que hay sino que hubiese creado mas

        sc.nextLine();
        Utils.typewriterFromString(Messages.partyType(ConsoleColors.BLUE_BOLD_BRIGHT), 5);
        typeOfParty = sc.nextLine();

        Party userParty = new Party();
        switch (typeOfParty) {
            case "1":
                UserPartyService.showUserAvailableCharacters(charactersArray);
                userParty = UserPartyService.saveCharactersToParty(charactersArray,members,sc);
                break;
            case "2":
                userParty = UserPartyService.saveRandomParty(true, true, members, charactersArray);
                break;
            default:
                Utils.typewriterFromString(Messages.unrecognisedSelection(ConsoleColors.RED_BOLD_BRIGHT), 5);
                registerUserParty(sc);
        }

        localUserParty = userParty;
        return userParty;
    }

    private static Party registerIAParty(Scanner sc) throws FileNotFoundException {
        Utils.typewriterFromString(Messages.askGameDifficulty(ConsoleColors.BLUE_BOLD_BRIGHT), 5);
        var difficultySelection = sc.nextInt();

        if(IAPartyService.getDifficulty(sc) == difficultySelection) {
            Utils.typewriterFromString(Messages.retryRegisterGameDifficulty(ConsoleColors.RED_BOLD_BRIGHT), 5);
            registerIAParty(sc);
        }

        var charactersArray = IAPartyService.getIaPartyByDifficulty(difficulty);
        var userPartySize = localUserParty.getCharacters().size();
        Party iaParty = UserPartyService.saveRandomParty(true, true, userPartySize, charactersArray);

        return iaParty;
    }

    static void startFight(Party userParty, Party iaParty) throws InterruptedException {

        Utils.typewriterFromString(Messages.startTheBattleMsg, 5);
        Thread.sleep(5000);
        Utils.typewriterFromString(Messages.battleStarts, 5);


        Utils.progressBar(ConsoleColors.PURPLE_BOLD_BRIGHT);

        var combat = new ArrayList<Character>();
        do {
            combat = combatService.makeCombatBetweenRandomCharacters(userParty, iaParty);
        } while (userParty.getAliveCharacters().size() > 0 && iaParty.getAliveCharacters().size() > 0);

        System.out.println(" ℹ️ All dead characters of this fight are bellow ⬇️");
        UserPartyService.showUserAvailableCharacters(combat);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
