package slidingWindow;

/**
 * You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.
 *
 * You are also given an integer k, which is the desired number of consecutive black blocks.
 *
 * In one operation, you can recolor a white block such that it becomes a black block.
 *
 * Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.
 *
 *
 *
 * Example 1:
 *
 * Input: blocks = "WBBWWBBWBW", k = 7
 * Output: 3
 */
public class MinimumRecolour {
    public static int minimumRecolors(String blocks, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int minRecolour = Integer.MAX_VALUE;
        for (; right < blocks.length(); right++){
            //right operation A[right]
            if (blocks.charAt(right) == 'W'){
                count++;
            }
            for (; right - left + 1 == k; left++){
                //left operation A[left]
                minRecolour = Math.min(count, minRecolour);
                if (blocks.charAt(left) == 'W'){
                    count--;
                }
            }
        }

        return minRecolour;
    }

    public static void main(String[] args) {
        String blocks = "WBBWWBBWBW";
        int k = 7;
        System.out.println(minimumRecolors(blocks, k));
    }
}
