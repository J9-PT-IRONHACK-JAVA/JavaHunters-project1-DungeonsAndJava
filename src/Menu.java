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
        // * user registration
        System.out.println("Greetings mortal.\nWhat, pray tell, is your name?");
        userName = sc.nextLine();

        System.out.println("Thus, your user name shall hereby be known as: " + userName);

        // * team registration
        System.out.println("Next, by what name will your valiant team go by?");
        teamName = sc.nextLine();

        System.out.println("As you wish.\nThen henceforth your band of wizards and warriors shall be known as: " + teamName);

        // * difficulty registration
        System.out.println("Choose wisely your desired difficulty level from 0 to 2\n0: A Walk In The Park\n1: Middle" +
                " Of The Road\n2: Nightmare!");

        boolean toExit = true;
        while (toExit) {
            String input = sc.nextLine();

            switch(input) {
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
        }

        var readFile = readFromFile("src/repository/database/IAdB/difficulty-"  + difficulty + ".csv");

        for (String file : readFile) {
            System.out.println(file);
        }

    }

    public static void createPartyOfCharacters(Scanner sc) {
        System.out.println("Create your team: Add your characters to the team/party");
        // Create 5 random characters
    }


    private static ArrayList<String> readFromFile(String path) throws FileNotFoundException {
        File targetFile = new File(path);
        Scanner reader = new Scanner(targetFile);
        var readFile = new ArrayList<String>();

        do {
            readFile.add(reader.nextLine());
        }while(reader.hasNextLine());

        reader.close();
        return readFile;
    }

}
