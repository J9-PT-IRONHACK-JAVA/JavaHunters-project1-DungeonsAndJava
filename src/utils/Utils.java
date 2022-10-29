package utils;

import java.util.Random;

public class Utils {

    public static int getRandomNum(int minValue, int maxValue) {
        int randomNum;
        Random random = new Random();

        randomNum = random.nextInt(maxValue - minValue) + minValue;

        return randomNum;
    }

    public static void printLettersOneByOne() {
        CharSequence input = null;
        for (int i = 0; i < input.length(); i++){
                System.out.println(input.charAt(i));
            }
            try{
                Thread.sleep(500);//0.5s pause between characters
            } catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }

    }
}
