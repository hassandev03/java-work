import java.util.Scanner;

public class IncreasingNumPattern {
    public static void main(String[] args) {
        int length;
        Scanner size = new Scanner(System.in);

        System.out.println("        --- Numeric Triangular Pattern ---");
        System.out.print("Enter the length of pattern: ");
        length = size.nextInt();
        size.close();

        for (int i = 1; i <= length ; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
