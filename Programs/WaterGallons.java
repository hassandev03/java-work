import java.util.Scanner;

public class WaterGallons {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t--- No. of Gallons in Well ---");
        System.out.print("Enter the radius of Well Casing (in inches): ");
        float rad = inp.nextFloat();

        System.out.print("Enter the depth of Well (in feet): ");
        float feet = inp.nextFloat();

        float gallons = (float) (Math.PI * Math.pow(rad / 12, 2) * feet) * 7.48f;
        System.out.printf("No. of Gallons Stored in Well Casing: %.3f", gallons);
    }
}
