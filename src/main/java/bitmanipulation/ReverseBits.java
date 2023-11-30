package bitmanipulation;

public class ReverseBits {
    public int reverseBits(int n) {
        int r = 0;
        for(int i = 0; i < 32; i++, n >>= 1)
            r = (r << 1) | (n & 1);
        return r;
    }
}
