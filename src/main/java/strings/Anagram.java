package strings;

import java.util.Arrays;

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

    public static void main(String[] args) {
        String[] strings = new String[]{"act", "cat", "tac"};
        System.out.println(isAnagram(strings));
    }

}
