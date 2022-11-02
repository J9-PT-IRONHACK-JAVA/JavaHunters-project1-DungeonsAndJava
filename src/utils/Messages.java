package utils;

public class Messages {

    public static String showWelcomeMessage;
    public static String askUserNameMsg = ConsoleColors.PURPLE + """
            So... you're a fighter right?
            Then, you want to conquest this arena! That's brave...
            Let's start by writing your name.
            Who are you?
            """ + ConsoleColors.RESET;

    public static String askTeamNameMsg(String userName, String color) {
        return color + """
                . . . . %s??? Is that even a name? You will be nothing in this arena...
                Or maybe you will be all!
                In any case, let's know the name of your team now.
                """.formatted(userName) + ConsoleColors.RESET;
    }

    public static String endUserRegistrationMsg(String userName, String teamName, String color) {
        return color + """
                Well well well %s from %s's team.
                I hope you're confident with those!
                Let's jump to the next part!
                """.formatted(userName, teamName) + ConsoleColors.RESET;
    }

}


