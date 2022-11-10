package services;

import models.Character;
import models.Party;
import repository.IAPartyRepositoryImp;
import utils.ConsoleColors;
import utils.Messages;
import utils.Utils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IAPartyService {
    private final IAPartyRepositoryImp difficultyRepository;

    public IAPartyService() {
        difficultyRepository = new IAPartyRepositoryImp();
    }

    public static int getDifficulty(Scanner sc, int difficultySelection) {
        boolean toExit = true;
        int difficulty = -1;
        while (toExit) {

            switch (difficultySelection) {
                case 0:
                    var message = "You selected: A Walk In The Park";
                    Utils.typewriterFromString(Messages.printSelectedDifficulty(message, ConsoleColors.BLUE_BOLD_BRIGHT), 5);
                    toExit = false;
                    difficulty = 0;
                    break;
                case 1:
                    var message = "You selected: Middle Of The Road";
                    Utils.typewriterFromString(Messages.printSelectedDifficulty(message, ConsoleColors.BLUE_BOLD_BRIGHT), 5);
                    toExit = false;
                    difficulty = 1;
                    break;
                case 2:
                    var message = "You selected: Nightmare!";
                    Utils.typewriterFromString(Messages.printSelectedDifficulty(message, ConsoleColors.BLUE_BOLD_BRIGHT), 5);
                    toExit = false;
                    difficulty = 2;
                    break;
                default:
                    difficulty = 3;
                    toExit = false;
                    break;
            }
        }

        return difficulty;
    }

    public List<Character> getIaPartyByDifficulty(int difficulty) throws FileNotFoundException {
        return difficultyRepository.getIaPartyByDifficulty(difficulty);
    }
}
