package com.company;


public class Main {

    public static void main(String[] args) {
        int numpoints = 32768;
        int numtrials = 1;
        int dimension = 4;

        float sumOfWeights = 0.0f;

        for (int j = 0; j < numtrials; j++) {

            Graph graph = new Graph(numpoints, dimension);

            Prim.runPrim(graph); // Runs Prim's algorithm on given graph

            float weightOfMST = 0.0f; // Weight of the MST, sum of each vertex's distance
            for (int i = 0; i < graph.getNumberOfVertexes(); i++) {
                weightOfMST = weightOfMST + graph.getVertex(i).getDistance();
                System.out.println(graph.getVertex(i).toString() + " Vertex Weight :" +
                        graph.getAdjacencyMatrix().getEdge(i, graph.getVertex(i).getPrevPointer()));
            }

            System.out.println("MST weight: " + weightOfMST);
            sumOfWeights = sumOfWeights + weightOfMST;
        }

        System.out.println(
                sumOfWeights / numtrials + " " + numpoints + " " + numtrials + " " + dimension);
    }
}
