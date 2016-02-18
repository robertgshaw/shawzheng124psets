package com.company;

/**
 * Created by robertshaw on 2/16/16.
 */
public class Graph {
    private Vertex[] vertexes;
    // to access this array, larger index first, smaller index second
    private AdjacencyMatrix adjacencyMatrix;
    private int dimension;
    private int numberOfVertexes = 0;

    // create a graph with vertexes in dimension d
    Graph(int n, int dimension, int seed) {
        // init dimension, making sure there is valid input
        if (dimension == 0 || dimension == 2 || dimension == 3 || dimension == 4) {
            this.dimension = dimension;
        } else {
            this.dimension = -1;
        }

        // init size, making sure there is valid inputs
        if (n >= 0) {
            this.numberOfVertexes = n;
        } else {
            // TODO: make this throw an exception
            this.numberOfVertexes = 1;
        }

        // init the vertex array of size n
        this.vertexes = new Vertex[this.numberOfVertexes];

        // setup random number generator
<<<<<<< HEAD
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(seed);
        /*
         *  create n vertexes, n choose 2 edges
         *  add new edges to between i and all vertexes after i
         *  this avoids doing each edge twice
         */
        int edgecount = 0;
        for (int i = 0; i < this.size; i++) {
=======
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // create n vertexex
        for (int i = 0; i < this.numberOfVertexes; i++) {
>>>>>>> 468f57d62db68402a372c9530c584fc1bae5fd90
            // identify each vertex by its index in the vertex array
            // initialize and add to the vertex array
            Vertex vertex = new Vertex(i);
            this.vertexes[i] = vertex;
        }

        // init the adjacency matrix with random edge weights
        this.adjacencyMatrix = new AdjacencyMatrix(this.numberOfVertexes, 0);;

        System.out.println(this.adjacencyMatrix.toString());
    }

    public int getNumberOfVertexes() {
        return this.numberOfVertexes;
    }
}
