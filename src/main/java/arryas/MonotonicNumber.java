package arryas;

public class MonotonicNumber {
    public static boolean isMonotonic(int[] nums) {
        return isMonotoneIncreasing(nums) || isMonotoneDecreasing(nums);
    }

    public static boolean isMonotoneIncreasing(int[] nums){
        boolean isMonoIncreasing = false;
        int leftPointer = 0;
        int rightPointer = 0;
        while (leftPointer <= rightPointer && rightPointer < nums.length){
            if (nums[leftPointer] <= nums[rightPointer]){
                leftPointer = rightPointer;
                rightPointer++;
                isMonoIncreasing = true;
            }else{
                isMonoIncreasing = false;
                break;
            }
        }
        return isMonoIncreasing;
    }

    public static boolean isMonotoneDecreasing(int[] nums){
        boolean isMonoDecreasing = false;
        int leftPointer = 0;
        int rightPointer = 0;
        while (leftPointer <= rightPointer && rightPointer < nums.length){
            if (nums[leftPointer] >= nums[rightPointer]){
                leftPointer = rightPointer;
                rightPointer++;
                isMonoDecreasing = true;
            }else{
                isMonoDecreasing = false;
                break;
            }
        }
        return isMonoDecreasing;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        System.out.println(isMonotonic(nums));
    }
}
