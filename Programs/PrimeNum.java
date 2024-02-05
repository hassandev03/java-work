import java.util.Scanner;

public class PrimeNum {
    public static void main(String[] args) {
        long num = 0;
        boolean isPrime = true;
        Scanner input = new Scanner(System.in);

        System.out.println("      --- Prime Number Identifier ---");
        System.out.print("Enter any integer: ");
        num = input.nextLong();
        input.close();

        if (num <= 1)
            isPrime = false;
            
        else {
            for (int div = 2; div * div <= num ; div++) {
                if (num % div == 0) {
                    isPrime = false;
                    break;
            }
        }
    }
        if (isPrime){
            System.out.printf("%d is Prime Number.", num);
        }
        else {
            System.out.printf("%d is Not Prime Number", num);
        }
    }
}

