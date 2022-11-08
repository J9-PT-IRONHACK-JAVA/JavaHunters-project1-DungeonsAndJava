package utils;

public class Messages {
    public static String askUserNameMsg = ConsoleColors.PURPLE + """
            So... you're a fighter right?
            Then, you want to conquest this arena! That's brave...
            Let's start by writing your name.
            Who are you?
            """ + ConsoleColors.RESET;

    public static String askTeamNameMsg(String userName, String color) {
        return color + """
                %s??? Is that even a name? You will be nothing in this arena...
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

    public static String partyMembers(String color) {
        return color + """
                we come to the crucial moment of choosing who will come with you to the battle...
                choose the number of members your group will have.
                """ + ConsoleColors.RESET;
    }
    
    public static String partyType(String color) {
        return color + """
                Do you want to summon new fighters...fight with acquaintances, or are you served by a bunch of unknown
                and hardened mercenaries from the most dangerous regions of the continent?.
                 [ 1--> Create new member ] 
                 [ 2--> Load members ]
                 [ 3--> Random members ]
                """ + ConsoleColors.RESET;
    }
    
    public static String askGameDifficulty(String color) {
         return color + """ 
                 Muahahahaha are you really a true adventurer or just a runway newbie. 
                 What is your path? 
                 [ 0--> A Walk In The Park ] 
                 [ 1--> Middle Of The Road ]
                 [ 2--> Nightmare! are you serious? ]
                 """ + ConsoleColors.RESET;
    }

    public static String retryRegisterGameDifficulty(String color) {
        return color + """ 
                HAHAHA what are you trying?... 
                Please don't be smart and select a correct difficulty
                """ + ConsoleColors.RESET;
    }
}
