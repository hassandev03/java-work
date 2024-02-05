import java.util.Arrays;
import java.util.Scanner;

public class RaggedArray {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- Ragged Array and Element Finding ---");

        // create and fill array
        int[][] raggedArray = arrayCreation(inp);

        // // display array
        // for (int[] numsAray : raggedArray) {
        //     System.out.println(Arrays.toString(numsAray));
        // }
        
        System.out.print("Enter Element you want to find: ");
        int number = inp.nextInt();
        // find element
        findNumber(number, raggedArray);
    }

    private static void findNumber(int number, int[][] raggedArray) {
        int index = -1, internalArrayIndex = 0;
        for (int i = 0; i < raggedArray.length; i++) {
            for (int j = 0; j < raggedArray[i].length; j++) {
                if (raggedArray[i][j] == number) {
                    index = j;
                    internalArrayIndex = i + 1;
                }
            }
        }
        if (index == -1) {
            System.out.println("Element not Found!");
        } else {
            System.out.printf("Element found at internal Array #%d at index: %d", internalArrayIndex, index);
        }
    }

    private static int[][] arrayCreation(Scanner inp) {
        int length = 0;
        System.out.print("Enter size of Ragged Array: ");
        int size = inp.nextInt();
        int[][] raggedArray = new int[size][];

        for (int i = 0; i < raggedArray.length; i++) {
            System.out.printf("Enter the length of internal array #%d: ", i + 1);
            length = inp.nextInt();
            raggedArray[i] = new int[length];

            for (int j = 0; j < raggedArray[i].length; j++) {
                System.out.printf("Enter Element #%d for Internal Array #%d: ", j + 1, i + 1);
                raggedArray[i][j] = inp.nextInt();
            }
        }
        return raggedArray;
        
    }
}