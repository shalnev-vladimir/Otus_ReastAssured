package util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomDataGenerator {

    private static Random rand;

    static {
        try {
            rand = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static int getRandomNumberFromOneToTen() {
        int min = 1;
        int max = 10;

        return rand.nextInt((max - min) + 1) + min;
    }
}
