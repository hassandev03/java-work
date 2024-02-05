import java.util.Scanner;

public class LuhnAlgoCreditCard {
    public static void main(String[] args) {
        System.out.println("\t==============================");
        System.out.println("\t Credit Card Number Validator");
        System.out.println("\t==============================");
        Scanner inp = new Scanner(System.in);

        System.out.print("Enter Card Number: ");
        long credit = inp.nextLong();
        inp.close();

        if (validCardNumber(credit)) {
            System.out.print("Credit Card Number is Valid!");
        } else {
            System.out.print("Credit Card Number is Invalid!");
        }

    }

    public static boolean validCardNumber(long credit) {
        byte cardLength = validLength(credit);
        if (cardLength >= 13 && cardLength <= 16) {
            String cardType = cardType(Long.toString(credit));
            if (cardType != "Invalid") {
                System.out.println("Card Type: " + cardType);
                short digitSum = (short) (evenIndexSum(credit, cardLength) + oddIndexSum(credit, cardLength));

                if (digitSum % 10 == 0) {
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

    private static short oddIndexSum(long credit, byte cardLength) {
        short sum = 0;
        byte remain = 0;
        for (byte index = 1; index <= cardLength; index++) {
            remain = (byte) (credit % 10);
            credit /= 10;

            if (index % 2 != 0) {
                sum += remain;
            }
        }
        return sum;
    }

    private static short evenIndexSum(long credit, byte cardLength) {
        short sum = 0;
        byte remain = 0, digit1 = 0, digit2 = 0, digitSum = 0;
        for (byte index = 1; index <= cardLength; index++) {
            remain = (byte) (credit % 10);
            credit /= 10;

            remain *= 2;
            if (index % 2 == 0) {
                if (remain > 9) {
                    digit1 = (byte) (remain / 10);
                    digit2 = (byte) (remain % 10);
                    digitSum = (byte) (digit1 + digit2);
                    sum += digitSum;
                } else {
                    sum += remain;
                }
            }
        }
        return sum;
    }

    private static byte validLength(long credit) {
        byte cardLength = 0;
        while (credit > 0) {
            credit /= 10;
            cardLength++;
        }
        return cardLength;
    }

    public static String cardType(String creditString) {
        String cardType = "";
        if (creditString.charAt(0) == '4') {
            cardType = "Visa Card";
        } else if (creditString.charAt(0) == '5') {
            cardType = "MasterCard Credit Card";
        } else if (creditString.charAt(0) == '6') {
            cardType = "Discover Card";
        } else if (creditString.substring(0, 2) == "37") {
            cardType = "American Express Card";
        } else {
            cardType = "Invalid";
        }
        return cardType;
    }
}