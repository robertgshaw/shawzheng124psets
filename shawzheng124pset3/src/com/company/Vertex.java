package com.company;

/**
 * Created by robertshaw on 2/16/16.
 */
public class Vertex {
    // index = ID of vertex
    private int indexInGraph;
    private double weight;

    // NOTE: Adjacency list is implied here: it is connected to all other nodes

    // constructor
    // NOTE: EACH VERTEX ID by its index in graph
    Vertex(int index) {
        if (index >= 0) {
            this.indexInGraph = index;
        } else {
            this.indexInGraph =  -1;
        }
    }

    // setter of index in graph
    public void setIndexInGraph(int index) {
        if (index >= 0) {
            this.indexInGraph = index;
        } else {
            this.indexInGraph =  -1;
        }
    }

    // getter of index in graph
    public int getIndexInGraph() {
        return this.indexInGraph;
    }

    // setter of the weight
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // getter of the weight
    public double getWeight() {
        return this.weight;
    }

    // toString method for printing
    @Override
    public String toString() {
        return  "Vertex Index: " + this.indexInGraph +
                ", Vertex Weight " + this.weight;
    }
}
