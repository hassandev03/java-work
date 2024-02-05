import java.util.Scanner;

public class FilledSquare {
    public static void main(String[] args) {
        int length;
        Scanner size = new Scanner(System.in);

        System.out.println("        --- Filled Square ---");
        System.out.print("Enter the length of pattern: ");
        length = size.nextInt();
        size.close();

        for (int i = 1; i <= length ; i++) {
            for (int j = 1; j <= length ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

