import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RandomNumberStoring {
    public static void main(String[] args) {
        // how many nums user want to store
        int totalNum = totalNumbers();

        // writing numbers
        writeNumbers(totalNum);

        // showing max and min number
        showMaxMin();
    }

    private static void showMaxMin() {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, num = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("number.txt"))) {
            while (reader.ready()) {
                num = Integer.parseInt(reader.readLine().trim());
                if (num > max) {
                    max = num;
                } else if (num < min) {
                    min = num;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Expected file not found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error occured while writing to the file!");
        }
        System.out.printf("Maximum Number: %d\nMinimum Number: %d", max, min);
    }

    private static int totalNumbers() {
        int total = 0;
        while (true) {
            try (Scanner inp = new Scanner(System.in)) {
                System.out.print("How many numbers you want to store: ");
                total = inp.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input!");
                e.printStackTrace();
                continue;
            }
            // break loop if successful execution
            break;
        }
        return total;
    }

    private static void writeNumbers(int total) {
        int num = 0;
        Random randomInt = new Random();

        for (int i = 0; i < total; i++) {
            // write numbers
            try (PrintWriter writer = new PrintWriter(new FileWriter("number.txt", true))) {
                num = randomInt.nextInt(1, 101);
                writer.println(num);

                // error may occur if at system protected directory
            } catch (SecurityException e) {
                System.out.println("Don't have sufficient rights to store file at this place!");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("An Issue occured while writing number!");
                e.printStackTrace();
            }
        }
    }
}