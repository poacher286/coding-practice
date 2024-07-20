package arryas;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 */
public class FindDuplicates {
    public static int findDuplicate(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();
        for (int num : nums) {
            if (!integerSet.add(num)) {
                return num;
            }
        }
        return -1;
    }

    /**
     * Take the array [1,3,4,2][1,3,4,2][1,3,4,2] as an example, the index of this array is [0,1,2,3][0, 1, 2, 3][0,1,2,3], we can map the index to the nums[n]nums[n]nums[n].
     *
     * 0→1→3→2→4→3→20 \to 1 \to 3 \to 2 \to 4 \to 3 \to 20→1→3→2→4→3→2
     *
     * Start from nums[n]\textit{nums}[n]nums[n] as a new index, and so on, until the index exceeds the bounds. This produces a sequence similar to a linked list.
     *
     * 0→1→3→2→4→null0 \to 1 \to 3 \to 2 \to 4 \to null0→1→3→2→4→null
     *
     * If there are a repeated numbers in the array, take the array [1,3,4,2,2][1,3,4,2,2][1,3,4,2,2] as an example,
     *
     * 0→1→3→2→4→3→2→4→20 \to 1 \to 3 \to 2 \to 4 \to 3 \to 2 \to 4 \to 20→1→3→2→4→3→2→4→2
     *
     * Similarly, a linked list is like that:
     *
     * 0→1→3→2→4→2→4→2→…0 \to 1 \to 3 \to 2 \to 4 \to 2 \to 4 \to 2 \to \dots0→1→3→2→4→2→4→2→…
     * @param nums
     * @return
     */
    public static int findDuplicateCycleDetect(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        int slow2 = nums[0];
        while(slow != slow2){
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
        System.out.println(findDuplicateCycleDetect(nums));
    }
}
