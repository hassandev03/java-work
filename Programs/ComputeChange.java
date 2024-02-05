import java.util.Scanner;

public class ComputeChange {
    public static void main(String[] args) {
        float amount;
        Scanner amt = new Scanner(System.in);

        System.out.println("        --- Change Computer ---");
        System.out.print("Enter any amount in floating(e.g. 31.33): ");
        amount = amt.nextFloat();
        amt.close();

        int remainingAmount = Math.round(amount * 100);
        int dollars = remainingAmount / 100;
        remainingAmount =  remainingAmount % 100;

        int quarters = remainingAmount / 25;
        remainingAmount %= 25;

        int dimes = remainingAmount / 10;
        remainingAmount %= 10;

        int nickels = remainingAmount / 5;
        remainingAmount %= 5;

        int pennies = remainingAmount;

        System.out.println("Your amount consists of: ");

        if (dollars > 0) {
            if (dollars > 1) {
                System.out.println(dollars + " dollars.");
            }
            else {
                System.out.println(dollars + " dollar.");
            }
        }
        if (quarters > 0) {
            if (quarters > 1) {
                System.out.println(quarters + " quarters.");
            }
            else {
                System.out.println(quarters + " quarter.");
            }
        }
        if (dimes > 0) {
            if (dimes > 1) {
                System.out.println(dimes + " dimes.");
            }
            else {
                System.out.println(dimes + " dime.");
            }

        }
        if (nickels > 0) {
            if (nickels > 1) {
                System.out.println(nickels + " nickels.");
            }
            else {
                System.out.println(nickels + " nickel.");
            }
        }
        if (pennies > 0) {
            if (pennies > 1) {
                System.out.println(pennies + " pennies.");
            }
            else {
                System.out.println(pennies + " penny.");
            }
        }
    }
}
