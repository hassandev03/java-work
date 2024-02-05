import java.util.Scanner;

public class StrictDivisors {
    public static void main(String[] args) {
        int num, sum = 1;
        String strictDivisors = "1";
        Scanner numInpt = new Scanner(System.in);

        System.out.println("Sum of Strict Divisors");
        System.out.print("Enter any integer: ");
        num = numInpt.nextInt();
        numInpt.close();

        for (int divisor = 2 ; divisor <= num/2 ; divisor++) {
            if (num % divisor == 0) {
                strictDivisors += " + " + Integer.toString(divisor);
                sum += divisor;
            }
        }

        System.out.print("Sum of Strict Divisors of " + num + " is:\n" + 
                            strictDivisors +" = " + sum);
    }
}