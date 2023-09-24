package arryas;


import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class UniqueOccurrences {

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Long> mapIntCount = Arrays.stream(arr)
                .boxed()
//                .collect(Collectors.groupingBy(x -> x, Collectors.summingInt(e -> 1)));//for Map<Integer, Integer>
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        return mapIntCount.size() == mapIntCount.values().stream().distinct().count();
    }

    public static void main(String[] args) {
//        int[] arr = {1,2,2,1,1,3};
//        int[] arr = {1,2};
        int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(uniqueOccurrences(arr));
    }
}
