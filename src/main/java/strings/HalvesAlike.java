package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HalvesAlike {
    public boolean halvesAreAlike(String s) {
        int left = 0;
        int right = s.length() - 1;
        int leftCount = 0;
        int rightCount = 0;
        while(left < right){
            if(isVowel(s.charAt(left++))){
                leftCount++;
            }
            if(isVowel(s.charAt(right--))){
                rightCount++;
            }
        }
        return leftCount == rightCount;
    }

    private boolean isVowel(char c){
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i'
                || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U';
    }

    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if(entry.getValue() == 1){
                sum += entry.getKey();
            }
        }
        return sum;
    }
}
