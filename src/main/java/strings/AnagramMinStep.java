package strings;

import java.util.HashMap;
import java.util.Map;

public class AnagramMinStep {
    public static int minSteps(String s, String t) {
        Map<Character, Integer> freqaMap = new HashMap<>();

        //count for s
        for (char cS : s.toCharArray()) {
            freqaMap.put(cS, freqaMap.getOrDefault(cS, 0) + 1);
        }

        //check for t
        //decrease 1 for each character
        for (char cT : t.toCharArray()) {
            freqaMap.put(cT, freqaMap.getOrDefault(cT, 0) - 1);
        }

        //check the values abs diff from 0
        int count = 0;
        for (int val : freqaMap.values()) {
            count += Math.abs(val);
        }

        //The positive value comes from the character in t that needs to be replaced,
        //the negative value comes from the character in s that waits for the corresponding replacement in t
        //hence dividing by 2
        return count / 2;
    }

    public static void main(String[] args) {
        String s = "bab", t = "aba";
        System.out.println(minSteps(s, t));
    }
}
