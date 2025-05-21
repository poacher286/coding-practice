package arryas;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KFrequentElement {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int num : nums) {
            integerMap.put(num, integerMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> integerSet = new ArrayList<>(integerMap.entrySet()
                                                           .stream()
                                                           .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                                           .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue(), (a1, a2) -> a1, LinkedHashMap::new))
                                                           .keySet());

        return IntStream.range(0, k).map(integerSet::get).toArray();
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.getValue(), a.getValue())
        );

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            heap.offer(entry);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = Objects.requireNonNull(heap.poll()).getKey();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
