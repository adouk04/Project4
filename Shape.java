public interface Shape extends Comparable<Shape>{
    public double calculateArea(); // This abstract method is implemented at the concrete level.
    public Shape copyShape(); // also implemented at the concrete level.
    public String getName(); // implemented in AbstractShape
}
