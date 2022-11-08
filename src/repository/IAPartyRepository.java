package repository;

import models.Character;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public interface IAPartyRepository {
    List<Character> getIaPartyByDifficulty(int difficulty) throws FileNotFoundException;
}
