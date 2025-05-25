package priorityQueue;

import java.util.*;

public class TopKFreqWord {
    /**
     * Given an array of strings words and an integer k, return the k most frequent strings.
     *
     * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
     *
     *
     *
     * Example 1:
     *
     * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
     * Output: ["i","love"]
     * Explanation: "i" and "love" are the two most frequent words.
     * Note that "i" comes before "love" due to a lower alphabetical order.
     * @param words
     * @param k
     * @return
     */
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new MyComparator());
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            pq.offer(e);
        }
        List<String> ans = new LinkedList<>();
        for (int i = 0; i <= k - 1; i++) {
            ans.add(Objects.requireNonNull(pq.poll()).getKey());
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
//        int k = 2;
        int k = 3;
        System.out.println(topKFrequent(words, k));
    }
}

class MyComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        String word1 = e1.getKey();
        int freq1 = e1.getValue();
        String word2 = e2.getKey();
        int freq2 = e2.getValue();
        if (freq1 != freq2) {
            return Integer.compare(freq1, freq2);
        } else {
            return word1.compareTo(word2);
        }
    }
}