import java.util.Scanner;

public class Asterik {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t--- Asterik ---");
        System.out.print("Enter Size: ");
        byte size = inp.nextByte();

        for (byte outer = 0; outer < size; outer++) {
            for (byte inner = 0; inner < size; inner++) {
                if (outer == size / 2) {
                    System.out.print("* ");
                }
                else {
                    if (inner == size / 2) {
                        System.out.print("* ");
                    }
                    else if (inner == outer || inner + outer == size - 1) {
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