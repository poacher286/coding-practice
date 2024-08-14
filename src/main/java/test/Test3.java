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
            while (i < s.length() && s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' < 10){
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
