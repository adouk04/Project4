import java.util.*;
import java.io.*;
public class Assignment4 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        Scanner input = new Scanner(new File("in4.txt"));
        System.out.println("Original List[unsorted]:");
        while (input.hasNext()) {
            System.out.println(input.nextLine());
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
