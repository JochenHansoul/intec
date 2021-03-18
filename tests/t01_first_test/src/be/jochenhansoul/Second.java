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
}
