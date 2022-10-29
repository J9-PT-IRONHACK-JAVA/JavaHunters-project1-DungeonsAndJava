package utils;

import java.util.Random;

public class Utils {

    public static int getRandomNum(int minValue, int maxValue) {
        int randomNum;
        Random random = new Random();

        randomNum = random.nextInt(maxValue - minValue) + minValue;

        return randomNum;
    }
}
