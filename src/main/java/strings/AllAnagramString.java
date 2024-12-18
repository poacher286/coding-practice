package strings;

import java.util.*;

public class AllAnagramString {
    /**
     * Given two strings s and p,
     * return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
     *
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     *
     * Approach
     * s.length() < p.length() -> return null
     * p -> sort
     * s -> substring with p.length
     * substring -> sort
     * check substring == p
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) return ans;

        char[] ch = p.toCharArray();
        Arrays.sort(ch);
        for (int i = 0; i <= s.length() - p.length(); i++) {
            char[] subChar = s.substring(i, p.length() + i).toCharArray();
            Arrays.sort(subChar);

            if (Arrays.equals(ch, subChar))
                ans.add(i);
        }
        return ans;
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) return ans;

        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> pCount = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            pCount.put(p.charAt(i), pCount.getOrDefault(p.charAt(i), 0) + 1);
            sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (pCount.equals(sCount)){
            ans.add(0);
        }

        int left = 0;
        for (int right = p.length(); right < s.length(); right++) {
            sCount.put(s.charAt(right), sCount.getOrDefault(s.charAt(right), 0) + 1);
            sCount.put(s.charAt(left), sCount.get(s.charAt(left)) - 1);
//            sCount[s.charAt(left) - 'a']--;

            //invalid
            if (sCount.get(s.charAt(left)) == 0) {
                sCount.remove(s.charAt(left));
            }

            left++;
            if (pCount.equals(sCount)) {
                ans.add(left);
            }

        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "abab", p = "ab";
        System.out.println(findAnagrams2(s, p));
    }
}
