import java.util.Scanner;

public class Emirp {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter starting range: ");
        int start = inp.nextInt();

        System.out.print("Enter ending range: ");
        int end = inp.nextInt();

        int reverseN = 0;
        for (int i = start; i <= end; i++) {
            if (prime(i)) {
                reverseN = reverse(i);
                if (prime(reverseN)){
                    System.out.println(reverseN);
                }
            }
        }
    }

    private static int reverse(int i) {
        int reverse = 0, remain = 0;
        while (i > 0) {
            remain = i % 10;
            reverse = reverse * 10 + remain;
            i /= 10;
        }
        return reverse;
    }

    private static boolean prime(int i) {
        if (i <= 1) {
            return false;
        }
        else {
            for (int div = 2; div <= Math.sqrt(i); div++) {
                if (i % div == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}