package strings;


import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
    public static boolean isIsomorphic(String word, String pattern) {
        Map<Character, Character> wMap = new HashMap<>();
        Map<Character, Character> pMap = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            char b = pattern.charAt(i);

            if (wMap.containsKey(a) && wMap.get(a) != b || pMap.containsKey(b) && pMap.get(b) != a) {
                return false;
            }


            wMap.put(a, b);
            pMap.put(b, a);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));//true
        System.out.println(isIsomorphic("foo", "bar"));//false
        System.out.println(isIsomorphic("paper", "title"));//true
        System.out.println(isIsomorphic("foo", "app"));//true
    }

}
