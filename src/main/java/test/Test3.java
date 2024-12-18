package test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test3 {
    public static String betterCompression(String s) {
        // Use a TreeMap to automatically sort the characters
        Map<Character, Integer> countMap = new TreeMap<>();

        // Define a regex pattern to match characters followed by numbers
        Pattern pattern = Pattern.compile("([a-z])(\\d+)");
        Matcher matcher = pattern.matcher(s);

        // Aggregate the counts for each character
        while (matcher.find()) {
            char ch = matcher.group(1).charAt(0);
            int count = Integer.parseInt(matcher.group(2));
            countMap.put(ch, countMap.getOrDefault(ch, 0) + count);
        }

        // Build the result string
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            result.append(entry.getKey()).append(entry.getValue());
        }

        return result.toString();
    }

    public static String betterCompression2(String s){
        Map<Character, Integer> countMap = new TreeMap<>();

        for(int i = 0; i < s.length();){
            char c = s.charAt(i++);
            StringBuilder num = new StringBuilder("0");
//            while (i < s.length() && s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' < 10){
            while (i < s.length() && Character.isDigit(s.charAt(i))){
                num.append(s.charAt(i++));
            }
            countMap.put(c, countMap.getOrDefault(c, 0) + Integer.parseInt(num.toString()));
        }

        String ans = "";
        for(Map.Entry<Character, Integer> entry : countMap.entrySet()){
            ans += entry.getKey();
            ans += entry.getValue();
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "a34c25b754c5";
        System.out.println(betterCompression2(s));
    }


    /**
     * For a given array of integers, determine the maximum value in the segment from each index to the highest index element, inclusive.
     * After that has been determined, determine the number of times that highest value occurs in the segment. A number of queries will then be given, where each query represents an index within the array. Create a return array with one value for each query: the number of times the maximum value occurs in a segment starting at that index.
     * Example
     * numbers = [5, 4, 5, 3, 2]
     * q = [1, 2, 3, 4, 5]
     * Note: The numbers array indexes are from 1 to n where n is the length of the array.
     * For the first query, the index is 1. The segment starting at index 1 is [5, 4, 5, 3, 2]. The highest value is 5, and it occurs 2 times. result =
     * [2]
     * For the second query, the index is 2. The segment starting at index
     * 2 is [4, 5, 3, 2]. The highest value is 5, and it occurs 1 time.
     * result
     * = [2, 1]
     * In each of the remaining segments queried, [5, 3, 2], [3, 2], and [2], there is only one occurrence of a highest value so a 1 is appended to result for each query.
     * The final array returned is [2, 1, 1, 1, 1].
     * @param numbers
     * @param q
     * @return
     */
    public static List<Integer> frequencyOfMaxValue(List<Integer> numbers, List<Integer> q) {
        // Write your code here
        int n = numbers.size();
        List<Integer> maxFromIndex = new ArrayList<>(Collections.nCopies(n, 0));
        List<Integer> maxCountFromIndex = new ArrayList<>(Collections.nCopies(n, 0));

        // Start from the last element
        int currentMax = numbers.get(n - 1);
        int currentMaxCount = 1;
        maxFromIndex.set(n - 1, currentMax);
        maxCountFromIndex.set(n - 1, currentMaxCount);

        // Precompute max and its frequency from each index to the end
        for (int i = n - 2; i >= 0; i--) {
            if (numbers.get(i) > currentMax) {
                currentMax = numbers.get(i);
                currentMaxCount = 1;
            } else if (numbers.get(i) == currentMax) {
                currentMaxCount++;
            }
            maxFromIndex.set(i, currentMax);
            maxCountFromIndex.set(i, currentMaxCount);
        }

        // Answer each query using the precomputed values
        List<Integer> result = new ArrayList<>();
        for (int queryIndex : q) {
            // Convert 1-based index to 0-based
            result.add(maxCountFromIndex.get(queryIndex - 1));
        }

        return result;
    }
}
