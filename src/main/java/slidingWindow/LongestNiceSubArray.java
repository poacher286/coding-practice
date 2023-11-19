package slidingWindow;

public class LongestNiceSubArray {
    public int longestNiceSubarray(int[] a){
        int r = 1, and = 0;
        for(int i = 0, j = 0; j < a.length; j++){
            while((and & a[j]) > 0)
                and ^= a[i++];
            and |= a[j];
            r = Math.max(r, j - i + 1);
        }
        return r;
    }
}
