import java.util.Scanner;
public class X2Graph {
public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t--- X^2 Graph --- ");
        System.out.print("Enter Size: ");
        byte size = inp.nextByte();

        byte columns = (byte) (2 * size - 2);
        for (byte outer = 0; outer < size; outer++) {
            for (byte inner = 0; inner <= columns; inner++) {
                if (outer == size - 1) {
                    System.out.print("* ");
                }
                else {
                    if (inner == columns / 2) {
                        System.out.print("* ");
                    }
                    else if (inner == outer || inner + outer == columns) {
                        System.out.print("* ");
                    }
                    else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println();
        }
        
    }
}

