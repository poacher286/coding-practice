package bitmanipulation;

import org.junit.jupiter.api.Test;
import strings.Reverse;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AllPossibleSubSetsTest {

    @Test
    void possibleSet() {
        char[] a = {
                'A',
                'B',
                'C',
                'D'
        };
        System.out.println(AllPossibleSubSets.possibleSubSet(a, 4));
        assertTrue(AllPossibleSubSets.possibleSubSet(a, 4).size() > 5);
    }

    @Test
    void possibleSetPalindrome() {
        char[] a = {
                'A',
                'B',
                'C',
                'D',
                'A'
        };
        System.out.println(AllPossibleSubSets.possibleSubSet(a, 5));
        assertTrue(AllPossibleSubSets.possibleSubSet(a, 5).size() > 5);
        System.out.println(AllPossibleSubSets.possibleSubSet(a, 5)
                                   .stream()
                                   .filter(Reverse::isPalindromeString)
                                   .distinct()
                                   .takeWhile(x -> !x.isEmpty())
                                   .collect(Collectors.toList()));
    }

}