import java.util.Scanner;

public class ArmstrongNumberSeries {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.println("      --- Armstrong Number Series ---");
        System.out.print("Enter initial point: ");
        long low = inp.nextLong();
        System.out.print("Enter initial point: ");
        long up = inp.nextLong();

        armstrongSeries(low, up);
    }
    static void armstrongSeries(long low, long up) {
        for (long run = low; run <= up; run++) {
            if (isArmstrong(run))
                System.out.println(run + " ");
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