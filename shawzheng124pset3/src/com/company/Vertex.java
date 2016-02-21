package com.company;

import sun.java2d.pisces.PiscesRenderingEngine;

/**
 * Created by robertshaw on 2/16/16.
 */
public class Vertex {
    // index = ID of vertex
    private int indexInGraph;
    private int indexinHeap; // Tracks vertex index in heap
    private double distance;
    private int dimension;
    private Position position;
    private int prevPointer;
    private boolean visited; // Indicates if a vertex has been visited in Prim's algorithm

    // constructor
    // NOTE: EACH VERTEX ID by its index in graph
    public Vertex(int index, int dimension) {
        // checks index/ id of vertex
        if (index >= 0) {
            this.indexInGraph = index;
        } else {
            System.out.println();
            this.indexInGraph =  -1;
        }

        // random number generator
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // setup 0D case
        if (dimension == 0) {
            this.dimension = 0;
            this.position = null;

        // setup 2D case, by giving random x,y coordinates
        } else if (dimension == 2) {
            this.dimension = 2;
            this.position =
                    new Position(2, randomNumberGenerator.generateRandom(),
                                    randomNumberGenerator.generateRandom());
        // setup 3D case, by giving random x,y,z coordinates
        } else if (dimension == 3) {
            this.dimension = 3;
            this.position =
                    new Position(3, randomNumberGenerator.generateRandom(),
                                    randomNumberGenerator.generateRandom(),
                                    randomNumberGenerator.generateRandom());
        // setup 4D case, by giving random x,y,z,w coordinates
        } else {
            this.dimension = 4;
            this.position =
                    new Position(4, randomNumberGenerator.generateRandom(),
                                    randomNumberGenerator.generateRandom(),
                                    randomNumberGenerator.generateRandom(),
                                    randomNumberGenerator.generateRandom());
        }

        // initializes values for prims
        this.distance = Double.MAX_VALUE;
        this.prevPointer = -1;
        this.visited = false;
        this.indexinHeap = -1;
    }

    // setter of index in graph
    public void setIndexInGraph(int index) {
        if (index >= 0) {
            this.indexInGraph = index;
        } else {
            this.indexInGraph =  -1;
        }
    }

    // checks if a vertex is already in the heap
    public boolean isInHeap(){
        if (this.indexinHeap >= 0) {
            return true;
        }
        else {
            return false;
        }
    }

    // getter of position
    public Position getPosition() { return this.position; }

    // getter of index in heap
    public int getIndexinHeap() {
        return this.indexinHeap;
    }

    // getter of index in heap
    public void setIndexinHeap(int index) {
        this.indexinHeap = index;
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
        String returnString = "Vertex Index: " + this.indexInGraph +
                    ", Vertex Weight: " + this.distance
                    + ", Visited: " + this.visited
                    + ", PrevPointer: " + this.prevPointer;
        if(this.dimension != 0) {
            returnString = returnString + ", Position:" + this.position.toString();
        }

        return returnString;

    }
}
