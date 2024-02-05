import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) {
        System.out.println("\t --- 4-Digit Lottery Guess ---");
        Random rand = new Random();
        int lotteryNum = (int) (rand.nextInt(1000, 10000));
        System.out.println(lotteryNum);
        int guess = 0;
        int[] lotteryDigits = { lotteryNum / 1000, (lotteryNum / 100) % 10, (lotteryNum / 10) % 10, lotteryNum % 10 };
        System.out.println(Arrays.toString(lotteryDigits));

        while (true) {
            try (Scanner inp = new Scanner(System.in)) {
                System.out.print("Guess the Lottery Number: ");
                guess = inp.nextInt();

            } catch (Exception e) {
                System.out.println("Invalid Input!\n" + e.toString() + "\nAgain Enter!");
                continue;
            } finally {
                if (Integer.toString(guess).length() == 4) {
                    break;
                } else {
                    System.out.println("Invalid Length of Guessed!" + "\nAgain Enter!");
                }
            }
        }

        int[] guessDigits = { guess / 1000, (guess / 100) % 10, (guess / 10) % 10, guess % 10 };
        System.out.println(Arrays.toString(guessDigits));
        if (guess == lotteryNum) {
            System.out.println("Congratulations! You guessed the Exact Lottery Number\nYour Reward: Rs. 1000000/-");
        } else if (matchedDigits(lotteryDigits, guessDigits) == 4) {
            System.out.println(
                    "Congratulations! Your Guess matches all the digits of Lottery Number\nYour Reward: Rs. 250000/-");
        } else {
            System.out.println(
                    "Congratulations! Your Guess matches atleast one digit of Lottery Number\nYour Reward: Rs. 50000/-");
        }
    }

    private static int matchedDigits(int[] lotteryDigits, int[] guessDigits) {
        int count = 0;
        for (int guess: guessDigits) {
            for (int i = 0; i < lotteryDigits.length; i++) {
                if (guess == lotteryDigits[i] && lotteryDigits[i] != Integer.MIN_VALUE) {
                    lotteryDigits[i] = Integer.MIN_VALUE;
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}