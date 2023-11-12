package linkedList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class LetterCombination {
    public static List<String> letterCombinations(String digits) {
        String[] m = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> r = new LinkedList<>();
        r.add("");
        for(char d : digits.toCharArray()){
            for(int size = r.size(); size > 0; size--){
                String s = r.poll();
                m[d - '0'].chars().forEach(c -> r.add(s + (char) c));
            }
        }
        return r.size() == 1 ? Collections.emptyList() : r;
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
