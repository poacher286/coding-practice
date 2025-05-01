package test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PracticeProblem4 {
    /**
     * The goal of this exercise is to convert a string to a new string
     * where each character in the new string is "(" if that character appears only once in the original string,
     * or ")" if that character appears more than once in the original string.
     * Ignore capitalization when determining if a character is a duplicate.
     *
     * Examples
     * "din"      =>  "((("
     * "recede"   =>  "()()()"
     * "Success"  =>  ")())())"
     * "(( @"     =>  "))(("
     */
    public static String encodeString(String str){
        str = str.toLowerCase();
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Build encoded string
        String res = "";
        for (char c : str.toCharArray()) {
            res += freq.get(c) == 1 ? '(' : ')';
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(encodeString("din"));
        System.out.println(encodeString("recede"));
        System.out.println(encodeString("Success"));
        System.out.println(encodeString("(( @"));
    }
}
