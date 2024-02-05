import java.util.Scanner;

public class FullTriangle {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.println("\t --- Full Triangle (Stars) ---");
        System.out.print("Enter size: ");
        byte size = inp.nextByte();

        System.out.println();
        for (int outer = 1; outer <= size; outer++) {
            for (int spaces = 1; spaces <= size * 2 - outer * 2; spaces++){
                System.out.print(" ");
            }
            for (int innr = 1; innr <= outer * 2 - 1; innr++){

                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
