import java.util.Scanner;

public class ProductWithoutAsterik {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- Product Without * sign ---");

        System.out.print("Enter number 1: ");
        int num1 = inp.nextInt();

        System.out.print("Enter number 2: ");
        int num2 = inp.nextInt();

        System.out.printf("Product of %d and %d is: %d", num1, num2, prod(num1, num2));
    }

    private static int prod(int num1, int num2) {
        if (num1 < 0 && num2 < 0) {
            num1 = -num1;
            num2 = -num2;
        }
        else if (num1 < 0) {
            num2 = -num2;
        }
        else if (num2 < 0) {
            num1 = -num1;
        }
        int prod = 0;
        for (int times = 1; times <= Math.abs(num2); times++ ) {
            prod += num1;
        }
        return prod;
    }
}