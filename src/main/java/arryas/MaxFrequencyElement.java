package arryas;

import java.util.HashMap;
import java.util.Map;

public class MaxFrequencyElement {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxFreq = Integer.MIN_VALUE;
        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }
        int count = 0;
        for (int ele : map.values()) {
            if (ele == maxFreq){
                count += ele;
            }
        }
        return count;
    }
}
