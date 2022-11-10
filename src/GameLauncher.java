import models.Character;
import models.Party;
import models.Warrior;
import models.Wizard;
import utils.Utils;

import javax.sound.sampled.LineUnavailableException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class GameLauncher {

    public static void main(String[] args) throws IOException, InterruptedException, LineUnavailableException {
        // Start the program with Menu.startGame();
        Menu.startGame();


//        ArrayList<Character> userPartyCharacters = new ArrayList<>();
//        userPartyCharacters.add(new Warrior("User Character One"));
//        userPartyCharacters.add(new Wizard("User Character Two"));
//
//        ArrayList<Character> IAPartyCharacters = new ArrayList<>();
//        IAPartyCharacters.add(new Wizard("IA Character One"));
//        IAPartyCharacters.add(new Warrior("IA Character Two"));
//
//        var userParty = new Party(userPartyCharacters);
//        var IAParty = new Party(IAPartyCharacters);


//        Utils.makeSound("./assets/phraseOne.wav");
//        Thread.sleep(10000);
//        Utils.makeSound("./assets/backgroundMusic.wav");
//        Thread.sleep(16000);

//        Menu.startFight(userParty, IAParty);

        // * Tests with classes START >>>>>>>>>>>>>
        System.out.println(">>> Tests with classes START >>>>>>>");
        // ! Add your tests here, remember to delete this part when doing a PR
        System.out.println(">>> Tests with classes END >>>>>>>");
        // * Tests with classes END >>>>>>>>>>>>>
    }


}
