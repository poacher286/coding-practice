package twoPointers;

public class ConcatinationOfTwoNumber {
    public static long findTheArrayConcVal(int[] nums) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        long sum = (nums.length & 1) == 0 ? 0 : nums[nums.length/2];
        //[7,52,2,4]
        while (leftPointer < rightPointer){
            String concat = nums[leftPointer] + String.valueOf(nums[rightPointer]);
            sum += Long.parseLong(concat);
            leftPointer++;
            rightPointer--;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {5,14,13,8,12};
        System.out.println(findTheArrayConcVal(nums));
    }
}
