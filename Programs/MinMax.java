import java.util.Scanner;

public class MinMax {
    public static void main(String[] args) {
        int num, min, max;
        Scanner input = new Scanner(System.in);

        System.out.println("      --- Minimum Maximum Integer ---");
        System.out.print("Enter any integer: ");
        num = input.nextInt();
        min = num;
        max = num;

        while (true) {
            System.out.print("Enter any integer: ");
            num = input.nextInt();

            if (num < 0) {
                input.close();
                break;
            }

            else if (num > max) {
                max = num;
            }
            else if (num < min) {
                min = num;
            }
        }
        System.out.print("Minimun Number is: " + min + "\nMaximum Number is: " + max);
    }
}
