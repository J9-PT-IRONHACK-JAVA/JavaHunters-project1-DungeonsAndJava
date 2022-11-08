package repository;

import models.Character;
import models.Warrior;
import models.Wizard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IAPartyRepositoryImp implements IAPartyRepository {

    public List<Character> getIaPartyByDifficulty(int difficulty) throws FileNotFoundException {
        return readFromFile("src/repository/database/IAdB/difficulty-" + difficulty + ".csv");
    }

    private List<Character> readFromFile(String path) throws FileNotFoundException {
        File targetFile = new File(path);
        Scanner reader = new Scanner(targetFile);
        String tempName, tempId;
        int parseHp, parseStamina, parseStrength, parseMana, parseIntelligence;
        List<Character> availableCharacters = new ArrayList<>();
        String[] tempsStats = new String[6];

        do {
            String line = reader.nextLine();
            String noSpaceLine = line.replaceAll("\\s+","");
            String[] formattedLine = noSpaceLine.split(",");

            for (int  i= 0; i < formattedLine.length; i++) {
                tempsStats[i] = formattedLine[i];
            }

            tempId = tempsStats[0];
            tempName = tempsStats[2];
            parseHp = Integer.parseInt(tempsStats[3]);

            if(tempsStats[1].equals("Warrior")){
                parseStamina = Integer.parseInt(tempsStats[4]);
                parseStrength = Integer.parseInt(tempsStats[5]);

                Warrior tempWarrior = new Warrior(tempId, tempName, parseHp, parseStamina, parseStrength);

                availableCharacters.add( tempWarrior );
            }
            else if (tempsStats[1].equals("Wizard")){
                parseMana = Integer.parseInt(tempsStats[4]);
                parseIntelligence = Integer.parseInt(tempsStats[5]);

                Wizard tempWizard = new Wizard(tempId, tempName, parseHp, parseMana, parseIntelligence);

                availableCharacters.add( tempWizard );
            }

        } while (reader.hasNextLine());


        reader.close();

        return availableCharacters;
    }
}
