package com.company;
import java.util.Random;
/**
 * Created by robertshaw on 2/16/16.
 */
public class RandomNumberGenerator {
    private long seed;

    //public RandomNumberGenerator(long seed) {
      //  this.seed = seed;
    //}
    public double generateRandom() {
        Random random = new Random();
        double randomDouble = random.nextDouble();

        return randomDouble;
    }
}
