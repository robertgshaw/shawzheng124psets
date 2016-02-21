package com.company;

/**
 * Created by robertshaw on 2/16/16.
 */
public class Graph {
    private Vertex[] vertexes;
    private AdjacencyMatrix adjacencyMatrix;
    private int dimension;
    private int numberOfVertexes = 0;

    // create a graph with vertexes in dimension d
    Graph(int n, int dimension) {
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
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // create n vertexes
        for (int i = 0; i < this.numberOfVertexes; i++) {
            // identify each vertex by its index in the vertex array
            // initialize and add to the vertex array
            // locations added in vertex
            Vertex vertex = new Vertex(i, this.dimension);
            this.vertexes[i] = vertex;
        }

        // init the adjacency matrix, with edge weights dependent on dimension
        this.adjacencyMatrix = new AdjacencyMatrix(this.numberOfVertexes, this.dimension, this.vertexes);
    }

    public int getNumberOfVertexes() {
        return this.numberOfVertexes;
    }

    //Sets vertex weight in graph based on index
    public void setVertexWeight(int index, double weight) {
        this.vertexes[index].setDistance(weight);
    }

    public Vertex getVertex(int index) {
        if (index < numberOfVertexes) {
            return this.vertexes[index];
        }
        else {
            System.out.println("BAD INDEX FOR getVertex!");
        }
        return null;
    }

    public AdjacencyMatrix getAdjacencyMatrix() {
        return this.adjacencyMatrix;
    }
}
