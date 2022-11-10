package repository;

import java.io.File;
import java.io.FileWriter;

public class UserPartyRepositoryImp implements UserPartyRepository {
    @Override
    public void saveCharacterToDb(String line) {
        try{
            FileWriter fw = new FileWriter("src/repository/database/userDb/user.csv",true);
            fw.write(line+"\n");
            fw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public File loadUserCharactersFromDb() {
        String filePath = "src/repository/database/userDb/user.csv" ;
        return new File(filePath);
    }
}
