package arryas;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class SortPeople{
    public static String[] sortPeople(String[] names, int[] heights) {
        String[] result = new String[names.length];

        TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());

        IntStream.range(0, names.length).forEach(i -> map.put(heights[i], names[i]));

        int i = 0;
        for (int h : map.keySet()) {
            result[i++] = map.get(h);
        }

        return result;
    }


    public static void main(String[] args) {
        String[] names = {"Mary","John","Emma"};
        int[] heights = {180,170,155};
        System.out.println(Arrays.toString(sortPeople(names, heights)));
    }
}
