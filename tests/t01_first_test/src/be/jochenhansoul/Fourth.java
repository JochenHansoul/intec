package be.jochenhansoul;

import java.util.Scanner;

public class Fourth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welke bewerking wilt u uitvoeren?");
        String operation = input.nextLine();
        System.out.println("eerste getal:");
        int first = input.nextInt();
        System.out.println("tweede getal:");
        int second = input.nextInt();

        if (operation.equals("som") || operation.equals("+")) {
            System.out.println(sum(first, second));
        } else if (operation.equals("aftrekken") || operation.equals("-")) {
            System.out.println(substract(first, second));
        } else if (operation.equals("vermenigvuldig") || operation.equals("*")) {
            System.out.println(multiply(first, second));
        } else {
            System.out.printf("%.2f", divide(first, second));
        }
        input.close();
    }

    public static int sum(int first, int second) {
        return first + second;
    }

    public static int substract(int first, int second) {
        return first - second;
    }

    public static int multiply(int first, int second) {
        return first * second;
    }

    public static double divide(int first, int second) {
        return (double) first / second;
    }
}
