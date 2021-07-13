package stream;

import java.util.*;
import java.util.stream.Collectors;

public class Duplicate {
    public static <T> Set<T> findDuplicatesSet(List<T> nums) {
        Set<T> sets = new HashSet<>();

        return nums.stream()
                .filter(x -> !sets.add(x))
                .collect(Collectors.toSet());
    }

    public static <T> Set<T> findDuplicateByFrequency(List<T> nums) {
        return nums.stream()
                .filter(x -> Collections.frequency(nums, x) > 1)
                .collect(Collectors.toSet());
    }

    public static <T> Set<T> findDuplicateGroupingBy(List<T> nums) {
        return nums.stream()
                .collect(Collectors.groupingBy(t -> t, Collectors.counting()))
                // create a map {1=1, 2=1, 3=2, 4=2, 5=1, 7=1, 9=2}
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 1, 1, 43, 6, 3, 5, 3, 5, 3, 2, 56, 6, 8);
        System.out.println(findDuplicatesSet(nums));
        System.out.println(findDuplicateByFrequency(nums));
        System.out.println(findDuplicateGroupingBy(nums));
    }
}
