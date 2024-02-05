import java.util.Scanner;

public class FullNumDiamond {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- Full Number Diamond ---");
        System.out.print("Enter the size: ");
        byte size = inp.nextByte();

        for (byte rows = 1; rows <= size * 2 - 1; rows++) {
            byte cols = rows <= size ? rows : (byte) (size * 2 - rows);
            if (rows <= size) {
                System.out.print(" ".repeat(size - cols));
                for (byte first = cols; first >= 1; first--) {
                    System.out.print(first);
                }
                for (byte second = 2; second <= cols; second++) {
                    System.out.print(second);
                }
            }
            else if (rows > size) {
                System.out.print(" ".repeat(size - cols));
                for (byte first = cols; first >= 1; first--) {
                    System.out.print(first);
                }
                for (byte second = 2; second <= cols; second++) {
                    System.out.print(second);
                }
            }
            System.out.println();
        }
    }
}
