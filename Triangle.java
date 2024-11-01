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
        this.mySideA = sideA;
        this.mySideB = sideB;
        this.mySideC = sideC;
    }

    public void setSideA(final double sideA) {
        if (sideA <= 0 && mySideC * mySideC > (mySideA*mySideA) + (mySideB * mySideB)) {
            myID--; // Decrement myID before throwing exception
            throw new IllegalArgumentException("ERROR! Negative or 0 value can't be applied to a rectangle.");
        }
        this.mySideA = sideA;
    }
    public void setSideB(final double sideB) {
        if (sideB <= 0 && mySideC * mySideC > (mySideA*mySideA) + (mySideB * mySideB)) {
            myID--; // Decrement myID before throwing exception
            throw new IllegalArgumentException("ERROR! Negative or 0 value can't be applied to a rectangle.");
        }
        this.mySideB = sideB;
    }

    public void setSideC(final double sideC) {
        if (sideC <= 0 && mySideC * mySideC > (mySideA*mySideA) + (mySideB * mySideB)) {
            myID--; // Decrement myID before throwing exception
            throw new IllegalArgumentException("ERROR! Negative or 0 value can't be applied to a rectangle.");
        }
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
