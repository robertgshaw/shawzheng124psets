package com.company;
import java.util.Random;
/**
 * Created by robertshaw on 2/16/16.
 */
public class RandomNumberGenerator {
    public double generateRandom() {
        Random random = new Random();
        double randomDouble = random.nextDouble();

        return randomDouble;
    }

    private static void log(String aMessage){
        System.out.println(aMessage);
    }
}
