package arryas;

/**
 * Given an array of integers nums, return the number of good pairs.
 *
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 */
public class GoodPair {
    /**
     * Approach
     * We will intiliaze ans with 0 and an empty unordered map to store the occurrence of the element
     * For each element in the given array:
     * Here there will be 2 cases
     * if element/number is present in the map that means for example at any time in unordered map we saw count of num(element) 1 is 2 thats means currunt element can form 2 pair with previous 1, so at that time we will add this count in answer and also increase the count of the element in out map
     * If element/number is not present in the map, it means this is the first time we're seeing this number, so we initialize its count to 1.
     * At last we will return our answer
     * @param a
     * @return
     */
    public static int numIdenticalPairs(int[] a) {
        int[] fr = new int[101];
        int r = 0;
        for (int n : a)
            r += fr[n]++;
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        System.out.println(numIdenticalPairs(nums));
    }
}
