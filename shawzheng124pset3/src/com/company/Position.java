package com.company;

/**
 * Created by robertshaw on 2/21/16.
 */
public class Position {
    private double x;
    private double y;
    private double z;
    private double w;
    private int dimension;

    // 2D constructor
    Position(int dimension, double x, double y) {
        if (dimension != 2) {
            System.out.println("Invalid arguments");
        } else {
            this.x = x;
            this.y = y;
            this.dimension = dimension;
        }
    }

    // 3D constructor
    Position(int dimension, double x, double y, double z) {
        if (dimension != 3) {
            System.out.println("Invalid arguments");
        } else {
            this.x = x;
            this.y = y;
            this.z = z;
            this.dimension = dimension;
        }
    }

    // 4D constructor
    Position(int dimension, double x, double y, double z, double w) {
        if (dimension != 4) {
            System.out.println("Invalid arguments");
        } else {
            this.x = x;
            this.y = y;
            this.z = z;
            this.w = w;
            this.dimension = dimension;
        }
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        if (this.dimension == 2) {
            System.out.println("There is no z coordinate");
            return Double.MAX_VALUE;
        } else {
            return this.z;
        }
    }

    public double getW() {
        if (this.dimension == 2 || this.dimension == 3) {
            System.out.println("There is no z coordinate");
            return Double.MAX_VALUE;
        } else {
            return this.w;
        }
    }

    /*
     * CLASS METHODS
     */

    // class method used to calculate euclidian distance in 2D
    public static double calculateDistance2D(Position vertex1, Position vertex2) {
        return Math.pow(vertex1.x - vertex2.x, 2) + Math.pow(vertex1.y - vertex2.y, 2);
    }

    // class method used to calculate euclidian distance in 3D
    public static double calculateDistance3D(Position vertex1, Position vertex2) {
        return  Math.pow(vertex1.x - vertex2.x, 2) + Math.pow(vertex1.y - vertex2.y, 2) +
                Math.pow(vertex1.z - vertex2.z, 2);
    }

    // class method used to calculate euclidian distance in 4D
    public static double calculateDistance4D(Position vertex1, Position vertex2) {
        return  Math.pow(vertex1.x - vertex2.x, 2) + Math.pow(vertex1.y - vertex2.y, 2) +
                Math.pow(vertex1.z - vertex2.z, 2) + Math.pow(vertex1.w - vertex2.w, 2);
    }

    @Override
    public String toString() {
        if (this.dimension == 0) {
            return "0D";
        } else if (this.dimension == 2) {
            return "(" + this.x + ", " + this.y + ")";
        } else if (this.dimension == 3) {
            return "(" + this.x + ", " + this.y + ", " + this.z + ")";
        } else {
            return "(" + this.x + ", " + this.y + ", " + this.z + ", " + this.w + ")";
        }
    }
}
