import java.util.Scanner;

public class ChangeCountingGame {
    public static void main(String[] args) {
        Scanner money = new Scanner(System.in);

        System.out.println("        -- Change-Counting Game --");
        System.out.println("Note: You have to enter correct no. of pennies, nickels," +
                " dimes and quarters to make 1 dollar.\n      If you succeed, you'll win\n");

        System.out.print("Enter no. of pennies: ");
        short pennies = money.nextShort();

        System.out.print("Enter no. of nickels: ");
        short nickels = money.nextShort();

        System.out.print("Enter no. of dimes: ");
        short dimes = money.nextShort();

        System.out.println("Enter the no. of quarters: ");
        short quarters = money.nextShort();

        short total = (short) (pennies + nickels * 5 + dimes * 10 + quarters * 25);
        
        switch (Integer.compare(total, 100)) {
            case 0 -> System.out.println("Congratulations! You Won.");
            default -> System.out.println("Sorry, You Lost.");
        }
    }
}
