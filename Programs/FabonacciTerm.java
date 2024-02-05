import java.util.Scanner;

public class FabonacciTerm {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- Fabonacci Term ---");
        System.out.print("Enter the term no.: ");
        int num = inp.nextInt();
        fabonacci(num);
    }

    private static void fabonacci(int num) {
        int first = 0, second = 1, next = first;
        // System.out.printf("%d, %d", first, second);
        for (int i = 3; i <= num; i++) {
            
            next = first + second;
            // System.out.printf(", %d", next);
            first = second;
            second = next;
        }
        System.out.println(next);
    }
}