package strings;

public class EncryptedString {
    public static String getEncryptedString(String s, int k) {
        int rem = s.length() % k;
        String last = "";
        String front = "";
        front = s.substring(s.length() - rem);
        last = s.substring(0, s.length() - rem);
        return front + last;
    }

    public static void main(String[] args) {
        String s = "dart";
        int k = 3;
        System.out.println(getEncryptedString(s, k));
    }
}
