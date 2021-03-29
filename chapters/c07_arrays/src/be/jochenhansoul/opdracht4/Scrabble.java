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
        switch (c) {
            case 'E':
            case 'A':
            case 'I':
            case 'O':
            case 'N':
            case 'R':
            case 'T':
            case 'L':
            case 'S':
            case 'U':
                return 1;
            case 'D':
            case 'G':
                return 2;
            case 'B':
            case 'C':
            case 'M':
            case 'P':
                return 3;
            case 'F':
            case 'H':
            case 'V':
            case 'W':
            case 'Y':
                return 4;
            case 'K':
                return 5;
            case 'J':
            case 'X':
                return 8;
            case 'Q':
            case 'Z':
                return 10;
            default:
                return 0;
        }
    }
}
