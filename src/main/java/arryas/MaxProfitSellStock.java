package arryas;

public class MaxProfitSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for(int price : prices) {
            if(price < minPrice) minPrice = price;
            if(price - minPrice > profit) profit = price - minPrice;
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;

        while (right < prices.length) {
            if (prices[right] > prices[left]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            }else{
                left = right;
            }
            right++;
        }
        return maxProfit;
    }

    public static int maxProfit3(int[] prices){
        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;
        for (int price : prices) {
            min_price = Math.min(min_price, price);
            int curr_profit = price - min_price;
            max_profit = Math.max(max_profit, curr_profit);
        }
        return max_profit;
    }
}
