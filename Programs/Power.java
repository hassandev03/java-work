public class Power {
    public static void main(String[] args) {
        int num, expo, power;

        System.out.println("Enter first integer: ");
        num = Integer.parseInt(System.console().readLine());

        System.out.println("Enter power: ");
        expo = Integer.parseInt(System.console().readLine());

        power = 1;
        for (int i = 1; i <= expo; i++) {
            power *= num;
        }

        System.out.println("\n\t" + num + " raised to " + expo + " is: " + power);
    }
}
