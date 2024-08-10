package arryas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortByFreq {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> {
                    int freqA = freq.get(a);
                    int freqB = freq.get(b);
                    if (freqA != freqB) {
                        return Integer.compare(freqA, freqB); // Ascending order by frequency
                    } else {
                        return Integer.compare(b, a); // Descending order by value
                    }
                })
                .mapToInt(x -> x)
                .toArray();

    }
}
