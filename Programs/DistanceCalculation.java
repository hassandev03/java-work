import java.util.Scanner;

public class DistanceCalculation {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        double distance = 0;
        System.out.println("\t --- 2D/3D Distance Calculation ---");
        System.out.println("Do you want to calculate distance in\n 2D (Enter 2D)\n 3D (Enter 3D)");
        System.out.print("Enter your Choice: ");
        String choice = inp.next().strip();

        System.out.print("Enter x1: ");
        double x1 = inp.nextDouble();

        System.out.print("Enter y1: ");
        double y1 = inp.nextDouble();

        System.out.print("Enter x2: ");
        double x2 = inp.nextDouble();

        System.out.print("Enter y2: ");
        double y2 = inp.nextDouble();

        if (choice.equalsIgnoreCase("3D")) {
            System.out.print("Enter z1: ");
            double z1 = inp.nextDouble();
            System.out.print("Enter z2: ");
            double z2 = inp.nextDouble();
            distance = calculateDistance(x1, x2, z1, y1, y2, z2);

        } else if (choice.equalsIgnoreCase("2D")) {
            distance = calculateDistance(x1, x2, y1, y2);

        } else {
            System.out.println("Wrong Choice!");
        }
        System.out.print("Distance is: " + distance);

    }

    private static double calculateDistance(double x1, double x2, double y1, double y2) {
        double distance = Math.sqrt((Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
        return distance;
    }

    private static double calculateDistance(double x1, double x2, double z1, double y1, double y2, double z2) {
        double distance = Math.sqrt((Math.pow(x2 - x1, 2) + (Math.pow(x2 - x1, 2)) + Math.pow(z2 - z1, 2)));
        return distance;
    }
}
