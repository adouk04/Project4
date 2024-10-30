import java.util.*;
import java.io.*;
public class Assignment4 {
    public static void main(String[] args) {
        try {
            Scanner console = new Scanner(System.in);
            Scanner input = new Scanner(new File("in4.txt"));
            PrintStream output = new PrintStream(new File("out4.txt"));

            LinkedList<Shape> shapes = new LinkedList<>();

            while (input.hasNextLine()) {
                addShape(shapes, input.nextLine());
            }

            output.println("Original List [unsorted]:");
            for (Shape shape : shapes) {
                output.println(shape);
            }

            console.close();
            input.close();
            output.close(); // Close output to finalize file writing

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public static void addShape (LinkedList<Shape> list, String line) {
        Scanner lineScanner = new Scanner(line);
        List<Double> values = new ArrayList<>();

        while (lineScanner.hasNextDouble()) {
            values.add(lineScanner.nextDouble());
        }

        if (values.size() == 1) {
            list.add(new Circle(values.get(0)));
        }
        else if (values.size() == 2) {
            list.add(new Rectangle(values.get(0), values.get(1)));
        }
        else if (values.size() == 3) {
            list.add(new Triangle(values.get(0), values.get(1), values.get(2)));
        }
    }

    //unsorted original list

    //method 1 circle
    // read line
    // see how many doubles are in that line
    // if 1 then it's radius of a circle

    //method 2 rectangle
    // read line
    // see how many doubles are in that line
    // if 2 then it's the length and width of rectangle

    //method 3 triangle
    // read line
    // see how many doubles are in that line
    // if 3 then it's the sides of a triangle

    //copied list sorted by the area
}
