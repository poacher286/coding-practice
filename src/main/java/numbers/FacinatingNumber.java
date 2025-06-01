package numbers;

import java.util.HashMap;
import java.util.Map;

public class FacinatingNumber {
    public static boolean isFascinating(int n) {
        int twice = n * 2;
        int thrice = n * 3;
        String s = "" + n + twice + thrice;
        Map<Character, Integer> freq = new HashMap<>();

        for(char c : s.toCharArray()){
            if(c != '0'){
                freq.put(c, freq.getOrDefault(c, 0) + 1);
                if (freq.get(c) > 1) return false;
            }
        }
        return freq.size() == 9;
    }

    public static void main(String[] args) {
        System.out.println(isFascinating(783));
    }
}
