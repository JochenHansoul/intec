package be.jochenhansoul.StringsExcercices;

public class Opdracht6 {
    public static void main(String[] args) {
        String s1 = "hello world";
        String s2 = "hello world";

        System.out.println(s1 == s2); // gaat referentie vergelijken
        System.out.println(s1.equals(s2)); // inhoud vergelijken

        String s3 = new String("a"); // gaat niet naar de string pool
        String s4 = new String("b");
        System.out.println(s3.equals(s4));
        System.out.println(s3.compareTo(s4));
    }
}
