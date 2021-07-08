package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapOperations {

    public static List<Integer> squareNumbers(List<Integer> numbers){
        return numbers.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,4,6,7,43,55);
        System.out.println(squareNumbers(numbers));
    }
}
