public class FactorialRecursion {
    public static void main(String[] args) {;
        int number = 5;
        System.out.printf("Factorial of %d is: %d", number, factorial(number));
    }

    private static long factorial(int n) {
        if (n == 0 || n == 1) 
            return 1;
        return n * factorial(n - 1);
    }
}