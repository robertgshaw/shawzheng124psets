package com.company;


public class Main {

    public static void main(String[] args) {
        // 16; 32; 64; 128; 256; 512; 1024; 2048; 4096; 8192; 16384, 32768, 65536,
        int numpoints = 0;
        int numtrials = 10;
        int dimension = 4;

        for (int k = 4; k < 15; k++) {
            numpoints = Main.power(2, k);
            float sumOfWeights = 0.0f;

            for (int j = 0; j < numtrials; j++) {

                Graph graph = new Graph(numpoints, dimension);

                Prim.runPrim(graph); // Runs Prim's algorithm on given graph

                float weightOfMST = 0.0f; // Weight of the MST, sum of each vertex's distance
                for (int i = 0; i < graph.getNumberOfVertexes(); i++) {
                    weightOfMST = weightOfMST + graph.getVertex(i).getDistance();
                    //                System.out.println(graph.getVertex(i).toString() + " Vertex Weight :" +
                    //                        graph.getAdjacencyMatrix().getEdge(i, graph.getVertex(i).getPrevPointer()));
                }

                sumOfWeights = sumOfWeights + weightOfMST;
            }

            System.out.println(
                    sumOfWeights / numtrials + " " + numpoints + " " + numtrials + " " + dimension);
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
