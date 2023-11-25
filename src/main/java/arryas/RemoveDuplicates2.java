package arryas;

/**
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 */
public class RemoveDuplicates2 {
    public static int removeDuplicates(int[] nums) {
        int duplicateCount = 1;
        int leftPointer = 0;
        int rightPointer = 1;
        int noOfTimeSwapHappen = 0;

        //[1,1,1,2,2,3,3]

        while (leftPointer <= rightPointer && rightPointer < nums.length){
            if (nums[leftPointer] <= nums[rightPointer] && duplicateCount < 3){
                duplicateCount++;
            }else{
                //right shift leftPointer to last
                //swap elements to the right

                for (int i = leftPointer; i < nums.length - 1 - noOfTimeSwapHappen; i++) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
                noOfTimeSwapHappen++;
                duplicateCount--;
            }
            leftPointer = rightPointer;
            rightPointer++;
        }

        return nums.length - duplicateCount + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
    }
}
