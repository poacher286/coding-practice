package stream;

import java.util.*;
import java.util.stream.Collectors;

public class CustomCompare {

    public static void main(String[] args) {
        List<String> input = Arrays.asList("MONDAY", "SATURDAY", "FRIDAY", "TUESDAY", "SUNDAY", "WEDNESDAY");
//        input.sort(new DaysSort());
//        System.out.println(input);
        System.out.println(sortDays(input));
    }

    private static List<String> sortDays(List<String> input) {
        return input.stream()
                .sorted((o1, o2) -> new DaysSort().compare(o1, o2))
                .collect(Collectors.toList());
    }

    public static class DaysSort implements Comparator<String> {

        private final Map<String, Integer> daysMap = new HashMap<>();

        public DaysSort() {
            daysMap.put("SUNDAY", 0);
            daysMap.put("MONDAY", 1);
            daysMap.put("TUESDAY", 2);
            daysMap.put("WEDNESDAY", 3);
            daysMap.put("THURSDAY", 4);
            daysMap.put("FRIDAY", 5);
            daysMap.put("SATURDAY", 6);
        }

        @Override
        public int compare(String o1, String o2) {
            return daysMap.get(o1)
                    .compareTo(daysMap.get(o2));
        }
    }
}
