import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFileReading {
    public static void main(String[] args) {
        int number;
        try {
        	Scanner input = new Scanner(new File("D:\\Numbers.txt"));
            // .hasNextInt() tells whether next is integer
            while (input.hasNextInt()) {
                number = input.nextInt();
                System.out.println(number);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println(e.toString());;
        }

    double number1;
        try {
        	Scanner input = new Scanner(new File("D:\\doubleNumbers.txt"));
            while (input.hasNextDouble()) {
                number1 = input.nextDouble();
                System.out.println(number1);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println(e.toString());;
        }

    String line;
        try {
        	Scanner input = new Scanner(new File("D:\\doubleNumbers.txt"));
            while (input.hasNextLine()) {
                line = input.nextLine();
                System.out.println(line);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println(e.toString());;
        }
    }
}