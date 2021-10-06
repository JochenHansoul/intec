package be.jochenhansoul.opdracht1;

public class Opdracht5 {
    public static void main(String[] args) {
        long[] primes = new long[10_000];
        for (int i = 0; i < primes.length; i++) {
            if (i == 0) {
                primes[i] = 2;
            } else {
                long n = primes[i - 1] + 1;
                while (!isPrime(n)) {
                    n++;
                }
                primes[i] = n;
            }
        }
        for (long n : primes) {
            System.out.println(n);
        }
    }

    public static boolean isPrime(long n) {
        if (n == 1) {
            return false;
        } else if (n > 1){
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
