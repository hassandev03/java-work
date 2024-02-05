import java.util.Scanner;

public class NumsSquare {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- Number Square ---");
        System.out.print("Enter the size: ");
        byte size = inp.nextByte();

        int origSize = size;
        size = (byte)(2 * size);
        int valAtIndex = 0;
        for (int rows = 0; rows <= size; rows++) {
            for (int cols = 0; cols <= size; cols++) {
                // value at index = min((distances from) left, right, top, bottom)
                valAtIndex = origSize - Math.min(rows, Math.min(cols, Math.min(size - rows, size - cols)));
                System.out.print(valAtIndex + " ");
            }
            System.out.println();
        }
    }

}
