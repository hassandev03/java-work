import java.util.Scanner;

public class HollowTriangle {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t--- Hollow Triangle ---");
        System.out.print("Enter size: ");
        int size = inp.nextInt();

        hollowTriangle(size);
    }

    private static void hollowTriangle(int size) {
        for (int outer = 0; outer < size; outer++) {
            for (int inner = 0; inner < 2 * size - 1; inner++) {
                if (outer == size - 1) {
                    System.out.print("* ");
                } else {
                    if (inner + outer == size - 1 || inner - outer == size - 1) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println();
        }
    }
}