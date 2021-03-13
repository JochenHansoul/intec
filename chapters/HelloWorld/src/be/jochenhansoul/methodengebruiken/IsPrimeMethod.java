package be.jochenhansoul.methodengebruiken;

public class IsPrimeMethod {
    public static void main(String[] args) {
        for (int i = 1; i < 20; i++) {
            System.out.println(i + ": " + isPrime(i));
        }
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        } {
            int i = 2;
            boolean dividable = true;
            while (i < (n / 2 + 1) && dividable) {
                if (n % i == 0) {
                    dividable = false;
                }
                i++;
            }
            return dividable;
        }
    }
}
