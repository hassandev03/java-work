import java.util.Scanner;

public class SandClockPattern {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- SandClock Pattern ---");
        System.out.print("Enter Size: ");
        byte size = inp.nextByte();

        System.out.println();
        for (byte upperHalf = 1; upperHalf <= size; upperHalf++) {
            System.out.print(" ".repeat(upperHalf));
            for (byte inner = upperHalf; inner <= size; inner++) {
                System.out.print(inner + " ");
            }
            System.out.println();
        }
        for (byte lowerHalf = (byte) (size - 1); lowerHalf >= 1; lowerHalf--) {
            System.out.print(" ".repeat(lowerHalf));
            for (byte inner = lowerHalf; inner <= size; inner++) {
                System.out.print(inner + " ");
            }
            System.out.println();
        }
    }
}