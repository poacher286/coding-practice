package binarysearch;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        return benarySearch(1, n);
    }

    private int benarySearch(int left, int right) {
        if (left > right) return left;
        int mid = left + (right - left) / 2;

        return isBadVersion(mid) ?
                benarySearch(left, mid - 1) :
                benarySearch(mid + 1, right);
    }

    private boolean isBadVersion(int version) {
        //simulate a method
        //checking version is even
        return (version & 1) == 0;
    }
}
