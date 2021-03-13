package be.jochenhansoul.ifElse;

public class AgeCategory {
    public static void main(String[] args) {
        int age = 30;
        String ageCategory = (age < 2) ? "baby"
                : (age < 12) ? "kind"
                : (age < 18) ? "tiener"
                : "volwassene";
        System.out.println("U behoort tot de leeftijdscategorie " + ageCategory);
    }
}