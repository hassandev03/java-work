import java.util.Scanner;

public class BabylonianSqrt {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t--- Square Root Finder ---");
        System.out.print("Enter any number: ");
        float num = inp.nextFloat();

        System.out.printf("Square Root of %.2f is: %.3f", num, babylonianSqrt(num));
    }
    private static double babylonianSqrt(double sqNum) {
        double nextGuess = 1.0, lastGuess;
        do {
            lastGuess = nextGuess;
            nextGuess = (lastGuess + sqNum / lastGuess) / 2;
        } while (Math.abs(nextGuess - lastGuess) > 0.000001);
        return nextGuess;
    }
}
