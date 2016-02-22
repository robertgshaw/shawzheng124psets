package com.company;

/**
 * Created by robertshaw on 2/16/16.
 */
public class Prim {

    public static float runPrim(Graph graph) {
        int numVertexes = graph.getNumberOfVertexes();
        //Vertex[] visitedVertexes = new Vertex[numVertexes]; // An array of all visited vertexes
        PriorityQueue heap = new PriorityQueue(numVertexes);
        Vertex min; // Popped min vertex
        int counter = 0; // Tracks how many vertices have been visited
        int minIndex; // Tracks index of current popped min vertex in while loop
        Vertex neighbor; // Neighbor vertex in for loop of while loop
        //AdjacencyMatrix adjacencyMatrix = graph.getAdjacencyMatrix();
        AdjacencyList adjacencyList = graph.getAdjacencyList();
        float maxDeleted = 0; // used in finding k(n)

        // Sets the arbitrary starting node's distance to be 0
        graph.setVertexWeight(0, 0);
        graph.getVertex(0).setPrevPointer(0); // Sets parent pointer of first vertex to itself

        heap.insertVertex(graph.getVertex(0));

        while (heap.notEmpty()) {
            // get the smallest element in the heap
            min = heap.deleteMin();

            // used in k(n) calculations
            if (min.getDistance() > maxDeleted) {
                maxDeleted = min.getDistance();
            }

            // updates the heap
            //visitedVertexes[counter] = min;
            min.visit();
            counter++;
            minIndex = min.getIndexInGraph();

            // iterates through the vertexes
            for (int i = 0; i < numVertexes; i++) {
                neighbor = graph.getVertex(i);


                if (minIndex == i || graph.getVertex(i).isVisited()) {
                    // Skip vertex
                }
                else {
                    // checks if the edge has been pruned
                    if (adjacencyList.edgeExists(minIndex, i)) {
                        // check if the new distance to the vertex is faster
                        if (neighbor.getDistance() > adjacencyList.getEdge(i, minIndex)) {
                            // update distance and prev pointer
                            neighbor.setDistance(adjacencyList.getEdge(i, minIndex));
                            neighbor.setPrevPointer(minIndex);
                            // insert or update in the heap
                            if (neighbor.isInHeap()) {
                                heap.updateVertex(neighbor.getIndexinHeap());
                            }
                            else {
                                heap.insertVertex(neighbor);
                            }
                        }
                    }
                }
            }

        }
        return maxDeleted;
//        System.out.println("Prim done!");
    }

}
