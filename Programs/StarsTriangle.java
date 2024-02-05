import java.util.Scanner;

public class StarsTriangle {
    public static void main(String[] args) {
        int length;
        Scanner size = new Scanner(System.in);

        System.out.println("        --- Stars Triangular Pattern ---");
        System.out.print("Enter the length of pattern: ");
        length = size.nextInt();
        size.close();


        // outer loop for rows (size)
        for (int i = 1; i <= length ; i++) {

            // for spaces
            for (int j = i; j <= length - 1 ; j++) {
                System.out.print(" ");
            }

            // for stars
            for (int k = 1 ; k <= (2 * i) - 1 ; k++) {  // 2 * 1 - 1 = 1 ; 2 * 2 - 1 = 3
                System.out.print("*");
            }
            System.out.println();    // next line
        }
    }
}
