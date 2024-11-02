public class Circle extends AbstractShape {
    private double myRadius;
    private static int myID;

    public Circle() {
        this(1.0);
    }

    public Circle(final double theRadius) {
        super("Circle", ++myID);
        if (theRadius <= 0) {
            myID--; // Decrement myID before throwing exception
            throw new IllegalArgumentException("ERROR! Negative or 0 value can't be applied to a circle radius.");
        }
        this.myRadius = theRadius;
    }

    public void setRadius(final double radius) {
        myRadius = radius;
    }

    public double calculateArea() {
        return (myRadius * myRadius) * Math.PI;
    }
    public final Shape copyShape() {
        Circle newC = new Circle();
        newC.myRadius = myRadius;
        return newC;
    }

    public String toString() {
        return String.format("%s [Radius: %.2f] Area: %.2f", super.getName(), myRadius, calculateArea());
    }

    @Override
    public int compareTo(Shape o) {
        return 0;
    }
}
