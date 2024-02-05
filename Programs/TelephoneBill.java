import java.util.Scanner;

public class TelephoneBill {
    public static void main(String[] args) {
        int dayUsage = 0, nightUsage = 0, usage = 0;
        long account;
        float bill;
        char code;
        String teleService = "";

        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- Telephone Bill ---");
        System.out.print("Enter your Account Number: ");
        account = inp.nextLong();

        while (true) {
            System.out.print("Enter Valid Service Code: ");
            code = inp.next().charAt(0);

            if (Character.toString(code).equalsIgnoreCase("R") ||
                    Character.toString(code).equalsIgnoreCase("P")) {
                break;
            } else {
                System.out.println("Wrong Service Code!");
            }
        }

        if (Character.toString(code).equalsIgnoreCase("P")) {
            System.out.print("Enter Usage Time (in minutes) during day: ");

            dayUsage = inp.nextInt();
            System.out.print("Enter Usage Time (in minutes) during night: ");
            nightUsage = inp.nextInt();

            bill = 25.0f;
            if (dayUsage > 75) {
                bill += (float) ((nightUsage - 75) * 0.10);
            }
            if (nightUsage > 100) {
                bill += (float) ((nightUsage - 100) * 0.05);
            }
            teleService = "Premium Service";

        } else {
            System.out.print("Enter Usage Time (in minutes): ");
            usage = inp.nextInt();

            bill = 10.0f;
            if (usage > 50) {
                bill += (float) ((usage - 50) * 0.20);
            }
            teleService = "Regular Service";
        }
        System.out.printf("Account Number %d\nService Type: %s\n" +
                "Number of Minutes Service Used: %d\nAmount Due: $%.2f", account, teleService,
                usage + dayUsage + nightUsage, bill);

    }
}
