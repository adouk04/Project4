public abstract class AbstractShape implements Shape {
    final private String shapeName;
    public AbstractShape(String myShapeName, int myNumber) {
        this.shapeName = myShapeName + myNumber;
    }
    public String getName() {
        return this.shapeName;
    }

}
