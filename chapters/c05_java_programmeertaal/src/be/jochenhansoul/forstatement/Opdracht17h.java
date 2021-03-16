package be.jochenhansoul.forstatement;

public class Opdracht17h {
    public static void main(String[] args) {
        int count = 0;
        for (int n = 2; n < 1000; n++) {
            int i = 2;
            boolean dividable = true;
            while (i < (n / 2 + 1) && dividable) {
                if (n % i == 0) {
                    dividable = false;
                }
                i++;
            }
            if (dividable) {
                System.out.println(n);
                count++;
            }
        }
        System.out.println("amount of numbers printed: " + count);
    }
}
