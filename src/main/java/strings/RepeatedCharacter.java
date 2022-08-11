package strings;

import java.util.HashSet;
import java.util.Set;

public class RepeatedCharacter {
    public char repeatedCharacter(String s) {
        Set<Character> setChar = new HashSet<>();
        for (char c: s.toCharArray()) {
            if (!setChar.add(c)) return c;
        }
        return 0;
    }
}
