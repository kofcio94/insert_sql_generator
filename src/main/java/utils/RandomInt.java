package utils;

import java.util.Random;

public class RandomInt {

    private static Random random = new Random();

    public static int generateRandomInt(int min, int max) {
        if(min > max)
            return -1;
        return random.nextInt((max - min) + 1) + min;
    }

    public static int generateRandomInt(int max) {
        return generateRandomInt(0, max);
    }

}
