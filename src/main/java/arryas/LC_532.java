package arryas;

import java.util.HashSet;
import java.util.Set;

public class LC_532 {
    public int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> dupSet = new HashSet<>();
        for(int num : nums){
            if(!set.add(num)){
                dupSet.add(num);
            }
        }

        if(k == 0){
            return dupSet.size();
        }

        int pairs = 0;
        for(int num : set){
            if(set.contains(num + k)){
                pairs++;
            }
        }
        return pairs;
    }
}
