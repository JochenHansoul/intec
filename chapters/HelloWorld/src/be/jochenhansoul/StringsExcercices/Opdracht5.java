package be.jochenhansoul.StringsExcercices;

public class Opdracht5 {
    static char c = 'e';

    public static void main(String[] args) {

        String s = "dit is een zin met een aantal letters e in";
        // string: length()
        // charArray: length
        int counter = 0;
        /*char[] characters = s.toCharArray();
        for (char character : characters) {
            if (c == character) {
                counter++;
            }
        }*/
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
