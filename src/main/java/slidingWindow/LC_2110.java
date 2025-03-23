package slidingWindow;

public class LC_2110 {
    /**
     * You are given an integer array prices representing the daily price history of a stock, where prices[i] is the stock price on the ith day.
     *
     * A smooth descent period of a stock consists of one or more contiguous days such that the price on each day is lower than the price on the preceding day by exactly 1.
     * The first day of the period is exempted from this rule.
     *
     * Return the number of smooth descent periods.
     * @param prices
     * @return
     */
    public long getDescentPeriods(int[] prices) {
        int left = 0;
        int count = 0;

        for (int right = 0; right < prices.length; right++) {

            if (right > 0 && prices[right - 1] != prices[right] + 1) {
                left = right;
            }

            count += right - left + 1; //continue counting
        }
        return count;
    }
}
