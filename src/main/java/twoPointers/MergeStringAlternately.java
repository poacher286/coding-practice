package twoPointers;

public class MergeStringAlternately {
    /**
     * You are given two strings word1 and word2.
     * Merge the strings by adding letters in alternating order,
     * starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
     *
     * Return the merged string.
     * @param word1
     * @param word2
     * @return
     */
    public static String mergeAlternately(String word1, String word2) {
        int first = 0;
        int second = 0;
        StringBuilder merged = new StringBuilder();
        while (first < word1.length() && second <word2.length()){
            merged.append(word1.charAt(first++)).append(word2.charAt(second++));
        }

        while (first < word1.length()){
            merged.append(word1.charAt(first++));
        }

        while (second < word2.length()){
            merged.append(word2.charAt(second++));
        }

        return merged.toString();
    }

    public static void main(String[] args) {
        String word1 = "abc", word2 = "pqr";
        System.out.println(mergeAlternately(word1, word2));
    }
}
