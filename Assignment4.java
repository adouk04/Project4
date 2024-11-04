/*
 * Course: TCSS143 - Fundamentals of Object-Oriented Programming-Theory
 *                   and Application
 *  Name:		   Alex Douk
 *  Instructor:	Mr. Schuessler
 *  Assignment:   Programming Assignment 4
 *
 *  File Name:	Assignment4.java
 */
 
import java.util.*;
import java.io.*;

/**
 * This class demonstrates reading Shape objects from a file, 
 * sorting them, and writing the results to an output file.
 * It uses linked lists to store and manage shapes.
 *  
 * @author Alex Douk
 * @version Fall 2024
 */
public class Assignment4 {

    /**
     * The main method drives the program by reading a list of shapes from an input file,
     * copying and sorting them, and then printing both the original and sorted lists to an output file.
     *
     * @param args Command-line arguments, unused in this application.
     */
    public static void main(String[] args) {
        try {
            Scanner console = new Scanner(System.in);
            Scanner input = new Scanner(new File("in4.txt"));
            PrintStream output = new PrintStream(new File("out4.txt"));
            List<Shape> myList = new LinkedList<Shape>();
            List<Shape> copyList = getOriginalList(input, myList);

            output.println("Original List[unsorted]");
            outputList(output, myList);
            output.println();

            Collections.sort(copyList);
            output.println("Copied List[sorted]");
            outputList(output, copyList);
            output.println();

            output.println("Original List[unsorted]");
            outputList(output, myList);

            console.close();
            input.close();
            output.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    /**
     * Prints each Shape object from the list to the provided output stream.
     *
     * @param output The PrintStream to which the shapes are printed.
     * @param myList The list of shapes to be printed.
     */
    public static void outputList(PrintStream output, List<Shape> myList) {
        for (Shape shape : myList) {
            output.println(shape);
        }
    }

    /**
     * Reads shapes from the input Scanner and adds them to the specified list.
     * If the line of values matches the expected format for a shape, it creates a new
     * Shape object (Circle, Rectangle, or Triangle) and adds it to the list.
     *
     * @param input The Scanner object reading from the input file.
     * @param myList The list to which the shapes are added.
     * @return A copy of the original list for further processing.
     */
    public static List<Shape> getOriginalList(Scanner input, List<Shape> myList) {
        while (input.hasNextLine()) {
            List<Double> values = new ArrayList<>();
            String line = input.nextLine();
            Scanner lineScanner = new Scanner(line);

            while (lineScanner.hasNext()) {
                if (lineScanner.hasNextDouble()) {
                    values.add(lineScanner.nextDouble());
                } else {
                    values.clear();  
                    break;
                }
            }
            lineScanner.close();

            try {
                if (values.size() == 1) {
                    myList.add(new Circle(values.get(0)));
                } else if (values.size() == 2) {
                    myList.add(new Rectangle(values.get(0), values.get(1)));
                } else if (values.size() == 3) {
                    myList.add(new Triangle(values.get(0), values.get(1), values.get(2)));
                }
            } catch (IllegalArgumentException iAE) {
                System.out.println(iAE.getMessage());
            }
        }

        List<Shape> copyList = new ArrayList<>();
        for (Shape shape : myList) {
            copyList.add(shape.copyShape());
        }

        return copyList;
    }
}
