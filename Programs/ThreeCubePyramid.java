import java.util.Scanner;

public class ThreeCubePyramid{
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- Three Cube Pyramid ---");
        System.out.print("Enter size: ");
        int size = inp.nextInt();

        pattern(size);
    }

    private static void pattern(int size) {
        int power;
        for (int outer = 0; outer < size; outer++) {
            power = 0;
            for (int space = outer; space < size - 1; space++) {
                System.out.print("     ");
            }
            for (int first = 0; first <= outer; first++) {
                System.out.printf("%-5d" , (int) Math.pow(3, power));
                power++;
            }
            power-=2;
            for (int second = 0; second < outer; second++){
                System.out.printf("%-5d", (int) Math.pow(3, power));
                power--;
            }
            System.out.println();
        }
        
    }
}