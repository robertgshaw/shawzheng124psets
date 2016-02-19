package com.company;


public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(5, 0);

        Prim.runPrim(graph); // Runs Prim's algorithm on given graph

        for (int i = 0; i< graph.getNumberOfVertexes(); i++) {
            System.out.println( graph.getVertex(i).toString() + " Edge Weight :" +
                                graph.getAdjacencyMatrix().getEdge(i,graph.getVertex(i).getPrevPointer()));
        }

    }
}
