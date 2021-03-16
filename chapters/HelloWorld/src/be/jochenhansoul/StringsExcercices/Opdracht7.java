package be.jochenhansoul.StringsExcercices;

public class Opdracht7 {
    public static void main(String[] args) {
        String s1 = "abd";
        String s2 = "cde";

        System.out.println(s1.equals(s2));

        System.out.println(s1.compareTo(s2)); // vergelijkt enklel asci waarden
        if (s1.compareToIgnoreCase(s2) < 0) {
            System.out.println(s1);
            System.out.println(s2);
        } else {
            System.out.println(s2);
            System.out.println(s1);
        }
    }
}
