import models.Warrior;
import models.Wizard;

public class GameLauncher {
    public static void main(String[] args) {

        // Start the program with Menu.
        Menu.userRegistration();
        Menu.createTeam();


        // * Tests with classes START >>>>>>>>>>>>>
        System.out.println(">>> Tests with classes START >>>>>>>");
        Warrior mod = new Warrior("Demi");
        Wizard mod2 = new Wizard("Darren");

        System.out.println(mod);
        mod.attack();

        System.out.println(mod2);
        mod2.attack();
        System.out.println(">>> Tests with classes END >>>>>>>");
        // * Tests with classes END >>>>>>>>>>>>>
    }
}
