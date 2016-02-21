package com.company;

/**
 * Created by robertshaw on 2/21/16.
 */
public class Edge {
    public int[] vertexes;
    public float weight;

    Edge(int vertex1, int vertex2, float weight) {
        this.vertexes = new int[2];
        this.vertexes[0] = vertex1;
        this.vertexes[1] = vertex2;
        this.weight = weight;
    }
}
