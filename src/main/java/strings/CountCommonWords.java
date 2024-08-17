package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountCommonWords {
    /**
     * Given two string arrays words1 and words2,
     * return the number of strings that appear exactly once in each of the two arrays.
     *
     *
     *
     * Example 1:
     *
     * Input: words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
     * Output: 2
     * @param words1
     * @param words2
     * @return
     */
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> mapW1 = new HashMap<>();
        Map<String, Integer> mapW2 = new HashMap<>();
        List<String> distinctWord = new ArrayList<>();
        int count = 0;

        for (String word : words1) {
            mapW1.put(word, mapW1.getOrDefault(word, 0) + 1);
        }

        for (String word : words2) {
            mapW2.put(word, mapW2.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : mapW1.entrySet()) {
            if (entry.getValue() == 1) {
                distinctWord.add(entry.getKey());
            }
        }

        for (String word : distinctWord) {
            if (mapW2.containsKey(word) && mapW2.get(word) == 1){
                count++;
            }
        }

        return count;
    }
}
