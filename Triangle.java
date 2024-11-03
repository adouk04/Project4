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

        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            myID--; // Decrement myID before throwing exception
            throw new IllegalArgumentException("ERROR! Negative or zero value can't be applied to a triangle.");
        }

        if (!(sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA)) {
            myID--; // Decrement myID before throwing exception
            throw new IllegalArgumentException("ERROR! Not a Triangle. Longest side too long.");
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
        double s = (mySideA + mySideB + mySideC) / 2; // semi-perimeter
        return Math.sqrt(s * (s - mySideA) * (s - mySideB) * (s - mySideC));

    }

    public final Shape copyShape() {
        return new Triangle(mySideA, mySideB, mySideC);
    }

    public String toString() {
        return String.format("%s [SideA: %.2f, SideB: %.2f, SideC: %.2f] Area: %.2f", super.getName(), mySideA, mySideB,
                mySideC, calculateArea());

    }

    public int compareTo(Shape o) {
        return Double.compare(this.calculateArea(), o.calculateArea());
    }
}
