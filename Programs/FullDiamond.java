import java.util.Scanner;

public class FullDiamond {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- Full Diamond ---");
        System.out.print("Enter the size: ");
        byte size = inp.nextByte();

        for (byte rows = 1; rows <= 2 * size - 1; rows++) {
            byte totCol = rows <= size ? rows : (byte) (2 * size - rows);
            if (rows <= size) {
                // spaces
                System.out.print(" ".repeat(size - rows));
                // stars
                for (byte upper = 1; upper <= totCol; upper++) {
                    System.out.print("* ");
                }
            }
            else if (rows > size) {
                System.out.print(" ".repeat(rows - size));
                for (byte lower = 1; lower <= totCol ; lower++) {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
