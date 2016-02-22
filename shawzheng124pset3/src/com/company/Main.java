package com.company;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // 16; 32; 64; 128; 256; 512; 1024; 2048; 4096; 8192; 16384, 32768, 65536,
        int numpoints;
        int numtrials = 5;
        int dimension = 0;
        boolean prune;

        for (int k = 4; k < 15; k++) {
            if (k < 9) {
                prune = false;
            }
            else {
                prune = true;
            }

            numpoints = Main.power(2, k);           // number of points to be used in MST
            float sumOfWeights = 0.0f;              // sum of the weights of all of the MST
            float sumOfMaxDeleted = 0.0f;           // used in finding K(n)

            for (int j = 0; j < numtrials; j++) {
                // initializes the graph
                Graph graph = new Graph(numpoints, dimension, prune);

                // Runs Prim's algorithm on given graph
                float maxDeleted= Prim.runPrim(graph);

                // Weight of the MST, sum of each vertex's distance
                float weightOfMST = 0.0f;
                for (int i = 0; i < graph.getNumberOfVertexes(); i++) {
                    weightOfMST = weightOfMST + graph.getVertex(i).getDistance();

                }

                // used in k(n) calculations
                sumOfMaxDeleted = sumOfMaxDeleted + maxDeleted;
                // sums the weights of the MSTs
                sumOfWeights = sumOfWeights + weightOfMST;
            }

            System.out.println(sumOfWeights / numtrials);
        }

    }

    public static int power (int i, int j) {
        if (j > 0) {
            return i * Main.power(i, j-1);
        } else {
            return 1;
        }
    }
}
