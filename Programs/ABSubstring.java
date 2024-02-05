import java.util.Scanner;

public class ABSubstring {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- A to B Substrings Checker ---");
        System.out.print("Enter any String:");
        String str = inp.nextLine().toUpperCase();

        int startA = -1, nextA,startB, nextB, substringCount = 0;
        while (true) {
            nextA = str.indexOf("A", startA + 1);
            startB = nextA;
            if (nextA == -1) {
                break;
            }
            while (true) {
                nextB = str.indexOf("B", startB + 1);
                if (nextB == -1) {
                    break;
                }
                substringCount++;
                startB = nextB;
            }
            startA = nextA;
        }
        System.out.printf("Total substrings from A to B are: %d", substringCount);
    }
}