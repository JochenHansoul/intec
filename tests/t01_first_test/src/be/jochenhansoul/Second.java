package be.jochenhansoul;

public class Second {
    public static void main(String[] args) {
        int n = greatestCommonDivider(15, 30);
        System.out.println(n);
    }

    public static int greatestCommonDivider(int first, int second) {
        int lowest = Math.min(first, second);
        boolean found = false;
        while (!found && lowest > 0) {
            if (first % lowest == 0 && second % lowest == 0) {
                found = true;
            } else {
                lowest--;
            }
        }
        return lowest;
    }

    // euclidean algorithm
    /*
    Noem het grootste van de beide getallen A {\displaystyle A} A, het andere B {\displaystyle B} B.
    Trek B {\displaystyle B} B net zo vaak van A {\displaystyle A} A af totdat er 0 overblijft of een getal kleiner dan B {\displaystyle B} B ( A mod B {\displaystyle A\!\!\!\mod B} {\displaystyle A\!\!\!\mod B}).
    Als er 0 overblijft, is B {\displaystyle B} B de ggd.
    Zo niet, herhaal dan het algoritme met B {\displaystyle B} B en wat er van A {\displaystyle A} A over is.
     */
    public static int euclideanAlgorithm(int first, int second) {
        int lowest = Math.min(first, second);
        int highest = Math.max(first, second);
        while (highest >= lowest) {
            highest -= lowest;
        }
        if (highest == 0) {
            return lowest;
        } else {
            return euclideanAlgorithm(lowest, highest);
        }
    }
}
