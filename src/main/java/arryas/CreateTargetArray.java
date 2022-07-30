package arryas;

import java.util.ArrayList;
import java.util.List;

public class CreateTargetArray {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target1 = new int[nums.length];
        List<Integer> target = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            target.add(index[i], nums[i]);
        }
        for (int i = 0; i < target.size(); i++){
            target1[i] = target.get(i);
        }
        return target1;
    }
}
