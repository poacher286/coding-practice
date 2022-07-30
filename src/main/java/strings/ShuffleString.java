package strings;

public class ShuffleString {
    /**
     * You are given a string s and an integer array indices of the same length. The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
     *
     * Return the shuffled string.
     * @param s
     * @param indices
     * @return
     */
    public String restoreString(String s, int[] indices) {
        char[] shuffle = new char[s.length()];
        for(int i=0; i<s.length(); i++){
            shuffle[indices[i]] = s.charAt(i);
        }
        return String.valueOf(shuffle);
    }

}
