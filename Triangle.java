/*
 * Alex Douk
 * TCSS 143
 */

public class Triangle extends AbstractShape {
    private double mySideA;
    private double mySideB;
    private double mySideC;
    private static int myID;

    public Triangle() {
        this(1.0, 1.0, 1.0);
    }

    public Triangle(final double sideA, final double sideB, final double sideC) {
        super("Triangle", ++myID);
        double longestSide = Math.max(sideA, Math.max(sideB, sideC));
        double solution = longestSide * longestSide;
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            if (longestSide == sideC) {
                if (solution != sideA * sideB + sideB * sideB) {
                    myID--; // Decrement myID before throwing exception
                    throw new IllegalArgumentException("ERROR! Negative or 0 value can't be applied to a rectangle.");
                }
            }
            else if (longestSide == sideB) {
                if (solution != sideA * sideA + sideC * sideC) {
                    myID--;
                    throw new IllegalArgumentException("ERROR! Negative or 0 value can't be applied to a rectangle.");
                }
            }
            else if (longestSide == sideA) {
                if (solution != sideB * sideB + sideC * sideC) {
                    myID--;
                    throw new IllegalArgumentException("ERROR! Negative or 0 value can't be applied to a rectangle.");
                }
            }
        }
        this.mySideA = sideA;
        this.mySideB = sideB;
        this.mySideC = sideC;
    }

    public void setSideA(final double sideA) {
        this.mySideA = sideA;
    }
    public void setSideB(final double sideB) {
        this.mySideB = sideB;
    }

    public void setSideC(final double sideC) {
        this.mySideA = sideC;
    }
    public double calculateArea() {
        return (mySideA * mySideB) / 2;
    }

    public final Shape copyShape() {
        return new Triangle(mySideA, mySideB, mySideC);
    }

    public String toString() {
        return String.format("%s [SideA: %.2f, SideB: %.2f, SideC: %.2f] Area: %.2f", super.getName(), mySideA, mySideB,
                mySideC, calculateArea());

    }

    public int compareTo(Shape o) {
        return 0;
    }
}
