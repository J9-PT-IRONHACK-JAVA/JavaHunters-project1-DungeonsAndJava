import models.Character;
import models.Party;
import models.Warrior;
import models.Wizard;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameLauncher {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        // Start the program with Menu.startGame();
        Menu.startGame();

        /*
        ArrayList<Character> userPartyCharacters = new ArrayList<>();
        userPartyCharacters.add(new Warrior("User Character One"));
        userPartyCharacters.add(new Wizard("User Character Two"));

        ArrayList<Character> IAPartyCharacters = new ArrayList<>();
        IAPartyCharacters.add(new Wizard("IA Character One"));
        IAPartyCharacters.add(new Warrior("IA Character Two"));

        var userParty = new Party(userPartyCharacters);
        var IAParty = new Party(IAPartyCharacters);
        Menu.startFight(userParty, IAParty);*/

        // * Tests with classes START >>>>>>>>>>>>>
        System.out.println(">>> Tests with classes START >>>>>>>");
        // ! Add your tests here, remember to delete this part when doing a PR
        System.out.println(">>> Tests with classes END >>>>>>>");
        // * Tests with classes END >>>>>>>>>>>>>
    }
}
