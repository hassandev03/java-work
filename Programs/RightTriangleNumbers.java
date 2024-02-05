import java.util.Scanner;

public class RightTriangleNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\t --- Right Triangle (Numbers) ---");
        System.out.print("Enter size: ");
        byte size = input.nextByte();

        System.out.println();
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
