import java.util.Scanner;

public class RightTriangleNumbers2 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.println("\t --- Right Triangle 2 (Numbers) ---");
        System.out.print("Enter Size: ");
        byte size = inp.nextByte();

        System.out.println();
        byte count = 1;
        for (byte outer = 1; outer <= size; outer++) {
            for (byte inner = 1; inner <= outer; inner++) {
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
    }
}
