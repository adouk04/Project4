/*
 * Course: TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                   and Application
 *  Name:		   Alex Douk
 *  Instructor:	Mr. Schuessler
 *  Assignment:   Programming Assignment 4
 *
 *  File Name:	Triangle.java
 */
 
/**
 * The Triangle class represents a triangle
 * shape with three specified side lengths.
 * It extends the AbstractShape class and provides methods to calculate
 * the area, set each side, and create a copy of the triangle.
 * 
 * @author Alex Douk
 * @version Fall 2024
 */
public class Triangle extends AbstractShape {

    /** The length of side A of the triangle. */
    private double mySideA;

    /** The length of side B of the triangle. */
    private double mySideB;

    /** The length of side C of the triangle. */
    private double mySideC;

    /** A static ID counter to uniquely
     * identify each Triangle instance. */
    private static int myID;

    /**
     * Default constructor that creates
     * a Triangle with sides of length 1.0.
     */
    public Triangle() {
        this(1.0, 1.0, 1.0);
    }

    /**
     * Constructs a Triangle with the specified side lengths.
     * 
     * @param sideA The length of side A.
     * @param sideB The length of side B.
     * @param sideC The length of side C.
     * @throws IllegalArgumentException
     * if any side is zero or negative, or if the side
     * lengths do not form a valid triangle.
     */
    public Triangle
    (final double sideA, final double sideB, final double sideC) {
        super("Triangle", ++myID);

        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            myID--; // Decrement myID before throwing exception
            throw new IllegalArgumentException
                    ("ERROR! Negative or zero value can't " +
                            "be applied to a triangle.");
        }

        if (!(sideA + sideB > sideC && sideA +
                sideC > sideB && sideB + sideC > sideA)) {
            myID--; // Decrement myID before throwing exception
            throw new IllegalArgumentException
                    ("ERROR! Not a Triangle. Longest side too long.");
        }

        this.mySideA = sideA;
        this.mySideB = sideB;
        this.mySideC = sideC;
    }

    /**
     * Sets the length of side A, ensuring it forms a valid triangle.
     * 
     * @param sideA The new length of side A.
     * @throws IllegalArgumentException
     * if the new side length does not form a valid triangle.
     */
    public void setSideA(final double sideA) {
        if (!(sideA + mySideB > mySideC && sideA
                + mySideC > mySideB && mySideB + mySideC > sideA)) {
            throw new IllegalArgumentException
                    ("ERROR! Not a Triangle. Longest side too long.");
        }
        this.mySideA = sideA;
    }

    /**
     * Sets the length of side B, ensuring it forms a valid triangle.
     * 
     * @param sideB The new length of side B.
     * @throws IllegalArgumentException
     * if the new side length does not form a valid triangle.
     */
    public void setSideB(final double sideB) {
        if (!(mySideA + sideB > mySideC && mySideA
                + mySideC > sideB && sideB + mySideC > mySideA)) {
            throw new IllegalArgumentException
                    ("ERROR! Not a Triangle. Longest side too long.");
        }
        this.mySideB = sideB;
    }

    /**
     * Sets the length of side C, ensuring it forms a valid triangle.
     * 
     * @param sideC The new length of side C.
     * @throws IllegalArgumentException
     * if the new side length does not form a valid triangle.
     */
    public void setSideC(final double sideC) {
        if (!(mySideA + mySideB > sideC && mySideA
                + sideC > mySideB && mySideB + sideC > mySideA)) {
            throw new IllegalArgumentException
                    ("ERROR! Not a Triangle. Longest side too long.");
        }
        this.mySideC = sideC;
    }

    /**
     * Calculates and returns the area of
     * the triangle using Heron's formula.
     * 
     * @return The area of the triangle.
     */
    public double calculateArea() {
        double s = (mySideA + mySideB + mySideC) / 2; // semi-perimeter
        return Math.sqrt(s * (s - mySideA)
                * (s - mySideB) * (s - mySideC));
    }

    /**
     * Creates and returns a copy of the current Triangle instance.
     * 
     * @return A new Triangle object with the
     * same side lengths as the original.
     */
    public final Shape copyShape() {
        return new Triangle(mySideA, mySideB, mySideC);
    }

    /**
     * Returns a string representation of the triangle, including
     * the name, side lengths, and calculated area.
     * 
     * @return A formatted string representing the triangle.
     */
    public String toString() {
        return String.format
                ("%s [SideA: %.2f, SideB: %.2f, SideC: %.2f] " +
                                "Area: %.2f",
                super.getName(), mySideA, mySideB,
                mySideC, calculateArea());
    }
}
