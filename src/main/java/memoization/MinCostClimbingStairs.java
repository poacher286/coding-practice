package memoization;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int first = cost[0];
        int second = cost[1];
        for(int i=2;i<cost.length;i++)
        {
            int temp = Math.min(first,second)+cost[i];
            first=second;
            second=temp;
        }
        return Math.min(first,second);
    }
}
