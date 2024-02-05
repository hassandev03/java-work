import java.util.Scanner;

public class FullSquare {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t--- Full Square ---");
        System.out.print("Enter Size: ");
        int size = inp.nextInt();

        for (int outer = 1; outer <= size; outer++) {
            for (int inner = 1; inner <= size; inner++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}