package com.company;

/**
 * Created by robertshaw on 2/16/16.
 */
public class Prim {

    public static void runPrim(Graph graph) {
        int numVertexes = graph.getNumberOfVertexes();
        Vertex[] visitedVertexes = new Vertex[numVertexes]; // An array of all visited vertexes
        PriorityQueue heap = new PriorityQueue(numVertexes);
        Vertex min; // Popped min vertex
        int counter = 0; // Tracks how many vertices have been visited
        int minIndex; // Tracks index of current popped min vertex in while loop
        Vertex neighbor; // Neighbor vertex in for loop of while loop
        AdjacencyMatrix adjacencyMatrix = graph.getAdjacencyMatrix();

        // Sets the arbitrary starting node's distance to be 0
        graph.setVertexWeight(0, 0);
        graph.getVertex(0).setPrevPointer(0); // Sets parent pointer of first vertex to itself

        heap.insertVertex(graph.getVertex(0));

        while (heap.notEmpty()) {
            min = heap.deleteMin();
            visitedVertexes[counter] = min;
            min.visit();
            counter++;
            minIndex = min.getIndexInGraph();

            for (int i = 0; i < numVertexes; i++) {
                neighbor = graph.getVertex(i);

                if (minIndex == i || graph.getVertex(i).isVisited()) {
                    // Skip vertex
                }
                else {
                    if (neighbor.getDistance() > adjacencyMatrix.getEdge(i, minIndex)) {
                        neighbor.setDistance(adjacencyMatrix.getEdge(i, minIndex));
                        neighbor.setPrevPointer(minIndex);
                        heap.insertVertex(neighbor);
                    }
                }
            }

            System.out.println("Prim done!");
        }

    }

}
