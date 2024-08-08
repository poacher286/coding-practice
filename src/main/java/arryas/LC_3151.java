package arryas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class LC_3151 {
    public boolean isArraySpecial(int[] nums) {
        return IntStream.range(1, nums.length)
                .allMatch(x -> (nums[x] & 1) == 0 ^ (nums[x - 1] & 1) == 0);
    }

    public static boolean[] isArraySpecial2(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            ans[i] = IntStream.range(query[0], query[1])
                    .allMatch(x -> (nums[x] & 1) == 0 ^ (nums[x + 1] & 1) == 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,1,2,6};
        int[][] queries = {{0,4}};
        System.out.println(Arrays.toString(isArraySpecial2(nums, queries)));
    }
}
