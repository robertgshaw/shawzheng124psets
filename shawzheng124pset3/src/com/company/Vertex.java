package com.company;

/**
 * Created by robertshaw on 2/16/16.
 */
public class Vertex {
    // index = ID of vertex
    private int indexInGraph;
    private double distance;
    private int prevPointer;
    private boolean visited; // Indicates if a vertex has been visited in Prim's algorithm

    // NOTE: Adjacency list is implied here: it is connected to all other nodes

    // constructor
    // NOTE: EACH VERTEX ID by its index in graph
    public Vertex(int index) {
        if (index >= 0) {
            this.indexInGraph = index;
        } else {
            this.indexInGraph =  -1;
        }

        this.distance = Double.MAX_VALUE;
        this.prevPointer = -1;
        this.visited = false;
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

    // setter of the distance
    public void setDistance(double distance) {
        this.distance = distance;
    }

    // getter of the distance
    public double getDistance() {
        return this.distance;
    }

    // Sets parent pointer of current vertex using parameter index
    public void setPrevPointer(int index) {
        this.prevPointer = index;
    }

    // Returns parent pointer of current vertex
    public int getPrevPointer() {
        return this.prevPointer;
    }

    // setter of the visited
    public void visit() {
        this.visited = true;
    }

    // getter of the visited
    public boolean isVisited() {
        return visited;
    }

    // toString method for printing
    @Override
    public String toString() {
        return  "Vertex Index: " + this.indexInGraph +
                ", Vertex Weight: " + this.distance
                + ", Visited: " + this.visited
                + ", PrevPointer: " + this.prevPointer;
    }
}
