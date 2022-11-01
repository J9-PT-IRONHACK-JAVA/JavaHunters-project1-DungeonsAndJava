package repository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface DifficultyRepository {
    ArrayList<String> getIaPartyByDifficulty(int difficulty) throws FileNotFoundException;
}
