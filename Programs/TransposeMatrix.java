import java.util.Arrays;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] array = { { 1, 2, 3, 4, 5 },
                          { 6, 7, 8, 9, 10 },
                          { 11, 12, 13, 14, 15 },
                          { 16, 17, 18, 19, 20 },
                          { 21, 22, 23, 24, 25 }
        };
       transpose(array);
    }

    private static void transpose(int[][] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array[i].length; j++) {
                temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }
        for (int[] arrays : array) {
            System.out.println(Arrays.toString(arrays));
        }
    }
}
