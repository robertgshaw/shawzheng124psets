package com.company;

/**
 * Created by robertshaw on 2/16/16.
 */
public class Graph {
    public Vertex[] vertexes;
    public Edge[] edges;
    private int dimension;
    private int size = 0;

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
            this.size = n;
        } else {
            // TODO: make this throw an exception
            this.size = 1;
        }

        // init the vertex array of size n
        this.vertexes = new Vertex[this.size];

        // init the edge array of size n choose 2
        this.edges = new Edge[choose2(this.size)];
        System.out.println(this.vertexes.length);
        System.out.println(this.edges.length);

        // setup random number generator
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(seed);
        /*
         *  create n vertexes, n choose 2 edges
         *  add new edges to between i and all vertexes after i
         *  this avoids doing each edge twice
         */
        int edgecount = 0;
        for (int i = 0; i < this.size; i++) {
            // identify each vertex by its index in the vertex array
            // initialize and add to the vertex array
            Vertex vertex = new Vertex(i);
            this.vertexes[i] = vertex;

            // create edges
            for(int j =  i + 1; j < this.size; j++) {
                int[] vertexIndexes = {i,j};
                Edge edge = new Edge(vertexIndexes, randomNumberGenerator.generateRandom(), edgecount);
                this.edges[edgecount] = edge;
                edgecount = edgecount + 1;
            }
        }

    }

    public int getSize() {
        return size;
    }

    // helper function for choose 2
    private int choose2 (int n) {
        return n * (n - 1) / 2;
    }
}
