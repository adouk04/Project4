/*
 * Course: TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                   and Application
 *  Name:		   Alex Douk
 *  Instructor:	Mr. Schuessler
 *  Assignment:   Programming Assignment 4
 *
 *  File Name:	Rectangle.java
 */
 
/**
 * Represents a Rectangle shape with a specified length and width.
 * Provides methods to set dimensions, calculate area,
 * and create a copy of the rectangle.
 * Extends the AbstractShape class.
 * 
 * @author Alex Douk
 * @version Fall 2024
 */
public class Rectangle extends AbstractShape {
    
    /** The length of the rectangle. */
    private double myLength;

    /** The width of the rectangle. */
    private double myWidth;

    /** Unique identifier for each rectangle instance. */
    private static int myID;

    /**
     * Constructs a rectangle with default dimensions
     * of 1.0 for both length and width.
     */
    public Rectangle() {
        this(1.0, 1.0);
    }

    /**
     * Constructs a rectangle with the specified length and width.
     *
     * @param myLength The length of the rectangle.
     * @param myWidth The width of the rectangle.
     * @throws IllegalArgumentException if myLength or myWidth is less
     *                                  than or equal to zero.
     */
    public Rectangle(final double myLength, final double myWidth) {
        super("Rectangle", ++myID);
        if (myLength <= 0 || myWidth <= 0) {
            myID--;
            throw new IllegalArgumentException
                    ("ERROR! Negative or 0 value can't " +
                            "be applied to a rectangle.");
        }
        this.myLength = myLength;
        this.myWidth = myWidth;
    }

    /**
     * Sets the length of the rectangle.
     *
     * @param theLength The new length of the rectangle.
     * @throws IllegalArgumentException if theLength is less
     *                                  than or equal to zero.
     */
    public void setLength(final double theLength) {
        if (theLength <= 0) {
            throw new IllegalArgumentException
                    ("ERROR! Negative or 0 value can't " +
                            "be applied to a rectangle.");
        }
        this.myLength = theLength;
    }

    /**
     * Sets the width of the rectangle.
     *
     * @param theWidth The new width of the rectangle.
     * @throws IllegalArgumentException if theWidth is less than
     *                                  or equal to zero.
     */
    public void setWidth(final double theWidth) {
        if (theWidth <= 0) {
            throw new IllegalArgumentException
                    ("ERROR! Negative or 0 value can't " +
                            "be applied to a rectangle.");
        }
        this.myWidth = theWidth;
    }

    /**
     * Calculates the area of the rectangle.
     *
     * @return The area of the rectangle.
     */
    public double calculateArea() {
        return myLength * myWidth;
    }

    /**
     * Creates and returns a copy of this rectangle
     * with the same length and width.
     *
     * @return A new Rectangle object with identical dimensions.
     */
    public final Shape copyShape() {
        return new Rectangle(myLength, myWidth);
    }

    /**
     * Returns a string representation of the
     * rectangle, including its name,
     * dimensions, and area.
     *
     * @return A formatted string describing the rectangle.
     */
    public String toString() {
        return String.format
                ("%s [Length: %.2f, Width: %.2f] Area: %.2f",
                        super.getName(), myLength,
                        myWidth, calculateArea());
    }
}
