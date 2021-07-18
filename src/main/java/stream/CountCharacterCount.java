package stream;

import java.util.stream.Collectors;

public class CountCharacterCount {
    public static int countChar(String input, char ch){
        return input.chars()
                .mapToObj(x -> (char) x)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .get(ch)
                .intValue();
    }

    public static void main(String[] args) {
        String input = "JAVA";
        System.out.println(countChar(input, 'A'));
    }
}
