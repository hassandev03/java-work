import java.util.Scanner;

public class Top3Num {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int highest1 = Integer.MIN_VALUE, highest2 = Integer.MIN_VALUE,
                highest3 = Integer.MIN_VALUE, num = Integer.MIN_VALUE;

        while (true) {
            System.out.print("Enter any Integer: ");
            num = inp.nextInt();

            if (num == 0) {
                break;
            }
            else if (num > highest1) {
                highest3 = highest2;
                highest2 = highest1;
                highest1 = num;
            }
            else if (num > highest2) {
                highest3 = highest2;
                highest2 = num;
            }
            else if (num > highest3) {
                highest3 = num;
            }
        }
        System.out.printf("Three Highest Numbers: %d > %d > %d", highest1, highest2, highest3);
    }
}