import java.util.Scanner;

public class FabonacciSequence {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- Fabonacci Sequence ---");
        System.out.print("Enter the term no.: ");
        int num = inp.nextInt();
        fabonacci(num);
    }

    private static void fabonacci(int num) {
        int first = 0, second = 1, next = first;
        for (int i = 1; i <= num; i++) {
            System.out.printf("%d, ", next);
            
            first = second;
            second = next;
            next = first + second;
        }
    }
}