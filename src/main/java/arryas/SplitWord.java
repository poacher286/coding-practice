package arryas;

import java.util.*;
import java.util.stream.Collectors;

public class SplitWord {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        return words.stream()
                .map(word -> word.split("[" + separator + "]"))
                .flatMap(Arrays::stream)
                .filter( word -> !word.isEmpty())
                .collect(Collectors.toList());
    }

}
