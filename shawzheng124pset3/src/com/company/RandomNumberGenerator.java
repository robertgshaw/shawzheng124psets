package com.company;
import java.util.Random;
/**
 * Created by robertshaw on 2/16/16.
 */
public class RandomNumberGenerator {

    public float generateRandom() {
        Random random = new Random();
        float randomFloat = random.nextFloat();

        return randomFloat;
    }
}
