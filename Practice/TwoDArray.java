import java.util.Arrays;
import java.util.Scanner;

public class TwoDArray {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        // in 2D arrays; internal arrays length is not mandatory
        // int[][] numsArray = new int[5][];
        
        // here we have to do bcz we have to store some values specifically
        int[][] numsArray = new int[5][3];

        // if we want to store different length internal arrays, we first have to
        // put them in outer array
        // also we know; before using array, legth must be specified
        // taking input
        for (int[] row: numsArray) {
            for (int col = 0; col < row.length; col++) {
                row[col] = inp.nextInt();
            }
        }

       
        for (int[] array: numsArray) {
            System.out.println(Arrays.toString(array));
        }
    }
}