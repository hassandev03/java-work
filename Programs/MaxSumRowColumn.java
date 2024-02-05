import java.util.*;

public class MaxSumRowColumn {
    public static void main(String[] args) {
        System.out.println("\t --- Max Row and Column Sum ---");
        int row = 3, column = 4;
        // get input
        int[][] array = getInput(row, column);

        System.out.println("Row with Max Sum: " + maxSumRow(array));
        System.out.println("Column with Max Sum: " + maxSumColumn(array));
    }

    private static int[][] getInput(int row, int column) {
        Scanner inp = new Scanner(System.in);
        int[][] array = new int[row][column];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("Enter element #%d for row #%d: ", j + 1, i + 1);
                array[i][j] = inp.nextInt();
            }
        }
        return array;
    }

    private static int maxSumColumn(int[][] array) {
        int maxColumn = 0, maxColumnSum = Integer.MIN_VALUE;
        int columnSum;
        for (int i = 0; i < array[0].length; i++) {
            columnSum = 0;
            for (int j = 0; j < array.length; j++) {
                columnSum += array[j][i];
            }
            if (columnSum > maxColumnSum) {
                maxColumnSum = columnSum;
                maxColumn = i;
            }
        }
        return maxColumn + 1;
    }

    private static int maxSumRow(int[][] array) {
        int maxRow = 0, maxRowSum = Integer.MIN_VALUE;
        int rowSum;
        for (int i = 0; i < array.length; i++) {
            rowSum = 0;
            for (int j = 0; j < array[i].length; j++) {
                rowSum += array[i][j];
            }
            if (rowSum > maxRowSum) {
                maxRowSum = rowSum;
                maxRow = i;
            }
        }
        return maxRow + 1;
    }
} 