package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static boolean isAnagram(String[] str) {
        //sort the string
        //compare the string
        char[] ch = str[0].toCharArray();
        Arrays.sort(ch);
        String first = Arrays.toString(ch);

        int count = 1;
        for (int i = 1; i < str.length; i++) {
            char[] chars = str[i].toCharArray();
            Arrays.sort(chars);
            if (first.equals(Arrays.toString(chars))) {
                count++;
            } else {
                break;
            }
        }
        return count == str.length;
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();

        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }

        // Check if any character has non-zero frequency
        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram1(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"act", "cat", "tac"};
        System.out.println(isAnagram(strings));
    }

}
