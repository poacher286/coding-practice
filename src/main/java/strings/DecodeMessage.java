package strings;

import java.util.HashMap;
import java.util.Map;

public class DecodeMessage {
    public static String decodeMessage(String key, String message) {
        Map<Character, Character> charMap = new HashMap<>();
        key = key.replaceAll("\\s+", "");
        for(int i = 0; i < key.length(); i++){
            charMap.putIfAbsent(key.charAt(i), (char)('a'+charMap.size()));
        }
        charMap.put(' ', ' ');

        char[] ans = new char[message.length()];
        for(int i = 0; i < message.length(); i++) {
            ans[i] = charMap.get(message.charAt(i));
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv";
        System.out.println(decodeMessage(key, message));
    }
}
