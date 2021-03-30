package be.jochenhansoul;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Question2 {
    public static void main(String[] args) {
        int[][] matrix = new int[9][9];
        fillMatrixWithRandomNumbers(matrix, 1, 9, new Random(5));
        printMatrix(matrix);
        System.out.println("print sum columns:");;
        System.out.println(Arrays.toString(calculateSumColumn(matrix)));
        System.out.println("total sum: " + calculateSumMatrix(matrix));
    }

    public static void fillMatrixWithRandomNumbers(int[][] matrix, int min, int max, Random rand) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rand.nextInt(max - min + 1) + min;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ar : matrix) {
            System.out.println(Arrays.toString(ar));
        }
    }

    public static int[] calculateSumRow(int[][] intMatrix) {
        int[] rowAmounts = new int[intMatrix.length];
        for (int i = 0; i < intMatrix.length; i++) {
            rowAmounts[i] = Arrays.stream(intMatrix[i]).sum();
        }
        return rowAmounts;
    }

    public static int[] calculateSumColumn(int[][] intMatrix) {
        int[] columnAmounts = new int[intMatrix.length];
        for (int rowCounter = 0; rowCounter < intMatrix.length; rowCounter++) {
            for (int[] row : intMatrix) {
                columnAmounts[rowCounter] += row[rowCounter];
            }
        }
        return columnAmounts;
    }

    public static int calculateSumMatrix(int[][] intMatrix) {
        return Arrays.stream(calculateSumRow(intMatrix)).sum();
    }
}
