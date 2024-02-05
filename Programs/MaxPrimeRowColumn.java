import java.util.*;

public class MaxPrimeRowColumn {
    public static void main(String[] args) {
        System.out.println("\t --- Max Row and Column Prime Nums ---");
        int row = 3, column = 4;
        // get input
        int[][] array = getInput(row, column);

        System.out.println("Row with Max Prime Numbers: " + maxPrimeRow(array));
        System.out.println("Column with Max Prime Numbers: " + maxPrimeColumn(array));
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

    private static int maxPrimeColumn(int[][] array) {
        int maxColumn = 0, maxColumnPrime = 0;
        int columnPrimes;
        for (int i = 0; i < array[0].length; i++) {
            columnPrimes = 0;
            for (int j = 0; j < array.length; j++) {
                if (isPrime(array[j][i]))
                    columnPrimes++;
            }
            if (columnPrimes > maxColumnPrime) {
                maxColumnPrime = columnPrimes;
                maxColumn = i;
            }
        }
        return maxColumn + 1;
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        } else {
            for (int i = 2; i <= (int) Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int maxPrimeRow(int[][] array) {
        int maxRow = 0, maxRowPrime = 0;
        int rowPrimes;
        for (int i = 0; i < array.length; i++) {
            rowPrimes = 0;
            for (int j = 0; j < array[i].length; j++) {
                if (isPrime(array[i][j]))
                    rowPrimes++;
            }
            if (rowPrimes > maxRowPrime) {
                maxRowPrime = rowPrimes;
                maxRow = i;
            }
        }
        return maxRow + 1;
    }
}
