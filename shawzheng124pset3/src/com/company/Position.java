package com.company;

/**
 * Created by robertshaw on 2/21/16.
 */
public class Position {
    private float x;
    private float y;
    private float z;
    private float w;
    private int dimension;

    // 2D constructor
    Position(int dimension, float x, float y) {
        if (dimension != 2) {
            System.out.println("Invalid arguments");
        } else {
            this.x = x;
            this.y = y;
            this.dimension = dimension;
        }
    }

    // 3D constructor
    Position(int dimension, float x, float y, float z) {
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
    Position(int dimension, float x, float y, float z, float w) {
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

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getZ() {
        if (this.dimension == 2) {
            System.out.println("There is no z coordinate");
            return Float.MAX_VALUE;
        } else {
            return this.z;
        }
    }

    public float getW() {
        if (this.dimension == 2 || this.dimension == 3) {
            System.out.println("There is no z coordinate");
            return Float.MAX_VALUE;
        } else {
            return this.w;
        }
    }

    /*
     * CLASS METHODS
     */
    private static float squared(float f) {
        return f * f;
    }

    // class method used to calculate euclidian distance in 2D
    public static float calculateDistance2D(Position vertex1, Position vertex2) {
        return (float) Math.sqrt((double) Position.squared(vertex1.x - vertex2.x) + Position.squared(vertex1.y - vertex2.y));

    }

    // class method used to calculate euclidian distance in 3D
    public static float calculateDistance3D(Position vertex1, Position vertex2) {
        return (float) Math.sqrt((double) Position.squared(vertex1.x - vertex2.x) + Position.squared(vertex1.y - vertex2.y) +
                Position.squared(vertex1.z - vertex2.z));
    }

    // class method used to calculate euclidian distance in 4D
    public static float calculateDistance4D(Position vertex1, Position vertex2) {
        return  (float) Math.sqrt((double) Position.squared(vertex1.x - vertex2.x) + Position.squared(vertex1.y - vertex2.y) +
                Position.squared(vertex1.z - vertex2.z) + Position.squared(vertex1.w - vertex2.w));
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
