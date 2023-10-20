package strings;

/**
 * Your laptop keyboard is faulty, and whenever you type a character 'i' on it, it reverses the string that you have written. Typing other characters works as expected.
 *
 * You are given a 0-indexed string s, and you type each character of s using your faulty keyboard.
 *
 * Return the final string that will be present on your laptop screen.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "string"
 * Output: "rtsng"
 */
public class FaultyKeyboard {
    public static String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()){
            if (ch == 'i'){
                sb.reverse();
                continue;
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "poiinter";
        System.out.println(finalString(s));
    }
}
