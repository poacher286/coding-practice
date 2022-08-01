package strings;

import java.util.Set;
import java.util.TreeSet;

public class Panagram {
    public boolean checkIfPangram(String sentence) {
        Set<Character> chars = new TreeSet<>();
        for(char c : sentence.toCharArray())
            chars.add(c);
        return chars.size()==26;
    }
}
