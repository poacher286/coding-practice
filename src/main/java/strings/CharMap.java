package strings;

import java.util.Map;
import java.util.stream.Collectors;

public class CharMap {
    public static Map<Character, Long> charMap(String input) {
        return input.chars()
                .mapToObj(x -> (char) x)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
    }

    public static void main(String[] args) {
        String input = "POACHER";
        System.out.println(charMap(input));
    }
}
