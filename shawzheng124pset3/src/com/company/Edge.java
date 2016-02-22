package com.company;

/**
 * Created by robertshaw on 2/21/16.
 */
public class Edge {
    //public int[] vertexes;
    public float weight;
    public int i;
    public int j;

    Edge(float weight, int i, int j) {
        this.i = i;
        this.j = j;
        this.weight = weight;
    }

    public int[] getVertexes() {
        int[] intArray = new int[2];
        intArray[0] = this.i;
        intArray[1] = this.j;
        return intArray;

    }

}
