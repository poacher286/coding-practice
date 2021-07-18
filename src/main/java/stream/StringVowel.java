package stream;

public class StringVowel {
    public static int countVowel(String input){
        return (int) input.toLowerCase()
                .chars()
                .filter(x -> x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u')
                .count();
    }

    public static void main(String[] args) {
        String input = "Poacher";
        String input2 = "PoAchEr";
        System.out.println(countVowel(input));
        System.out.println(countVowel(input2));
    }
}
