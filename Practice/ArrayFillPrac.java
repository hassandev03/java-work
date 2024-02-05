import java.util.Scanner;

public class ArrayFillPrac {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        byte range;

        while (true) {
            System.out.print("How many integers you want to enter? ");
            range = num.nextByte();
            
            if (range <= 20 && range >=1) {
                break;
            }
            else {
                System.out.println("Wrong range!");
            }
        }
        int[] returnedArray = arrayFiller(range);
        arrayPrinter(returnedArray); 
    }

    static void arrayPrinter(int[] nums){
        System.out.println("\nElements of Array are: ");
        for (int i: nums) {
            System.out.print(i + " ");
        }
    }

    static int[] arrayFiller(byte range){
        int[] numArray = new int[range];
        byte count = 0;

        while (count < range) {
            numArray[count] = Integer.parseInt(System.console().readLine("Enter Integer %d: ", count+1));
            count++;
        }
        return numArray;
    }
}
