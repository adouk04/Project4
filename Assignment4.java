import java.util.*;
import java.io.*;
public class Assignment4 {
    public static void main(String[] args) {
        try {
            Scanner console = new Scanner(System.in);
            Scanner input = new Scanner(new File("in4.txt"));
            PrintStream output = new PrintStream(new File("out4.txt"));

            //everything for the original list
            LinkedList<Shape> myList = new LinkedList<>();
            while (input.hasNextLine()) {
                addShape(myList, input.nextLine());
            }
            output.println("Original List [unsorted]:");
            for (Shape shape : myList) {
                output.println(shape);
            }
            ArrayList<Shape> newList = new ArrayList<Shape>();


            //LinkedList<Shape> copyList = getOriginalList(input, myList);


//            output.println("Original List[unsorted] of Size = " + myList.size() + ":");
//            outputList(output, myList);
//            Collections.sort(copyList);
//            output.println("Copied List[unsorted] of Size = " + copyList.size() + ":");
//            outputList(output, copyList);
//            output.println("Original List[unsorted] of Size = " + myList.size() + ":");
//            outputList(output, myList);

            // closes all scanner and printstream
            console.close();
            input.close();
            output.close(); // Close output to finalize file writing
            /**Sort the copyList and print out the myList,
             // copyList, and then myList again by calling your output method 3 times.
             //To further demonstrate the power and flexibility of inheritance,
             // polymorphism, and abstract classes, instantiate
             //your “copy” List as an ArrayList, have all methods that receive a
             // List declare the parameter as List<Shape>.
             //Because your LinkedList and an ArrayList both implement List,
             // either type can be sent to your output method
             //and used without changing any code.*/

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
    public static void outputList(PrintStream output, LinkedList<Shape> myList) {
        ;
    }

    public ArrayList<Shape> getOriginalList (LinkedList<Shape> myList) {
        ArrayList<Shape> newList = new ArrayList<Shape>();
        for (Shape element : myList) {
            Shape s = element.copyShape();
            newList.add(s);
        }
        return newList;
    }

    public static void addShape (LinkedList<Shape> list, String line) {
        Scanner lineScanner = new Scanner(line);
        List<Double> values = new ArrayList<>();
        while (lineScanner.hasNext()) {
            if (lineScanner.hasNextDouble()) {
                values.add(lineScanner.nextDouble());
            }
            else {
                return;
            }
        }
        if (values.size() == 1) {
            try {
                list.add(new Circle(values.get(0)));
            }
            catch (IllegalArgumentException iAE){
                System.out.println(iAE);
            }
        }
        else if (values.size() == 2) {
            try {
                list.add(new Rectangle(values.get(0), values.get(1)));
            }
            catch (IllegalArgumentException iAE){
                System.out.println(iAE);
            }
        }
        else if (values.size() == 3) {
            try {
                list.add(new Triangle(values.get(0), values.get(1), values.get(2)));
            }
            catch (IllegalArgumentException iAE){
                System.out.println(iAE);
            }
        }
    }
}
