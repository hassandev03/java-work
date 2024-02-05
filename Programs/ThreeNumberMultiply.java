import java.util.Scanner;

public class ThreeNumberMultiply {
    public static void main(String[] args) {
        int num1, num2, num3;
        num1 = (int) System.currentTimeMillis() % 10;
        num2 = (int) System.currentTimeMillis() / 10 % 10;
        num3 = (int) System.currentTimeMillis() / 100 % 10;

        Scanner prodInp = new Scanner(System.in);
        System.out.println("        --- Three Numbers Multiplication ---");
        System.out.print("What is " + num1 + " * " + num2 + " * " + num3 + ": ");
        int product = prodInp.nextInt();
        prodInp.close();

        int correctProduct = num1 * num2 * num3;

        if (product == correctProduct) {
            System.out.println("Congrats! You multiplied correctly.");
        }
        else {
            System.out.println("Sorry! your answer is incorrent.\n" + 
            num1 + " *" + num2 + " *" + num3 + " is: " + correctProduct);
        }
    }
}
