public class PrimeNumberRecursion {
    public static void main(String[] args) {;
        int number = 15299;
        System.out.printf("%d is Prime? %b", number, isPrime(number));
    }

    static int i = 2;
    private static boolean isPrime(int number) {
        if (number == 2) 
            return true;
        else if (number == i)
            return true;
        else if (number < 0 || number % i == 0)
            return false;
        i++;
        return isPrime(number);
    }

    
}