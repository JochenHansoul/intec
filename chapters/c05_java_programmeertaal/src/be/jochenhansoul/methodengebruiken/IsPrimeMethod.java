package be.jochenhansoul.methodengebruiken;

import java.util.Scanner;

public class IsPrimeMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        for (int i = -2; i < 10; i++) {
            try {
                if (isPrime(i)) {
                    counter++;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(counter);
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        } else if (n > 1) {
            int i = 2;
            boolean dividable = true;
            while (i < (n / 2 + 1) && dividable) {
                if (n % i == 0) {
                    dividable = false;
                } else {
                    i++;
                }
            }
            return dividable;
        } else {
            throw new IllegalArgumentException("Number may not be lower then one");
        }
    }
}
