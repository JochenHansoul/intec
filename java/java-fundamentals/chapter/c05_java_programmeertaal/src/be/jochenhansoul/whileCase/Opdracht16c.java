package be.jochenhansoul.whileCase;

public class Opdracht16c {
    public static void main(String[] args) {
        int i = 1;
        while (i < 10_000) {
            System.out.println(i);
            i *= 5;
        }

        /*double i = 1;
        double powOfFive = Math.pow(i, 5);
        while (powOfFive < 10_000) {
            System.out.println((int) powOfFive);
            powOfFive = Math.pow(++i, 5);
        }*/
    }
}
