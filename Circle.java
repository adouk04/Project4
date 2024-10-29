public class Circle extends AbstractShape {
    private double myRadius;
    private static int myID;

    public Circle() {
        this(1.0);
    }

    public Circle(final double radius) {
        super("Circle", ++myID);
        this.myRadius = radius;
    }

    public double setRadius(final double radius) {
        if (radius <= 0) {
            myID--; // Decrement myID before throwing exception
            throw new IllegalArgumentException("ERROR! Negative or 0 value can't be applied to a circle radius.");
        }
        this.myRadius = radius;
        return radius;
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
        return super.getName() + " [" + "Radius: " + myRadius + "] Area: " + calculateArea();
    }

    @Override
    public int compareTo(Shape o) {
        return 0;
    }
}