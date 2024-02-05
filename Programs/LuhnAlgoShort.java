import java.util.Scanner;
public class LuhnAlgoShort {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- Luhn Algorithm for Credit Card ---");
        System.out.print("Enter Credit Card Number: ");
        long credit = inp.nextLong();

        if (isValidCard(credit)) {
            System.out.printf("%d is Valid Card Number.", credit);
        } else {
            System.out.printf("%d is not a Valid Card Number.", credit);
        }
    }

    private static boolean isValidCard(long credit) {
        int oddSum = 0, evenSum = 0;
        if (validPrefix(credit + "")) {
            if (validLength(credit + "")) {
                while (credit > 0) {
                    int first = (int) (credit % 10);
                    oddSum += first;
                    credit /= 10;

                    int second = (int) (credit % 10);
                    second *= 2;
                    if (second > 9) {
                        second -= 9;
                    }
                    evenSum += second;
                    credit /= 10;
                }
                if ((evenSum + oddSum) % 10 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private static boolean validLength(String credit) {
        if (credit.length() >= 13 && credit.length() <= 16) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean validPrefix(String credit) {
        String prefix1 = credit.substring(0, 1);
        String prefix2 = credit.substring(0, 2);
        if (prefix1.equals("4") || prefix1.equals("5") || prefix1.equals("6") || prefix2.equals("37")) {
            return true;
        }
        return false;
    }
}