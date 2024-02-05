import java.util.Scanner;

public class HalfDiamond {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- Half Diamond ---");
        System.out.print("Enter the size: ");
        byte size = inp.nextByte();

        for (byte rows = 1; rows <= 2 * size - 1; rows++) {
            byte totalCol = rows <= size ? rows : (byte)(2 * size - rows);
            if (rows <= size) {
                for (byte upper = 1; upper <= totalCol; upper++) {
                    System.out.print("* ");
                }
            }
            else if (rows > size) {
                for (byte lower = 1; lower <= totalCol; lower++){
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}