package utils;

import java.util.Random;

public class Utils {

    public static int getRandomNum(int minValue, int maxValue) {
        int randomNum;
        Random random = new Random();

        randomNum = random.nextInt(maxValue - minValue) + minValue;

        return randomNum;
    }

    public static void typewriterFromString(String stringToApplyEffect) {
        int typewriterDelay = 50;
        for (int i = 0; i < stringToApplyEffect.length(); i++) {
            System.out.print(stringToApplyEffect.charAt(i));
            try {
                Thread.sleep(typewriterDelay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
