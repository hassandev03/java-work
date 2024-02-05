import java.util.Scanner;

public class MagicDate {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.println("       -- Magic Date --\n");
        System.out.print("Enter month (in numeric): ");
        byte month = inp.nextByte();
        System.out.print("Enter day of month (in numeric): ");
        byte day = inp.nextByte();
        System.out.print("Enter Year (two-digit): ");
        byte year = inp.nextByte();

        switch (Integer.compare(day*month, year)) {
            case 0 -> System.out.println("Magic Date!");
            default -> System.out.println("Not Magic Date!");
        }
    }
}
