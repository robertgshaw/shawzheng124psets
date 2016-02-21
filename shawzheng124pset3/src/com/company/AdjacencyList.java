package com.company;

import java.util.LinkedList;

/**
 * Created by robertshaw on 2/21/16.
 */
public class AdjacencyList {

    private LinkedList[] adjacencyList;
    private int numberOfVertexes;

    // constructor
    AdjacencyList(int n, int dimension, Vertex[] vertexes) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // zero dimension
        if (n > 0) {
            // sets number of vertexes
            this.numberOfVertexes = n;
            // initialize the number of rows
            this.adjacencyList = new LinkedList[n];
            // setup random edge weights for the 0D case
            if (dimension == 0) {
                // initialize each linked list
                for (int i = 0; i < this.numberOfVertexes; i++) {
                    this.adjacencyList[i] = new LinkedList();

                    // inititializes all element to be null
                    for (int j = 0; j < this.numberOfVertexes; j++) {
                        this.adjacencyList[i].add(null);
                    }
                }


                // as each column is created, iterate through and randomly assign edge weights
                for (int i = 0; i < this.numberOfVertexes ; i++) {
                    // ensure that we only add each edge once, and that ij and ji are the same
                    for (int j = 0; j < i; j++) {
                        // adds the edge to the linked list in "both directions" of the edge
                        float randomWeight = randomNumberGenerator.generateRandom();
                        Edge edgeIJ = new Edge(i, j, randomWeight);
                        this.adjacencyList[i].set(j, edgeIJ);
                        this.adjacencyList[j].set(i, edgeIJ);
                    }
                }

                // otherwise setup weights based on distance based on positions
            } else {
                // initialize the linked list
                for (int i = 0; i < this.numberOfVertexes; i++) {
                    this.adjacencyList[i] = new LinkedList();
                    for (int j = 0; j < this.numberOfVertexes; j++) {
                        this.adjacencyList[i].add(null);
                    }
                }

                for (int i = 0; i < this.numberOfVertexes; i++) {
                    float weight; // calculate edge weight

                    // calculates edge weights based on random positions
                    for (int j = 0; j < i; j++) {
                        if (dimension == 2) {
                            weight = Position.calculateDistance2D(vertexes[j].getPosition(), vertexes[i].getPosition());
                        } else if (dimension == 3) {
                            weight = Position.calculateDistance3D(vertexes[j].getPosition(), vertexes[i].getPosition());
                        } else if (dimension == 4) {
                            weight = Position.calculateDistance4D(vertexes[j].getPosition(), vertexes[i].getPosition());
                        } else {
                            weight = 0;
                            System.out.println("dimension invalid");
                        }

                        // adds the edges to the linked lists twice
                        Edge edgeIJ = new Edge(i, j, weight);
                        this.adjacencyList[i].set(j, edgeIJ);
                        this.adjacencyList[j].set(i, edgeIJ);
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
            // invariant that every node is connected to every other node
            Object object = this.adjacencyList[i].get(j);
            Edge edgeIJ = (Edge) object;
            return edgeIJ.weight;
        }
    }
}
