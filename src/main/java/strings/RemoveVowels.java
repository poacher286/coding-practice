package strings;

import java.util.stream.Collectors;

public class RemoveVowels {
    public static String removeVowels(String input){
        StringBuilder output = new StringBuilder();

        String[] split = input.split("\\s+");
        for (String word : split) {
            String collect = word.toLowerCase()
                    .chars()
                    .mapToObj(x -> (char) x)
                    .filter(x -> x != 'a' && x != 'e' && x != 'i' && x != 'o' && x != 'u')
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            output.append(collect).append(" ");

        }

        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeVowels("java streams to remove vowels"));
    }
}
