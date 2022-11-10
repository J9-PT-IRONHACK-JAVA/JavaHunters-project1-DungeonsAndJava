package utils;

public class Messages {

    public static String ShowLogo = ConsoleColors.RED + """
                                                    (       (                                     \s
               (      )   )      )       )          )\\ )    )\\ )  (       )  (  (                 \s
               )\\  ( /(  /((  ( /(    ( /(   (     (()/(   (()/(  )(   ( /(  )\\))(  (    (     (  \s
              ((_) )(_))(_))\\ )(_))   )(_))  )\\ )   ((_))   ((_))(()\\  )(_))((_))\\  )\\   )\\ )  )\\ \s
             _ | |((_)_ _)((_)(_)_   ((_)_  _(_/(   _| |    _| |  ((_)((_)_  (()(_)((_) _(_/( ((_)\s
            | || |/ _` |\\ V // _` |  / _` || ' \\))/ _` |  / _` | | '_|/ _` |/ _` |/ _ \\| ' \\))(_-<\s
             \\__/ \\__,_| \\_/ \\__,_|  \\__,_||_||_| \\__,_|  \\__,_| |_|  \\__,_|\\__, |\\___/|_||_| /__/\s
                                                                            |___/                 \s
            """ + ConsoleColors.RESET;
    public static String askUserNameMsg = ConsoleColors.BLUE_BOLD_BRIGHT + """
                        
                        |-------------------------------------------------------|
                        | So... you're a fighter right?                         |
                        | Then, you want to conquest this arena! That's brave...|
                        | Let's start by writing your name.                     |
                        | Who are you?                                          |
                        |-------------------------------------------------------|
                        
            """ + ConsoleColors.RESET;

    public static String askTeamNameMsg = ConsoleColors.BLUE_BOLD_BRIGHT + """
                        
                            |------------------------------------------------------------|
                            | Is that even a name? You will be nothing in this arena...  |
                            | Or maybe you will be all! Time will tell.                  |
                            | In any case, let's know the name of your team now.         |
                            |------------------------------------------------------------|
                        
                """ + ConsoleColors.RESET;

    public static String endUserRegistrationMsg = ConsoleColors.BLUE_BOLD_BRIGHT + """
  
                            |-------------------------------------------------------|
                            | Well well well...                                     |
                            | I hope you are convinced of these names and           |
                            | that you are ready for the adventure that awaits you! |
                            |_______________________________________________________|
                        
                """ + ConsoleColors.RESET;


    public static String partyMembers(String color) {
        return color + """
                
                            |--------------------------------------------------------|
                            | Alright, with how many characters do you want to play? |
                            |--------------------------------------------------------|
                
                """ + ConsoleColors.RESET;
    }
    
    public static String partyType(String color) {
        return color + """
                    
                            |----------------------------------------------------------------------------|
                            | Do you want to summon new fighters,                                        |
                            | fight with acquaintances, or are you served by a bunch of unknown          |
                            | and hardened mercenaries from the most dangerous regions of the continent? |
                            |                                                                            |
                            |                   [ 1--> Load members ]                                    |
                            |                   [ 2--> Random members ]                                  |
                            |                                                                            |
                            |----------------------------------------------------------------------------|
                    
                """ + ConsoleColors.RESET;
    }

    public static String unrecognisedSelection(String color) {
        return color + """
                 
                            |----------------------------------------------------------------------------|
                            | Selection unrecognised. Remember mortal, select from 1 to 2!               |
                            |----------------------------------------------------------------------------|
                    
                """ + ConsoleColors.RESET;
    }

    public static String printSelectedDifficulty(String message, String color) {
        return color + """
                 
                            |----------------------------------------------------------------------------|
                              %s                                                                         
                            |----------------------------------------------------------------------------|
                    
                """.formatted(message) + ConsoleColors.RESET;
    }

    public static String noAvailableCharacters(int number, String color) {
        return color + """
                 
                            |----------------------------------------------------------------------------|
                            | Hey BRO!!!,                                                                |
                            | Keep on dreaming!! You don't have sufficient available characters          |
                            | Select less than %s characters                                             |
                            |----------------------------------------------------------------------------|
                    
                """.formatted(number) + ConsoleColors.RESET;
    }

    public static String askCharacterCreation(String color) {
        return color + """
                 
                             |----------------------------------------------------------------------------|
                             | Do you want to summon new fighters...                                      |
                             | fight with acquaintances, or are you served by a bunch of unknown          |
                             | and hardened mercenaries from the most dangerous regions of the continent? |
                             |                                                                            |
                             |               [ 0--> Yes, I want to create a character ]                   |
                             |               [ 1--> NO!! I trust in created characters ]                  |
                             |                                                                            |
                             |----------------------------------------------------------------------------|
                 
                 """ + ConsoleColors.RESET;
    }

    public static String askNewCharacterCreation(String color) {
        return color + """
                 
                         |------------------------------------------|
                         | Do you want to create a more characters? |
                         |                                          |
                         |   [ 0--> Yes, I want ANOTHER!!! Grrrr!!] |
                         |   [ 1--> NO!! I'm tired. It's enough ]   |
                         |                                          |
                         |------------------------------------------|
                 
                 """ + ConsoleColors.RESET;
    }

    public static String caracterType(String color) {
        return color + """

                         |------------------------------------------|
                         | Select your class?                       |
                         |                                          |
                         |   [  1 --> Warrior ]                     |
                         |   [  2 --> Wizard  ]                     |
                         |                                          |
                         |------------------------------------------|
                 
                 """ + ConsoleColors.RESET;
    }

    public static String caracterName(String color) {
        return color + """

                         |------------------------------------------|
                         | What is your character Name?             |
                         |------------------------------------------|
                 
                 """ + ConsoleColors.RESET;
    }

    public static String badSelection(String color) {
        return color + """

                         |------------------------------------------------|
                         | HAHAHA NO!. Select correct character number    |
                         |------------------------------------------------|
                 
                 """ + ConsoleColors.RESET;
    }


    public static String newCharacterCreated(String name, String color) {
        return color + """

                         |------------------------------------------|
                         | New Character has been created...        |
                         | %s                                       |
                         |------------------------------------------|
                 
                 """.formatted(name) + ConsoleColors.RESET;
    }

    public static String askGameDifficulty(String color) {
         return color + """ 
                 
                             |--------------------------------------------------------------------------|
                             | Alright, let's know if you're a true adventurer or just a runway newbie. |
                             | What is your path?                                                       |
                             |                                                                          |
                             |                  [ 0--> A Walk In The Park ]                             |
                             |                  [ 1--> Middle Of The Road ]                             |
                             |                  [ 2--> Nightmare! are you serious? ]                    |
                             |                                                                          |
                             |--------------------------------------------------------------------------|
                 
                 """ + ConsoleColors.RESET;
    }

    public static String retryRegisterGameDifficulty(String color) {
        return color + """ 
                
                        |----------------------------------------------|
                        | Hey! What are you trying?                    |
                        | Are the instructions not clear?              |
                        | Please don't think you are smarter than me   |
                        | and select a correct difficulty              |
                        |----------------------------------------------|
               
                """ + ConsoleColors.RESET;
    }

    public static String startTheBattleMsg = ConsoleColors.BLUE_BOLD_BRIGHT + """
                        
                        |------------------------------------------------------------------------------------|
                        | We have all ready to start...                                                      |
                        | What you are about to see is unique, so keep your eyes peeled.                     |
                        | A single mistake, and both you and your soldiers will be grass in the graveyard... |
                        |------------------------------------------------------------------------------------|
                        
            """ + ConsoleColors.RESET;

    public static String enterCharacterNumber = ConsoleColors.BLUE_BOLD_BRIGHT + """
                        
                        |------------------------------------------------------------------------------------|
                        |           Enter the number of the character that you want to use                   |
                        |------------------------------------------------------------------------------------|
                        
            """ + ConsoleColors.RESET;

    public static String battleStarts = ConsoleColors.PURPLE_BOLD_BRIGHT + """
                        
                        |------------------------------------------------------------------------------------|
                        |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|
                        |                               LET THE BATTLE BEGIN!                                |
                        |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|
                        |------------------------------------------------------------------------------------|
                        
            """ + ConsoleColors.RESET;

    public static String aiWinComabt = ConsoleColors.BLUE_BOLD_BRIGHT + """
                        
                        |------------------------------------------------------------------------------------|
                        |        😈😈 AI has win this combat! You need to do better job mate... 😈😈        |
                        |------------------------------------------------------------------------------------|
                        
            """ + ConsoleColors.RESET;

    public static String userWinCombat = ConsoleColors.BLUE_BOLD_BRIGHT + """
                        
                        |------------------------------------------------------------------------------------|
                        |                      🙄🙄 You win this combat! Good job... 🙄🙄                   |
                        |------------------------------------------------------------------------------------|
                        
            """ + ConsoleColors.RESET;

    public static String userWonGame = ConsoleColors.PURPLE_BOLD_BRIGHT + """
                        
                        |------------------------------------------------------------------------------------|
                        |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|
                        |                          YOU WIN THE GAME! CONGRATULATIONS                         |
                        |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|
                        |------------------------------------------------------------------------------------|
                        
            """ + ConsoleColors.RESET;

    public static String aiWonGame = ConsoleColors.RED_BOLD_BRIGHT + """
                        
                        |------------------------------------------------------------------------------------|
                        |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|
                        |              😈😈 IA WON THIS WAR! YOU'RE SUCH A LOOSER! 😈😈                     |
                        |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|
                        |------------------------------------------------------------------------------------|
                        
            """ + ConsoleColors.RESET;
}
