import java.util.Scanner;

public class XSquareGraph {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- X^2 Graph ---");
        System.out.print("Enter size");
        byte size = inp.nextByte();

        byte outerRange = (byte) (size - 1);
        byte innerRange = (byte) (outerRange * 2);
        System.out.println();
        for (byte outer = 0; outer <= outerRange; outer++) {
            for (byte inner = 0; inner <= innerRange; inner++) {
                if (outer == outerRange) {
                    System.out.print("* ".repeat(innerRange / 2 + innerRange / 4));
                        break;
                }
            
                if ((inner == outer ) || (inner + outer == innerRange) || inner == outerRange) {
                    System.out.print("* ");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
