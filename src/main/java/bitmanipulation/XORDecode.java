package bitmanipulation;

public class XORDecode {
    /**
     * Input: encoded = [1,2,3], first = 1
     * Output: [1,0,2,1]
     * Explanation: If arr = [1,0,2,1], then first = 1 and encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
     *
     * Proprerty --> A^B = c then A^C=B
     * @param encoded
     * @param first
     * @return
     */
    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length + 1];
        res[0] = first;
        for(int i = 0; i < encoded.length; i++){
            res[i+1] = encoded[i] ^ res[i];
        }
        return res;
    }
}
