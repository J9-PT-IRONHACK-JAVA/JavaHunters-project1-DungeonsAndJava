package utils;

import java.util.Random;

public class Utils {
    private static final StringBuilder stringBuilder = new StringBuilder();

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

    public static void progressBar(String color) {
        try {
            for (int i = 0 ; i <= 500 ; i++) {
            Thread.sleep(10);
            System.out.print(String.format("[%s] ===> %d%%\r", (color + (updateProgress(i) + " ") + ConsoleColors.RESET), i/5));
            }
        }
        catch (InterruptedException e) {}
    }

    private static String updateProgress(int pct) {
        stringBuilder.delete(0, stringBuilder.length());
        int numPounds = (pct + 9) / 10;
        for (int i = 0 ; i != numPounds ; i++) {
            stringBuilder.append('#');
        }
        while (stringBuilder.length() != 50) {
            stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }
}
