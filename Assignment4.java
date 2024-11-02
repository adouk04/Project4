import java.util.*;
import java.io.*;
public class Assignment4 {
    public static void main(String[] args) {
        try {
            Scanner console = new Scanner(System.in);
            Scanner input = new Scanner(new File("in4.txt"));
            PrintStream output = new PrintStream(new File("out4.txt"));

            LinkedList<Shape> shapes = new LinkedList<>();
            List<Shape> myList = new LinkedList<Shape>( ); // use this
            List<Shape> copyList = getOriginalList(input, myList); // use this and return arraylist
            //Sort the copyList and print out the myList,
            // copyList, and then myList again by calling your output method 3 times.
            //To further demonstrate the power and flexibility of inheritance,
            // polymorphism, and abstract classes, instantiate
            //your “copy” List as an ArrayList, have all methods that receive a
            // List declare the parameter as List<Shape>.
            //Because your LinkedList and an ArrayList both implement List,
            // either type can be sent to your output method
            //and used without changing any code.
            List<Shape> newList = new ArrayList<Shape>();
            for (Shape element : myList) {
                Shape s = element.copyShape();
                newList.add(s);
            }
            return newList;
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
    //get a count for each double in a line
    //Decompose main by calling methods that input data into the List and output the List
    //e sure to use a
    //try/catch block inside the input of data method.
    // The try section should call an appropriate class to instantiate
    //an object (Circle, Rectangle, Triangle) passing the
    // appropriate data for the radius, or sides, respectively.
    //If the
    //constructor of the class discovers inappropriate data,
    // it should throw a new IllegalArgumentException
    //(described above in each shape class). The exception,
    // in turn, will be caught in the catch section of the
    //try/catch block and will print to the console an
    // appropriate error message when an exception is thrown. The
    //program should not terminate but instead, continue to the next line of input
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
