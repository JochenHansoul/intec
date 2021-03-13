package be.jochenhansoul.methodengebruiken;

public class IsPrimeMethod {
    public static void main(String[] args) {
        for (int i = -2; i < 8; i++) {
            try {
                System.out.println(i + ": " + isPrime(i));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        } else if (n > 1){
            int i = 2;
            boolean dividable = true;
            while (i < (n / 2 + 1) && dividable) {
                if (n % i == 0) {
                    dividable = false;
                }
                i++;
            }
            return dividable;
        } else {
            throw new IllegalArgumentException("Number may not be lower then one");
        }
    }
}
