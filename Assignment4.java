import java.util.*;
import java.io.*;

public class Assignment4 {
    public static void main(String[] args) {
        try {
            Scanner console = new Scanner(System.in);
            Scanner input = new Scanner(new File("in4.txt"));
            PrintStream output = new PrintStream(new File("out4.txt"));

            List<Shape> myList = new LinkedList<Shape>();
            List<Shape> copyList = getOriginalList(input, myList);

            // Output original list (unsorted)
            output.println("Original List[unsorted]");
            outputList(output, myList);
            output.println();

            // Sort and output the copyList
            Collections.sort(copyList);
            output.println("Copied List[sorted]");
            outputList(output, copyList);
            output.println();

            // Output original list again to verify it remains unsorted
            output.println("Original List[unsorted]");
            outputList(output, myList);

            console.close();
            input.close();
            output.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public static void outputList(PrintStream output, List<Shape> myList) {
        for (Shape shape : myList) {
            output.println(shape);
        }
    }

    public static List<Shape> getOriginalList(Scanner input, List<Shape> myList) {
        while (input.hasNextLine()) {
            List<Double> values = new ArrayList<>();
            String line = input.nextLine();
            Scanner lineScanner = new Scanner(line);

            // Populate values if the line contains only doubles
            while (lineScanner.hasNext()) {
                if (lineScanner.hasNextDouble()) {
                    values.add(lineScanner.nextDouble());
                } else {
                    values.clear();  // Invalidate the line if non-double data is found
                    break;
                }
            }
            lineScanner.close();

            try {
                // Construct the appropriate Shape and add to the list
                if (values.size() == 1) {
                    myList.add(new Circle(values.get(0)));
                } else if (values.size() == 2) {
                    myList.add(new Rectangle(values.get(0), values.get(1)));
                } else if (values.size() == 3) {
                    myList.add(new Triangle(values.get(0), values.get(1), values.get(2)));
                }
            } catch (IllegalArgumentException iAE) {
                // Print the exception message to the console as per requirements
                System.out.println(iAE.getMessage());
            }
        }

        // Deep copy myList to copyList as an ArrayList
        List<Shape> copyList = new ArrayList<>();
        for (Shape shape : myList) {
            copyList.add(shape.copyShape());
        }

        return copyList;  // Return the defensive copy as ArrayList
    }
}
