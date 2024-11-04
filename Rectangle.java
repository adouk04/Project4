public class Rectangle  extends AbstractShape {
    private double myLength;
    private double myWidth;
    private static int myID;

    public Rectangle() {
        this(1.0, 1.0);
    }
    public Rectangle(final double myLength, final double myWidth) {
        super("Rectangle", ++myID);
        if (myLength <= 0 || myWidth <= 0) {
            myID--; // Decrement myID before throwing exception
            throw new IllegalArgumentException("ERROR! Negative or 0 value can't be applied to a rectangle.");
        }
        this.myLength = myLength;
        this.myWidth = myWidth;
    }
    public void setLength(final double theLength) {
        if (theLength <= 0) {
            throw new IllegalArgumentException("ERROR! Negative or 0 value can't be applied to a rectangle.");
        }
        this.myLength = theLength;
    }

    public void setWidth(final double theWidth) {
        if (theWidth <= 0) {
            throw new IllegalArgumentException("ERROR! Negative or 0 value can't be applied to a rectangle.");
        }
        this.myWidth = theWidth;
    }

    public double calculateArea() {
        return myLength * myWidth;
    }

    public final Shape copyShape() {
        return new Rectangle(myLength, myWidth);
    }

    public String toString() {
        return String.format("%s [Length: %.2f, Width: %.2f] Area: %.2f", super.getName(), myLength, myWidth, calculateArea());

    }
}
