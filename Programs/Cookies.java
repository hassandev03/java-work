import java.util.Scanner;

public class Cookies {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t--- Cookies Storage ---");
        System.out.print("Enter the total number of cookies: ");
        int cookies = inp.nextInt();

        int boxes = cookies / 24;
        int remainingCookies = cookies % 24;

        int containers = boxes / 75;
        int remainingBoxes = boxes % 75;

        if (boxes >= 1) {
            System.out.printf("No. of Boxes to Ship the Cookies: %d%n", boxes);
            if (remainingCookies >= 1) {
                System.out.printf("No. of Left Over Cookies: %d%n", remainingCookies);
            }
        } else {
            System.out.printf("Cookies are less than required for a single Box!");
        }

        if (containers >= 1) {
            System.out.printf("No. of Containers to Ship the Cookies: %d%n", containers);
            if (remainingCookies >= 1) {
                System.out.printf("No. of Left Over Boxes: %d%n", remainingBoxes);
            }
        }

    }
}
