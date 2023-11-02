package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Acronym {
    public static boolean isAcronym(List<String> words, String s) {
        return s.equals(words.stream()
                                .map(x -> x.charAt(0))
                                .map(String::valueOf)
                                .collect(Collectors.joining()));
    }

    public static void main(String[] args) {
//        List<String> words = Arrays.asList("alice", "bob", "charlie");
        List<String> words = Stream.of("alice", "bob", "charlie")
                .collect(Collectors.toList());
        String s = "abc";
        System.out.println(isAcronym(words, s));
    }
}
