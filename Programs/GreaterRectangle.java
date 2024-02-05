import java.util.Scanner;

public class GreaterRectangle {
    public static void main(String[] args) {
        float wid1, wid2, heit1, heit2, area1, area2;
        Scanner value = new Scanner(System.in);

        System.out.println("        -- Greater Triangle -- ");
        System.out.print("Note: Separate length & width by space.\n"+ 
                         "Enter length and width for Rectangle 1: ");
        heit1 = value.nextFloat();
        wid1 = value.nextFloat();

        System.out.print("Enter length and width for Rectangle 2: ");
        heit2 = value.nextFloat();
        wid2 = value.nextFloat();

        area1 = heit1 * wid1;
        area2 = heit2 * wid2;

        switch (Float.compare(area1, area2)) {
            case 1 -> System.out.printf("\nArea of Rectangle 1 with %.2f height and" + 
                                        "%.2f Width is greater.\n", heit1, wid1);
            case -1 -> System.out.printf("\nArea of Rectangle 2 with %.2f height and" + 
                                        "%.2f Width is greater.\n", heit2, wid2);
            default -> System.out.print("\nArea of both rectangles is same\n");
        }
    }
}
