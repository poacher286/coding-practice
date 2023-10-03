package arryas;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Merge2DArray {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> m = new TreeMap<>();
        Arrays.stream(nums1)
                .forEach(n -> m.put(n[0], n[1]));
        Arrays.stream(nums2)
                .forEach(n -> m.put(n[0], m.getOrDefault(n[0], 0) + n[1]));
        return m.keySet().stream().map(k -> new int[]{
                k,
                m.get(k)
        }).toArray(int[][]::new);
    }
}
