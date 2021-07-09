package stream;

import numbers.Prime;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterOperations {

    public static <T> List<T> getCommonList(List<T> list1, List<T> list2){
        return list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());
    }

    public static List<Integer> findPrimeNumbers(List<Integer> numbers){
        return numbers.stream()
                .filter(Prime::isPrime)
                .collect(Collectors.toList());
    }

    public static int findNthLargest(List<Integer> numbers, int nth){
        return numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                .get(nth-1);
    }

    public static void main(String[] args) {
        List<String> otherCountries = Arrays.asList("Switzerland", "USA", "India", "Australia", "Pakistan", "Canada", "Nepal", "Philippines");
        List<String> sarcCountries = Arrays.asList("India", "Pakistan", "Butan", "SriLanka", "Afganistan", "Nepal");

        List<Integer> numbers = IntStream.rangeClosed(1,100).boxed().collect(Collectors.toList());
        System.out.println(findPrimeNumbers(numbers));
        System.out.println(getCommonList(otherCountries, sarcCountries));
        System.out.println(findNthLargest(numbers, 2));
    }
}
