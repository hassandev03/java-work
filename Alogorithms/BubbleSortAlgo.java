import java.util.Arrays;
import java.util.Scanner;

public class BubbleSortAlgo {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t--- Bubble Sort Algorithm ---");
        int[] numsArray = {6, 8, 10, 4, 2, 3, 12, 18, 16, 20, 14, 1, 7, 5, 9, 15, 13, 17, 11, 19};

        bubbleSort(numsArray);
        System.out.println(Arrays.toString(numsArray));
    }

    private static void bubbleSort(int[] numsArray) {
        int temp = 0;
        for (int run = numsArray.length - 1; run >= 1; run--) {
            for (int i = 0; i < run; i++){
                if (numsArray[i] > numsArray[i + 1]){
                    temp = numsArray[i + 1];
                    numsArray[i + 1] = numsArray[i];
                    numsArray[i] = temp;
                }
            }
        }
    }
}