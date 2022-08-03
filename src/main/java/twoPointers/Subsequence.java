package twoPointers;

public class Subsequence {
    /**
     * Input: s = "abc", t = "ahbgdc"
     * Output: true
     * for i = 0 to t.length
     *      if s(0) found
     *          no need to check indexes before t[a]
     * @param s - source
     * @param t - target
     * @return true if source is subsequence of target
     */
    public static boolean isSubsequence(String s, String t) {
        int s_Pointer = 0;
        int tempT = 0;
        String subT = "";
        while (s_Pointer < s.length()){
            for (int i = tempT; i<t.length(); i++) {
                if(s.charAt(s_Pointer) == t.charAt(i)) {
                    tempT = i + 1;
                    subT += t.charAt(i);
                    break;
                }
            }
            s_Pointer++;
        }
        return s.equals(subT);
    }

    public static boolean isSubsequenceOptimize(String s, String t) {
        if (s.length() == 0) return true;
        int s_Pointer = 0;
        int t_Pointer = 0;
        while (t_Pointer < t.length()) {
            if (s.charAt(s_Pointer) == t.charAt(t_Pointer)) {
                s_Pointer++;
                if (s_Pointer == s.length())
                    return true;
            }
            t_Pointer++;
        }
        return false;
    }

}
