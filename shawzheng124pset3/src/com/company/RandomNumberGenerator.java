package com.company;
import java.util.Random;
/**
 * Created by robertshaw on 2/16/16.
 */
public class RandomNumberGenerator {
    private int seed;

    public RandomNumberGenerator(int seed) {
        this.seed = seed;
    }
    public double generateRandom() {
        Random random = new Random(seed);
        double randomDouble = random.nextDouble();

        return randomDouble;
    }
}
