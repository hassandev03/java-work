import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        System.out.println("\t --- Max Row and Column Prime Nums ---");

        // get input for matrix 1
        int row1 = 3, column1 = 4;
        String message = "\t --- For Matrix A ---";
        int[][] matrix1 = getInput(row1, column1, message);
        message = "\t --- Matrix A ---";
        printMatrices(matrix1, message);

        // get input for matrix 1
        int row2 = 4, column2 = 2;
        message = "\t --- For Matrix B ---";
        int[][] matrix2 = getInput(row2, column2, message);
        message = "\t --- Matrix B ---";
        printMatrices(matrix2, message);
        
        // multiplied matrix
        int[][] multipliedMatrix = matrixMultiplication(matrix1, matrix2);
        message = "\t --- Multiplied Matrix ---";
        printMatrices(multipliedMatrix, message);
    }

    private static void printMatrices(int[][] matrix, String matrixName) {
        System.out.println(matrixName);
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int[][] matrixMultiplication(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2.length){
            System.out.println("Matrices Incompatible for multiplication!");
            return null;
        }
        else {
            int[][] multipliedMatrix = new int[matrix1.length][matrix2[0].length];

            for (int i = 0; i < multipliedMatrix.length; i++) {
            // for columns check the no. of columns in second matrix
                for (int j = 0; j < matrix2[i].length; j++) {
                    int number = 0;
            // for multiplying each elements of rows and columns, check columns of 1st matrix
                    for (int k = 0; k < matrix1[i].length; k++) {
                        number += matrix1[i][k] * matrix2[k][j];
                    }
                    multipliedMatrix[i][j] = number;
                }
            }
            return multipliedMatrix;
        }
    }

    private static int[][] getInput(int row, int column, String message) {
        System.out.println(message);
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
}
