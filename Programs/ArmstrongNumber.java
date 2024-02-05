import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.println("      --- Armstrong Number ---");
        System.out.print("Enter any Integer: ");
        long num = inp.nextLong();

        if (isArmstrong(num)) {
            System.out.printf("%d is Armstrong Number.", num);
        }
        else {
            System.out.printf("%d is not an Armstrong Number.", num);
        }
    }
    static boolean isArmstrong(long number) {
        int remain = 0;
        long sum = 0, runCondition = number;

        while (runCondition > 0) {
            remain = (int) (runCondition % 10);
            sum += Math.pow(remain, 3);
            runCondition /= 10;
        }
        if (sum == number) {
            return true;
        }
        else {
            return false;
        }
    }
}