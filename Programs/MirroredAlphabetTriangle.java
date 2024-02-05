import java.util.Scanner;

public class MirroredAlphabetTriangle {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- Mirrored Alphabet Triangle ---");
        System.out.print("Enter Size: ");
        int size = inp.nextInt();

        for (int outer = 1; outer <= size; outer++) {
            for (int inner = 1; inner <= outer; inner++) {
                System.out.print((char)(65 + size - inner + 1) + " ");
            }
            System.out.println();
        }
    }
}
