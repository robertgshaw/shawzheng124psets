package com.company;

import java.util.LinkedList;

/**
 * Created by robertshaw on 2/21/16.
 */
public class AdjacencyList {

    public LinkedList[] adjacencyList;
    private int numberOfVertexes;

    // constructor
    AdjacencyList(int n, int dimension, Vertex[] vertexes, boolean prune) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // zero dimension
        if (n > 0) {
            // sets number of vertexes
            this.numberOfVertexes = n;
            // initialize the number of rows
            this.adjacencyList = new LinkedList[n];
            // setup random edge weights for the 0D case
            if (dimension == 0) {
                for (int i = 0; i < this.numberOfVertexes ; i++) {

                    // creates array of linked lists
                    this.adjacencyList[i] = new LinkedList();
                    // ensure that we only add each edge once, and that ij and ji are the same
                    for (int j = 0; j <= i; j++) {
                        // adds the edge to the linked list in "both directions" of the edge
                        float randomWeight = randomNumberGenerator.generateRandom();

                        // prunes the data, throws away data larger than k(n), based on empirical evidence
                        // see documentation for more details
                        if (prune) {
                            // if small enough, add to graph
                            if (randomWeight < 1 / ((float) (Math.pow((double) this.numberOfVertexes, (double) 1/2)))) {
                                if (i == j) {
                                   // do not add
                                } else {
                                    Edge edgeIJ = new Edge(randomWeight, i, j);
                                    this.adjacencyList[i].add(edgeIJ);
                                    this.adjacencyList[j].add(edgeIJ);
                                }
                            // otherwise, too large, add null and throw away
                            } else {
                                // do nothing
                            }
                        } else if (!prune) {
                            if(i == j) {
                                // do nothing
                            } else {
                                // add to the adjacency list
                                Edge edgeIJ = new Edge(randomWeight, i, j);
                                this.adjacencyList[i].add(edgeIJ);
                                this.adjacencyList[j].add(edgeIJ);
                            }
                        }
                    }
                }

                // otherwise setup weights based on distance based on positions
            } else {
                // initialize the linked list
                for (int i = 0; i < this.numberOfVertexes; i++) {
                    this.adjacencyList[i] = new LinkedList();
                    float weight; // calculate edge weight

                    // calculates edge weights based on random positions
                    for (int j = 0; j < i; j++) {
                        if (dimension == 2) {
                            weight = Position.calculateDistance2D(vertexes[j].getPosition(), vertexes[i].getPosition());
                            // pruning algorithm, see documentation
                            if (prune && weight < 1/ ((float) (Math.pow((double) this.numberOfVertexes, (double) 1/3)))) {
                                // adds the edges to the linked lists twice
                                Edge edgeIJ = new Edge(weight, i, j);
                                this.adjacencyList[i].add(edgeIJ);
                                this.adjacencyList[j].add(edgeIJ);

                            } else {
                                // do not add to the adjacency lsits
                                // do nothing
                            }
                        } else if (dimension == 3) {
                            weight = Position.calculateDistance3D(vertexes[j].getPosition(), vertexes[i].getPosition());
                            // pruning algorithm, see documentation
                            if (prune && weight < 1.35/ ((float) (Math.pow((double) this.numberOfVertexes, (double) 4)))) {
                                // adds the edges to the linked lists twice
                                Edge edgeIJ = new Edge(weight, i, j);
                                this.adjacencyList[i].add(edgeIJ);
                                this.adjacencyList[j].add(edgeIJ);

                            } else {
                                // do not add to the adjacency lists
                                // do nothing
                            }
                        } else if (dimension == 4) {
                            weight = Position.calculateDistance4D(vertexes[j].getPosition(), vertexes[i].getPosition());
                            // pruning algorithm, see documentation
                            if (prune && weight < 1.4/ ((float) (Math.pow((double) this.numberOfVertexes, (double) 1/5)))) {
                                // adds the edges to the linked lists twice
                                Edge edgeIJ = new Edge(weight, i, j);
                                this.adjacencyList[i].add(edgeIJ);
                                this.adjacencyList[j].add(edgeIJ);

                            } else {
                                // do not add to the adjacency lists
                                // do nothing
                            }
                        } else {
                            weight = 0;
                            System.out.println("dimension invalid");
                        }

                        // adds the edges to the linked lists twice, only implemented for smaller numbers of
                        // vertices where we do not throw away any edges
                        if (!prune) {
                            Edge edgeIJ = new Edge(weight, i, j);
                            this.adjacencyList[i].add(edgeIJ);
                            this.adjacencyList[j].add(edgeIJ);
                        }
                    }
                }
            }
        } else {
            System.out.println("Error making matrix");
        }
    }

    // gets edges
    public float getEdge(int i, int j) {
        // checks to make sure we have valid indexes
        // returns rubbish if not
        if (i == j) {
            return 0;
        } else {
            for (int k = 0; i < this.adjacencyList[i].size(); k++) {
                Object object = this.adjacencyList[i].get(k);
                Edge edge = (Edge)object;
                // if j is one of the two
                if (j == edge.getVertexes()[0] || j == edge.getVertexes()[1]) {
                    return edge.weight;
                }
            }

            return Float.MAX_VALUE;
        }
    }

    // checks if an edge exists
    public boolean edgeExists(int i, int j) {
        // check to make sure that the edge has not been "pruned"
        Object object = this.adjacencyList[i].get(j);
        if (object == null) {
            return false;
        } else {
            return true;
        }
    }
}
