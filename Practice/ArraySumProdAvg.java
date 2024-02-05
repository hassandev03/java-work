import java.util.Scanner;

public class ArraySumProdAvg {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        byte range;

        while (true) {
            System.out.print("How many integers you want to enter? ");
            range = num.nextByte();
            
            if (range >= 1) {
                break;
            }
            else {
                System.out.println("Wrong range!");
            }
        }
        sumProdAvg(range);
    }

    static void sumProdAvg(byte range) {
        int[] numArray = new int[range];
        byte count = 0;
        long sum = 0L, product = 1L;
        
        while (count < range) {
            numArray[count] = Integer.parseInt(System.console().readLine("Enter Integer %d: ", count+1));
            sum += numArray[count];
            product *= numArray[count];
            count++;
        }
        float avg = sum / numArray.length;
        System.out.println("Sum is: " + sum + "\nProduct is: " + product +
                            "\nAverage is: " + avg);
    }
}
