package repository;

import java.io.File;

public interface UserPartyRepository {
    void saveCharacterToDb(String line);
    File loadUserCharactersFromDb();
}
