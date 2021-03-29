package be.jochenhansoul;

import java.util.Arrays;
import java.util.Random;

public class Question2 {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] intMatrix = new int[9][9];

        for (int i = 0; i < intMatrix.length; i++) {
            for (int j = 0; j < intMatrix[i].length; j++) {
                intMatrix[i][j] = random.nextInt(9) + 1;
            }
        }

        System.out.println("print sum:");;
        for (int i : calculateSumColumn(intMatrix)) {
            System.out.println(i);
        }
        System.out.println("total sum: " + calculateSumMatrix(intMatrix));
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
