package be.jochenhansoul.opdracht4;

import java.util.Scanner;

public class Scrabble {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continueGame = true;
        while (continueGame) {
            System.out.println("enter a word:");
            String word = input.nextLine();
            System.out.println(valueWord(word));
            System.out.println("continue? true/false");
            continueGame = input.nextBoolean();
            input.nextLine();
        }
        input.close();
    }

    public static int valueWord(String word) {
        int value = 0;
        for (char c : word.toUpperCase().toCharArray()) {
            value += valueLetter(c);
        }
        return value;
    }

    public static int valueLetter(char c) {
        return switch (c) {
            case 'E', 'A', 'I', 'O', 'N', 'R', 'T', 'L', 'S', 'U' -> 1;
            case 'D', 'G' -> 2;
            case 'B', 'C', 'M', 'P' -> 3;
            case 'F', 'H', 'V', 'W', 'Y' -> 4;
            case 'K' -> 5;
            case 'J', 'X' -> 8;
            case 'Q', 'Z' -> 10;
            default -> 0;
        };
    }
}
