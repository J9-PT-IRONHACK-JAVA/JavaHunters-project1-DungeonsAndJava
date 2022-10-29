import java.util.Scanner;

public class Menu {

    static String userName;
    static String teamName;
    static String computerName = "IA";
    static String computerTeamName = "House of the Dragons";

    public static void startGame() {
        var sc = new Scanner(System.in);

        welcomeUserName();
        setGameSettings(sc);
        createPartyOfCharacters(sc);

        sc.close();
    }


    public static void welcomeUserName() {
        System.out.println("Welcome to the game user!!");
    }

    public static void setGameSettings(Scanner sc) {
        // * user registration
        System.out.println("What's your name?");
        userName = sc.nextLine();

        System.out.println("Your user name is: " + userName);

        // * team registration
        System.out.println("What's the name of your team?");
        teamName = sc.nextLine();

        System.out.println("Your team name is: " + teamName);

        // * difficulty registration
        // TODO: MENU UI => Which difficulty vs IA

    }

    public static void createPartyOfCharacters(Scanner sc) {
        System.out.println("Create team: Add characters to the team/party");
        // Create 5 random characters
    }


}
