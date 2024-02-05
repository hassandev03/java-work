import java.util.Scanner;

public class FullNumTriangle {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- Full Number Triangle ---");
        System.out.print("Enter the size: ");
        byte size = inp.nextByte();

        for (byte rows = 1; rows <= size; rows++) {
            System.out.print(" ".repeat(size * 2 - rows * 2 + 1));
            for (byte first = rows; first >= 1; first--) {
                System.out.print(first + " ");
            }
            for (byte second = 2; second <= rows; second++) {
                System.out.print(second + " ");
            }
            System.out.println();
        }
    }
}
