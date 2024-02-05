package slideswork;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ChainedExceptions {
	static Scanner inp = new Scanner(System.in);
	public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            System.out.println("Caught Exception: ");
            e.printStackTrace();
        }
    }
    public static void method1() throws Exception {
        try {
            method2();
        } catch (Exception e) {
            throw new Exception("An Exception caught in method1", e);
        }
    }
    public static void method2() throws Exception {
    	int[] rollNumbers = {60, 01, 40, 31};
    	int index = 0;
        try {
        	System.out.print("Enter the index: ");
            index = inp.nextInt();
            System.out.printf("Roll No at %d index: %d", index, rollNumbers[index]);
        }
        catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
        	throw new Exception("An Exception Occurred in Method 3", e);
        }
    }
}
