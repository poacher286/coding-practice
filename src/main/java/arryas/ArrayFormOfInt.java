package arryas;

import java.util.LinkedList;
import java.util.List;

public class ArrayFormOfInt {
    public List<Integer> addToArrayForm(int[] num, int k) {
        String number = "";
        for (int n : num){
            number += n;
        }
        long sum = Long.parseLong(number)+k;
        String s = String.valueOf(sum);
        List<Integer> res =new LinkedList<>();
        for (char c : s.toCharArray()){
            res.add(c-48);
        }
        return res;
    }
}
