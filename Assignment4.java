import java.util.*;
import java.io.*;
public class Assignment4 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(new File("in4.txt"));
             PrintStream output = new PrintStream(new File("out4.txt"))) {
            //Scanner console = new Scanner(System.in);
            //Scanner input = new Scanner(new File("in4.txt"));
            //PrintStream output = new PrintStream(new File("out4.txt"));

            //everything for the original list
            LinkedList<Shape> myList = new LinkedList<>();
            LinkedList<Shape> copyList = getOriginalList(input, myList);
            ArrayList<Shape> newList = new ArrayList<Shape>();

            output.println("Original List[unsorted] of Size = " + myList.size() + ":");
            outputList(output, myList);
            output.println("");
            Collections.sort(copyList);
            output.println("Copied List[sorted] of Size = " + copyList.size() + ":");
            outputList(output, copyList);
//            output.println("Original List[unsorted] of Size = " + myList.size() + ":");
//            outputList(output, myList);

//            console.close();
//            input.close();
//            output.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public static void outputList(PrintStream output, LinkedList<Shape> myList) {
        for (Shape shape : myList) {
            output.println(shape);
        }
    }

    public static LinkedList<Shape> getOriginalList(Scanner input, LinkedList<Shape> myList) {
        while(input.hasNextLine()) {
            List<Double> values = new ArrayList<>();
            String line = input.nextLine();
            Scanner lineScanner = new Scanner(line);
            while (lineScanner.hasNext()) {
                if (lineScanner.hasNextDouble()) {
                    values.add(lineScanner.nextDouble());
                }
                else {
                    values.clear();
                    break;
                }
            }
            lineScanner.close();
            try {
                if (values.size() == 1) {
                    myList.add(new Circle(values.get(0)));
                }
                else if (values.size() == 2) {
                    myList.add(new Rectangle(values.get(0), values.get(1)));
                }
                else if (values.size() == 3) {
                    myList.add(new Triangle(values.get(0), values.get(1), values.get(2)));
                }
            }
            catch (IllegalArgumentException iAE){
                System.out.println(iAE);
            }
        }
        return myList;
    }
}
