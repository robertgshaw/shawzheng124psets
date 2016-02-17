package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("My first Java Program!"); // prints Hello World

        Graph graph = new Graph(10, 0);

        for (int i = 0 ; i < graph.vertexes.length; i++) {
            System.out.println(graph.vertexes[i].toString());
        }

        for (int i = 0 ; i < graph.edges.length; i++) {
            System.out.println(graph.edges[i].toString());
        }

    }
}
