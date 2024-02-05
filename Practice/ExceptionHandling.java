import java.io.IOException;
import java.util.Scanner;

public class ExceptionHandling {
    static Scanner inp = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        // throwing an exception
        // raiseExp();

        // check exception
        checkExp();
        

        // priority of exceptions
        // superclass exception cannot be before any of its subclass

        try {
            // any code
        }
        // 
        catch (ArrayIndexOutOfBoundsException exp) {
            System.out.println(exp.toString());
        }
        catch (RuntimeException exp) {
            System.out.println(exp.toString());
        }
    }
    
    private static void checkExp() {
        int num1 = 5, num2 = 0;
        try {
            method();
        }
        // IOException is checked exception; so either throw it through method
        // or if in try catch; try catch code must contain such code with throws checked excep.
        catch (IOException exp) {
           exp.printStackTrace();
        }
    }
    private static void method2() throws Exception {
        raiseExp();
    }
    private static void raiseExp() throws Exception {
        System.out.println("Throwing simple Exception");
        int age = 7;

        if (age > 21 || age < 15) {
            throw new Exception("You are not eligible for job");
        }
        else if (15 <= age && age <= 21){
            System.out.println("You're eligible...");
        }
    }
}
