package twoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
 *
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 *
 * Return a list of integers representing the size of these parts.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 */
public class PartitionLabels {
    public static List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> lastIndexCharMap = new HashMap<>();
        for (int i = s.length() - 1; i >=0 ; i--) {
            if (!lastIndexCharMap.containsKey(s.charAt(i))) {
                lastIndexCharMap.put(s.charAt(i), i);
            }
        }

        int minLen = 0;
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            int lastIndxOfI = lastIndexCharMap.get(s.charAt(i));
            minLen = Math.max(minLen, lastIndxOfI);
            count++;
            if (i == minLen){
                result.add(count);
                count = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
}
