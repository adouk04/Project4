/*
 * Course: TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                   and Application
 *  Name:		   Alex Douk
 *  Instructor:	Mr. Schuessler
 *  Assignment:   Programming Assignment 4
 *
 *  File Name:	Shape.java
 */
 
/**
 * The Shape interface represents a geometric shape with methods 
 * to calculate its area, create a copy of
 * the shape, and retrieve its name.
 * This interface extends Comparable to allow
 * shapes to be compared based on area.
 * 
 * @author Alex Douk
 * @version Fall 2024
 */
public interface Shape extends Comparable<Shape> {

    /**
     * Calculates and returns the area of the shape.
     *
     * @return The area of the shape.
     */
    public double calculateArea();

    /**
     * Creates and returns a copy of the shape.
     *
     * @return A new Shape object that is a copy of the original shape.
     */
    public Shape copyShape();

    /**
     * Returns the name of the shape.
     *
     * @return The name of the shape as a String.
     */
    public String getName();
}
