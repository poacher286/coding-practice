package numbers;

public class SubtractProdAndSum {
    /**
     * Input: n = 234
     * Output: 15
     * Explanation:
     * Product of digits = 2 * 3 * 4 = 24
     * Sum of digits = 2 + 3 + 4 = 9
     * Result = 24 - 9 = 15
     * @param n
     * @return
     */
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int rem = 0;
        int prod = 1;
        while(n>0){
            rem = n%10;
            sum = sum+rem;
            prod = prod*rem;
            n=n/10;
        }
        return prod-sum;
    }
}
