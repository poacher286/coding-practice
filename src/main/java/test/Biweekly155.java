package test;

import java.util.*;

public class Biweekly155 {
    public String findCommonResponse(List<List<String>> responses) {

        List<String> list = new ArrayList<>();
        for (List<String> res : responses) {
            Set<String> uniq = new HashSet<>(res);
            list.addAll(uniq);
        }

        Map<String, Integer> freq = new HashMap<>();
        for (String str : list) {
            freq.put(str, freq.getOrDefault(str, 0) + 1);
        }

        String result = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            String res = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount || (count == maxCount && res.compareTo(result) < 0)) {
                maxCount = count;
                result = res;
            }
        }

        return result;
    }
}
