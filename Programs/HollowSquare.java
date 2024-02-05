import java.util.Scanner;

public class HollowSquare {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t--- Hollow Square ---");
        System.out.print("Enter Size: ");
        int size = inp.nextInt();

        for (int outer = 1; outer <= size; outer++) {
            for (int inner = 1; inner <= size; inner++) {
                if (outer == 1 || outer == size) {
                    System.out.print("* ");
                }
                else {
                    if (inner == 1 || inner == size) {
                        System.out.print("* ");
                    }
                    else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println();
        }
    }
}