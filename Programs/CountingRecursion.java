public class CountingRecursion {
    public static void main(String[] args) {;
        int n = 50;
        System.out.printf("Counting till %d is: %d", n, count(n));
    }

    private static long count(int n) {
        if (n == 1) 
            return 1;
        return n + count(n - 1);
    }
}