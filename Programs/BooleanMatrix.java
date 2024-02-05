import java.util.Scanner;

public class BooleanMatrix {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- Square Boolean Matrix ---");
        System.out.print("Enter Size: ");
        int size = inp.nextInt();

        booleanPattern(size);
    }

    private static void booleanPattern(int size) {
        int index = 0;
        for (int rows = 1; rows <= size; rows++) {
            for (int columns = 1; columns <= size; columns++) {
                index = (int) (Math.random() * 2);
                System.out.print(index + " "); 
            }
            System.out.println();
        }
    }
}
