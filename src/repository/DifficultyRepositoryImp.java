package repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DifficultyRepositoryImp implements DifficultyRepository {

    public ArrayList<String> getIaPartyByDifficulty(int difficulty) throws FileNotFoundException {
        return readFromFile("src/repository/database/IAdB/difficulty-" + difficulty + ".csv");
    }

    private ArrayList<String> readFromFile(String path) throws FileNotFoundException {
        File targetFile = new File(path);
        Scanner reader = new Scanner(targetFile);
        var readFile = new ArrayList<String>();

        do {
            readFile.add(reader.nextLine());
        } while (reader.hasNextLine());

        reader.close();
        return readFile;
    }
}
