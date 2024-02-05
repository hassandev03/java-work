import java.util.Scanner;

public class ReverseFullTriangle {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.println("\t --- Reverse Triangle (Numbers) ---");
        System.out.print("Enter Size: ");
        byte size = inp.nextByte();

        System.out.println();
        for (int outer = 1; outer <= size; outer++) {

            for (int space = 1; space <= outer; space++) {

                System.out.print(" ");
            }
            for (int nums = outer; nums <= size; nums++) {
                System.out.print(nums + " ");
            }
            System.out.println();
        }
    }
}