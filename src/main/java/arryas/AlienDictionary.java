package arryas;

import java.util.*;
import java.util.stream.Collectors;

public class AlienDictionary {
    public static boolean isAlienSorted(String[] words, String order) {

        Comparator<String> comparator = (str1, str2) -> {
            for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
                char a = str1.charAt(i);
                char b = str2.charAt(i);
                if (a != b) {
                    if (order.indexOf(a) > order.indexOf(b)) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }

            return Integer.compare(str1.length(), str2.length());
        };

        List<String> collect = Arrays.stream(words).sorted(comparator).collect(Collectors.toList());

        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(collect.get(i))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"hello","leetcode"};
        String  order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));
    }
}
