package arryas;

public class Shuffle {
    /**
     * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
     *
     * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        for(int i = 0; i< n; i++){
            res[i*2] = nums[i]; //Even places
            res[i*2+1] = nums[n+i]; //odd places
        }
        return res;
    }
}
