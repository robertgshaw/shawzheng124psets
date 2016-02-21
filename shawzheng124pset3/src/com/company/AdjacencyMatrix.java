package com.company;

/**
 * Created by robertshaw on 2/17/16.
 */
public class AdjacencyMatrix {

    private double[][] matrix;
    // the matrix will look like this //
    /*      0       1       2       3       4
     *  0   x
     *
     *  1   x       x
     *
     *  2   x       x       x
     * (                                               )
     *  3   x       x       x       x
     *
     *  4   x       x       x       x       x
     */

    private int numberOfVertexes;

    // constructor
    AdjacencyMatrix(int n, int dimension, Vertex[] vertexes) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // zero dimension
        if (n > 0) {
            // sets number of vertexes
            this.numberOfVertexes = n;
            // initialize the number of rows
            this.matrix = new double[n][];
            // setup random edge weights for the 0D case
            if (dimension == 0) {
                // initialize the size of each column
                for (int i = 0; i < n; i++) {
                    this.matrix[i] = new double[i + 1];

                    // as each column is created, iterate through and randomly assign edge weights
                    for (int j = 0; j < i + 1; j++) {
                        this.setEdge(j, i, randomNumberGenerator.generateRandom());
                    }
                }
            // otherwise setup weights based on distance based on positions
            } else {
                // initialize the size of each column
                for (int i = 0; i < n; i++) {
                    this.matrix[i] = new double[i + 1];

                    // as each column is created, iterate through the row and assign edge weights
                    for (int j = 0; j < i + 1; j++) {
                        if (dimension == 2) {
                            this.setEdge(j, i, Position.calculateDistance2D(vertexes[j].getPosition(), vertexes[i].getPosition()));
                        } else if (dimension == 3) {
                            this.setEdge(j, i, Position.calculateDistance3D(vertexes[j].getPosition(), vertexes[i].getPosition()));
                        } else if (dimension == 4) {
                            this.setEdge(j, i, Position.calculateDistance4D(vertexes[j].getPosition(), vertexes[i].getPosition()));
                        } else {
                            System.out.println("dimension invalid");
                        }
                    }
                }
            }
        } else {
            System.out.println("Error making matrix");
        }
    }

    // sets edges
    private void setEdge(int i, int j, double weight) {
        // ensure that edge weights to itself is 0
        if (i == j && i < this.numberOfVertexes) {
            this.matrix[i][j] = 0.0;
            // ensure that the "larger" index is called first
        } else if (i < j && j < this.numberOfVertexes) {
            this.matrix[j][i] = weight;
        } else if (i > j && i < this.numberOfVertexes) {
            this.matrix[i][j] = weight;
        } else {
            System.out.println("Invalid Index");
        }
    }

    // gets edges
    public double getEdge(int i, int j) {
        // checks to make sure we have valid indexes
        // returns rubbish if not
        if (i == j) {
            if (i < this.numberOfVertexes) {
                return this.matrix[i][i];
            } else {
                System.out.println("Invalid Index");
                return -1.0;
            }
        } else if (i < j){
            if (j < this.numberOfVertexes) {
                return this.matrix[j][i];
            } else {
                System.out.println("Invalid Index");
                return -1.0;
            }
        } else {
            if (i < this.numberOfVertexes) {
                return this.matrix[i][j];
            } else {
                System.out.println("Invalid Index");
                return -1.0;
            }
        }

    }

    // toString method for printing
    @Override
    public String toString() {
        // printout the edge weights

        String accumulator = new String();
        for (int i = 0; i < this.numberOfVertexes; i++) {
            for (int j = 0; j < i; j++) {
                accumulator = accumulator + "\n Edge Index: " + i + " " + j + " " +
                        "Edge Weight " + this.matrix[i][j];
            }
        }

        return accumulator;
    }
}
