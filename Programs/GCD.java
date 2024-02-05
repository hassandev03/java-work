import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        
        System.out.println("\t --- GCD ---");
        System.out.print("Enter 1st Number: ");
        short num1 = inp.nextShort();

        System.out.print("Enter 2nd Number: ");
        short num2 = inp.nextShort();
    
        byte remainder;
    
            do {
                remainder = (byte) (num1 % num2);
                num1 = num2;
                num2 = remainder;
            } while (remainder != 0);
    
            System.out.println("The GCD is: " + num1);
        }
    }