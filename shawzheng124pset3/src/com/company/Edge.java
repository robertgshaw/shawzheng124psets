package com.company;

/**
 * Created by robertshaw on 2/16/16.
 */

public class Edge {
    private int[] vertexes = new int[2];
    private double weight = Double.MAX_VALUE;
    private int indexInGraph;

    // constructor
    Edge(int[] vertexes, double weight, int index) {
        // if the vertex array is the correct size
        if (vertexes.length == 2) {
            this.vertexes = vertexes;
        }

        // sets the weight
        this.weight = weight;

        // sets the Edge's index in the graph
        if (index < 0) {
            this.indexInGraph = -1;
        } else {
            this.indexInGraph = index;
        }
    }

    // sets the weight of the edge
    public void setWeight(double weight) {
        this.weight = weight;
        return;
    }

    // get the weight of the edge
    public double getWeight() {
        return this.weight;
    }

    // sets the vertexes of the edge
    public void setVertexes(int[] vertexes){
        // only update if of correct size
        if (vertexes.length == 2) {
            this.vertexes = vertexes;
        }
        return;
    }

    // gets the vertexes
    public int[] getVertexes() {
        return this.vertexes;
    }

    // sets the index
    public void setIndexInGraph(int index) {
        if (index < 0) {
            return;
        } else {
            this.indexInGraph = index;
            return;
        }
    }

    // gets the index
    public int getIndexInGraph() {
        return this.getIndexInGraph();
    }

    // toString method for printing
    @Override
    public String toString() {
        return  "Edge Index: " + this.indexInGraph +
                ", Edge Vertexes " + this.vertexes[0] + " " + this.vertexes[1] +
                ", Edge Weight " + this.weight;
    }
}
