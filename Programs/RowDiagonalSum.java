public class RowDiagonalSum {
    public static void main(String[] args) {
        int[][] array = { { 1, 2, 3, 4, 5 },
                          { 6, 7, 8, 9, 10 },
                          { 11, 12, 13, 14, 15 },
                          { 16, 17, 18, 19, 20 },
                          { 21, 22, 23, 24, 27 }
        };

        int[] returnedArray = sumArray(array);
        for (int i = 0; i < returnedArray.length - 2; i++) {
            System.out.printf("Sum of Row #%d: %d\n",i + 1,  returnedArray[i]);
        }
        System.out.println("Sum of Right Diagonal: " + returnedArray[returnedArray.length - 2]);
        System.out.println("Sum of Left Diagonal: " + returnedArray[returnedArray.length - 1]);
    }

    private static int[] sumArray(int[][] array) {
        int rightDiagonal = 0, leftDiagonal = 0, rowSum;
        int[] sumRowsDiagonals = new int[array.length + 2];
        for (int i = 0; i < array.length; i++) {
            rowSum = 0;
            for (int j = 0; j < array[i].length; j++) {
                rowSum += array[i][j];
                if (i == j) {
                    rightDiagonal += array[i][j];
                }
                if ((array[i].length - i - 1) == j) {
                    leftDiagonal += array[i][j];
                }
            }
            sumRowsDiagonals[i] = rowSum;
        }
        sumRowsDiagonals[sumRowsDiagonals.length - 1] = leftDiagonal;
        sumRowsDiagonals[sumRowsDiagonals.length - 2] = rightDiagonal;
        return sumRowsDiagonals;
    }
}
