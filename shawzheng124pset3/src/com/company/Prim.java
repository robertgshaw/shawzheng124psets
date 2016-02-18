package com.company;

/**
 * Created by robertshaw on 2/16/16.
 */
public class Prim {
    private Graph graph;
    private Vertex[] tree;
    private Vertex[] heap;

    Prim(Graph graph, int size) {
        // load the graph
        this.graph = graph;

        // set the tree to be empty at first
        this.tree = new Vertex[size];

        // TODO: create HEAP of the graph's vertexes, starting empty

        // sets the arbitrary starting node's distance to be 0
        //this.graph.vertexes[0].setWeight(0);

        // TODO: add this node to the priority queue

        // TODO: deletemin of priority queue
        // TODO: add deleted element to the tree

        // TODO: iteratre through its edges, updating the node weights appropriately and adding to the heap

        // TODO: go through the priority queue

    }

}
