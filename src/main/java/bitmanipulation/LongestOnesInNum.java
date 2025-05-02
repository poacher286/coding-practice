package bitmanipulation;

public class LongestOnesInNum {
    /**
     * Given an integer n, return the length of the longest consecutive run of 1s in its binary representation.
     * For example, given 156, you should return 3.
     */
    public static int longestOnes(int num){

        int count = 0;
        int maxCount = 0;
        while (num > 0) {
            if ((num & 1) == 1){
                count++;
                maxCount = Math.max(maxCount, count);
            }else{
                count = 0;
            }
            num = num >> 1;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(156));
    }
}
