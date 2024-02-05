import java.util.Scanner;

public class FabonacciRecursion {
    public static void main(String[] args) {
        int range, fabonacciNum;
        Scanner num = new Scanner(System.in);

        System.out.println("        --- Fabonacci Number ---");
        System.out.print("Enter the index of Fabonacci Term: ");
        range = num.nextInt();
        num.close();

        fabonacciNum = fabonacci(range);
        System.out.printf("The %dth Fabonacci Number for is: %d", range, fabonacciNum);
    }

    public static int fabonacci(int n) {
        if (n == 0 || n == 1) 
            return n;
        return (fabonacci(n - 1) + fabonacci(n - 2));
    }
} 