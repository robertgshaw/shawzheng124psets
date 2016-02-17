package com.company;

/**
 * Created by robertshaw on 2/16/16.
 */
public class PriorityQueue {
    private Vertex[] heap;
    private int size;

    // takes in the max possible elements in the queue as an argument as well
    PriorityQueue(int n) {
        // sets heap to have max possible size
        this.heap = new Vertex[n];

        // keeps track of the last element in the heap currently
        this.size = 0;
    }

    // insert a vertex into the heap
    public void insertVertex(Vertex vertex) {
        if (this.size >= this.heap.length) {
            // TODO: raise exception here
            System.out.println("ERROR!!!");
        }
        // otherwise add into next available spot in the heap
        else if (this.size < this.heap.length) {
            // adds to the heap
            this.heap[size] = vertex;
            // increments size
            this.size = this.size + 1;

            // swaps up the tree until invariant satisfied
            int parentIndex = this.parent(this.size - 1);
            Vertex parent = this.heap[parentIndex];
            while(parentIndex != 0 && parent.getWeight() > vertex.getWeight()) {
                this.swap(parentIndex, this.size - 1);
            }
        }
    }

    // delete a vertex from the top of the heap
    public void deleteMin() {
        Vertex min = this.heap[0];
        // moves the last element of the heap to the top
        this.heap[0] = this.heap[this.size];
        // decrements the size
        this.size = this.size - 1;
        // fixes the invariant
        this.minHeapify(this.heap, this.heap[0], 0);
    }

    // "fixes the heap invariant" to ensure valid heap
    private void minHeapify(Vertex[] heap, Vertex root, int rootIndex) {
        // finds index of the children
        int leftIndex = this.left(rootIndex);
        int rightIndex = this.right(rootIndex);

        Vertex leftChild;
        Vertex rightChild;

        // checks if children exist before assignment
        if (this.exists(leftIndex)) {
            leftChild = heap[this.left(rootIndex)];
        } else {
            leftChild = null;
        }
        if (this.exists(rightIndex)) {
            rightChild = heap[this.right(rootIndex)];
        } else {
            rightChild = null;
        }

        // sets the "smallest of the three"
        Vertex smallest = null;
        int smallestIndex = 0;
        if (exists(leftIndex) && (root.getWeight() > leftChild.getWeight())) {
            smallest = leftChild;
            smallestIndex = leftIndex;
        } else {
            smallest = root;
            smallestIndex = rootIndex;
        }

        if (exists(rightIndex) && (smallest.getWeight() > rightChild.getWeight())) {
            smallest = rightChild;
            smallestIndex = rightIndex;
        }

        // swaps the head with the smallest, recursively call function
        if (smallest != root) {
            this.swap(smallestIndex, rootIndex);
            this.minHeapify(heap, smallest, smallestIndex);
        }
    }

    // builds heap from an unsorted array
    private void buildHeap(Vertex[] array) {
        for (int i =  Math.floorDiv(array.length, 2); i > 0; i--) {
            this.minHeapify(array, array[i], i);
        }
    }

    // HELPER FUNCTIONS TO FIND...
    // parent of a vertex
    private int parent(int i) {
        return Math.floorDiv(i, 2);
    }

    // left child of a vertex
    private int left(int i) {
        return 2 * i;
    }

    // right child of a vertex
    private int right(int i) {
        return 2 * i + 1;
    }

    // check if a child node exists
    private boolean exists(int i) {
        // if i is "within the array"
        if(i < size) {
            return true;
        } else {
            return false;
        }
    }

    // swap 2 elements in an array
    private void swap(int i, int j) {
        Vertex temp;
        temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;

        return;
    }
}
