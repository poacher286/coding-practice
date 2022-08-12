package twoPointers;

import java.util.Arrays;

public class DIStringMatch {
    /**
     * A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a string s of length n where:
     *
     * s[i] == 'I' if perm[i] < perm[i + 1], and
     * s[i] == 'D' if perm[i] > perm[i + 1].
     * Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm, return any of them.
     *
     * Approach ->
     * prem size = n+1
     * use 2 pointer left and right
     * if s[i] = 'I' -> add in prem -> left++
     * if s[i] = 'D' -> add in prem -> right--
     * add whatever left in left at the last of array
     * @param s
     * @return
     */
    public static int[] diStringMatch(String s) {
        int left = 0;
        int right = s.length();
        int[] prem = new int[s.length()+1];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') prem[i] = left++;
            else prem[i] = right--;
        }
        prem[s.length()] = left;
        return prem;
    }

    public static void main(String[] args) {
        String s = "IDID";
        System.out.println(Arrays.toString(diStringMatch(s)));
    }
}
