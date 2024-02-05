import java.util.Scanner;

public class RightTriangle {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("\t --- Right Triangle (Stars) ---\n");
        System.out.print("Enter size: ");
        byte size = inp.nextByte();
        inp.close();

        System.out.println();
        for (int outer = 1; outer <= size; outer++){
            System.out.print(" ".repeat(size * 2 - outer * 2));
            System.out.println("* ".repeat(outer));
        }
    }
}