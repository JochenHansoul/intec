package be.jochenhansoul.whileCase;

public class Opdracht16a {
    public static void main(String[] args) {
        int i = 120;
        while (i > 100) {
            System.out.println(i); // dit is eigenlijk ons werk
            --i;
        }

        // tien keer "hallo" afdrukken
        int j = 0;
        while (i < 10) {
            System.out.println("hallo"); // hier is dit duidelijk ons werkpaard
            j++;
        }

        // dit is beter
        for (int k = 120; i > 100; i--) {
            System.out.println(k);
        }
    }
}
