import models.Character;
import models.Warrior;
import models.Wizard;

public class Main {
    public static void main(String[] args) {
        Warrior mod = new Warrior("Demi");
        Wizard mod2 = new Wizard("Darren");

        System.out.println(mod);
        mod.attack();

        System.out.println(mod2);
        mod2.attack();
    }
}
