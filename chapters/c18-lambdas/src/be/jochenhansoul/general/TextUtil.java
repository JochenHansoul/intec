package be.jochenhansoul.general;

public interface TextUtil {
    static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
