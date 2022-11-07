package services;

import models.Character;
import models.Party;
import repository.IAPartyRepositoryImp;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IAPartyService {
    private final IAPartyRepositoryImp difficultyRepository;

    public IAPartyService() {
        difficultyRepository = new IAPartyRepositoryImp();
    }

    public static int getDifficulty(Scanner sc) {
        boolean toExit = true;
        int difficulty = 3;
        while (toExit) {
            String input = sc.nextLine();

            switch (input) {
                case "0":
                    System.out.println("You selected: A Walk In The Park");
                    toExit = false;
                    difficulty = 0;
                    break;
                case "1":
                    System.out.println("You selected: Middle Of The Road");
                    toExit = false;
                    difficulty = 1;
                    break;
                case "2":
                    System.out.println("You selected: Nightmare!");
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
