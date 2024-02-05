import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println("\t --- Palindrome Integer ---");
        int num = 0, reversedNum = 0;
        while (true) {
            try (Scanner inp = new Scanner(System.in)) {
                System.out.print("Enter any integer: ");
                num = inp.nextInt();
                break;

            } catch (Exception e) {
                System.out.println("Invalid Input!\n" + e.toString());
                continue;
            }
        }
        int temp = num, remainder = 0;
        while (temp > 0) {
            remainder = temp % 10;
            reversedNum = reversedNum * 10 + remainder;
            temp /= 10;
        }
        if (reversedNum == num) {
            System.out.println(num + " is a Palindrome Integer!");
        } else {
            System.out.println(num + " is not a Palindrome Integer!");
        }
    }
}
