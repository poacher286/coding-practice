package strings;

import java.util.*;
import java.util.stream.Collectors;

public class SortCharacterByFreq {
    /**
     * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
     *
     * Return the sorted string. If there are multiple answers, return any of them.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "tree"
     * Output: "eert"
     * Explanation: 'e' appears twice while 'r' and 't' both appear once.
     * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for(char c : s.toCharArray()){
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        LinkedHashMap<Character, Integer> collect = charMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue(), (a1, a2) -> a1, LinkedHashMap::new));

        String ans = "";

        for(Map.Entry<Character, Integer> entry : collect.entrySet()){
            for(int i = 0; i < entry.getValue(); i++){
                ans += entry.getKey();
            }
        }

        return ans;
    }
}
