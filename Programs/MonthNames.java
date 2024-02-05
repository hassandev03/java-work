import java.util.Scanner;

public class MonthNames {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the radius of the circle
        System.out.print("Enter the radius of the circle: ");
        
        // Read the radius as a float from the user
        float radius = scanner.nextFloat();

        // Close the scanner since we don't need it anymore
        scanner.close();

        // Calculate the area of the circle
        float area = 3.1415926f * radius*radius;

        // Display the result
        System.out.println("The area of the circle with radius " + radius + " is " + area);
    }
}

