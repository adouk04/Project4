/*
 * Course: TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                   and Application
 *  Name:		   Alex Douk
 *  Instructor:	Mr. Schuessler
 *  Assignment:   Programming Assignment 4
 *
 *  File Name:	AbstractShape.java
 */
 
/**
 * Represents a general shape and provides common functionalities
 * for specific shape types like Circle, Rectangle, and Triangle.
 * This is an abstract class.
 *
 * @author Alex Douk
 * @version Fall 2024
 */
public abstract class AbstractShape implements Shape {
    /** The name of the shape. */
    final private String shapeName;

    /**
     * Constructs an AbstractShape with the specified name.
     * 
     * @param myShapeName The base name of the shape.
     * @param myNumber The identifier number of the shape instance.
     */
    public AbstractShape(String myShapeName, int myNumber) {
        this.shapeName = myShapeName + myNumber;
    }

    /**
     * Returns the name of the shape.
     * 
     * @return The name of the shape.
     */
    public String getName() {
        return this.shapeName;
    }

    /**
     * Compares this shape with another based on their areas.
     * 
     * @param other The shape to compare with.
     * @return A negative integer, zero, or a
     * positive integer as this shape's area
     * is less than, equal to, or greater
     * than the specified shape's area.
     */
    @Override
    public int compareTo(Shape other) {
        return Double.compare
                (this.calculateArea(), other.calculateArea());
    }
}