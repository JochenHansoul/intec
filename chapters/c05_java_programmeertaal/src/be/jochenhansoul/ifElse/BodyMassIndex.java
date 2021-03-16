package be.jochenhansoul.ifElse;

public class BodyMassIndex {
    public static void main(String[] args) {
        int weight = 57;
        double length = 1.70;
        double bmi = weight / Math.pow(length, 2);
        String bmiCategory = (bmi < 20) ? "ondergewicht"
                : (bmi < 25) ? "ok"
                : (bmi < 30) ? "overgewicht"
                : (bmi < 40) ? "obesitas"
                : "ziekelijke overgewicht";
        System.out.println("Uw BMI is " + bmiCategory);
    }
}
