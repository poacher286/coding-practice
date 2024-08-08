package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CharMap {
    public static Map<Character, Long> charMap(String input) {
        return input.chars()
                .mapToObj(x -> (char) x)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
    }

    public static void main(String[] args) {
        String input = "POACHERPOACHER";
        System.out.println(charMap1(input));
    }

    public static Map<Character, Integer> charMap1 (String input ){
        Map<Character, Integer> map = new HashMap<>();
        for(char c : input.toCharArray()){
//            if (map.containsKey(c)) {
//                map.put(c, map.get(c)+1);
//            }else{
//                map.put(c, 1);
//            }
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
