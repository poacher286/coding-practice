package arryas;

public class DiffuseBomb {
    /**
     * You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array code of length of n and a key k.
     *
     * To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.
     *
     * If k > 0, replace the ith number with the sum of the next k numbers.
     * If k < 0, replace the ith number with the sum of the previous k numbers.
     * If k == 0, replace the ith number with 0.
     * As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].
     *
     * Given the circular array code and an integer key k, return the decrypted code to defuse the bomb!
     *
     *
     *
     * Example 1:
     *
     * Input: code = [5,7,1,4], k = 3
     * Output: [12,10,16,13]
     * Explanation: Each number is replaced by the sum of the next 3 numbers. The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.
     */
    public int[] decrypt(int[] code, int k) {
        int l = code.length;
        int[] ans = new int[l];
        if (k == 0) {
            return ans;
        }

        for (int i = 0; i < l; i++) {
            if (k > 0) {//code = [5,7,1,4], k = 3
                // If k is greater than 0, store the sum of next k numbers.
                //For each j from i + 1 to i + k:
                //Add code[j % code.length] to result[i].
                for (int j = i + 1; j < i + k + 1; j++) {
                    ans[i] += code[j % l];
                }
            } else {// code = [2,4,9,3], k = -2
                // If k is less than 0, store the sum of previous -1*k numbers.
                //For each j from i - |k| to i - 1:
                //Add code[(j + code.length) % code.length] to result[i].
                for (int j = i + k; j < i; j++) {
                    ans[i] += code[(j + l) % l];
                }
            }
        }
        return ans;
    }
}
