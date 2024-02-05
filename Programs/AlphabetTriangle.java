import java.util.Scanner;

public class AlphabetTriangle {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- Alphabet Triangle ---");
        System.out.print("Enter Size: ");
        int size = inp.nextInt();

        for (int outer = 0; outer < size; outer++) {
            for (int inner = 0; inner <= outer; inner++) {
                System.out.print((char)(65 + inner) + " ");
            }
            System.out.println();
        }
    }
}
