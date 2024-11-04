/*
 * Course: TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                   and Application
 *  Name:		   Alex Douk
 *  Instructor:	Mr. Schuessler
 *  Assignment:   Programming Assignment 4
 *
 *  File Name:	Circle.java
 */

/**
 * The Circle class represents a circle shape with a specified radius.
 * It extends the AbstractShape class and provides methods to calculate
 * the area, set the radius, and create a copy of the circle.
 * 
 * @author Alex Douk
 * @version Fall 2024
 */
public class Circle extends AbstractShape {
    
    /** The radius of the circle. */
    private double myRadius;
    
    /** A static ID counter to uniquely identify each Circle instance. */
    private static int myID;

    /**
     * Default constructor that creates a Circle with a radius of 1.0.
     */
    public Circle() {
        this(1.0);
    }

    /**
     * Constructs a Circle with the specified radius.
     * 
     * @param theRadius
     *        The radius of the circle.
     * @throws IllegalArgumentException
     *         if the radius is zero or negative.
     */
    public Circle(final double theRadius) {
        super("Circle", ++myID);
        if (theRadius <= 0) {
            myID--; // Decrement myID before throwing exception
            throw new IllegalArgumentException
                    ("ERROR! Negative or 0 value can't " +
                            "be applied to a circle radius.");
        }
        this.myRadius = theRadius;
    }

    /**
     * Sets the radius of the circle to a new value.
     * 
     * @param theRadius The new radius for the circle.
     * @throws IllegalArgumentException
     *          if the radius is zero or negative.
     */
    public void setRadius(final double theRadius) {
        if (theRadius <= 0) {
            throw new IllegalArgumentException
                    ("ERROR! Negative or 0 value can't " +
                            "be applied to a circle radius.");
        }
        myRadius = theRadius;
    }

    /**
     * Calculates and returns the area of the circle.
     * 
     * @return The area of the circle.
     */
    public double calculateArea() {
        return (myRadius * myRadius) * Math.PI;
    }

    /**
     * Creates and returns a copy of
     * the current Circle instance.
     * 
     * @return A new Circle object with the
     *         same radius as the original.
     */
    public final Shape copyShape() {
        Circle newC = new Circle(myRadius);
        return newC;
    }

    /**
     * Returns a string representation of the circle, including
     * the name, radius, and calculated area.
     * 
     * @return A formatted string representing the circle.
     */
    public String toString() {
        return String.format("%s [Radius: %.2f] Area: %.2f",
                super.getName(), myRadius, calculateArea());
    }
}
