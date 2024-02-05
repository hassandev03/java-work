public class PowerRecursion {
    public static void main(String[] args) {;
        int number = 16, power = 3;
        System.out.printf("%d raised to power %d is: %d", number,power, Power(number, power));
    }

    private static long Power(int n, int p) {
        if (p == 0) {
            return 1;
        }
        return n * Power(n, p - 1);
    }
}