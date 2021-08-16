package be.jochenhansoul.forstatement;

public class Opdracht17c {
    public static void main(String[] args) {
        for (int i = 1; i < 100_000; i *= 11) {
            System.out.println(i);
        }
    }
}
