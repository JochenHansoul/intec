package be.jochenhansoul;

public class First {
    public static void main(String[] args) {
        int counter = 0;
        for (int i = 0; i <= 10_000; i++) {
            if (i % 2 != 0 && i % 5 != 0) {
                System.out.println(i);
                counter++;
            }
        }
        System.out.println("aantal nummers: " + counter);
    }
}
