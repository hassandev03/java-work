import java.util.Scanner;

public class FloydTriangle {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- Floyd's Triangle ---");
        System.out.print("Enter Size: ");
        int size = inp.nextInt();

        int num = 1;
        for (int rows = 1; rows <= size; rows++) {
            for (int inner = 1; inner <= rows; inner++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }
}