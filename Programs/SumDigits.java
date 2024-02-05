import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        int num, remainder, sum = 0;
        String sumOfDigits = "";

        Scanner input = new Scanner(System.in);

        System.out.println("      --- Self-Digits Sum ---");
        System.out.print("Enter any Number: ");
        num = input.nextInt();
        input.close();
        int origNum = num;

        while (num != 0) {
            remainder = num % 10;
            sumOfDigits += Integer.toString(remainder) + " + ";
            sum += remainder;
            num /= 10;
        }
        sumOfDigits = reversedString(sumOfDigits);
        System.out.print("Self-Digit Sum of " + origNum + " is: " + sumOfDigits.substring(3, (sumOfDigits.length())) + " = " + sum);
    }

    public static String reversedString(String inputString) {
        StringBuilder newString = new StringBuilder();
        int length = inputString.length();

        for (int i = length - 1; i >= 0; i--) {
            newString.append(inputString.charAt(i));
        }

        return newString.toString();
    }
}
