package stacks;

import java.util.Stack;

public class DailyTempratures {
    /**
     * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
     * <p>
     *
     *
     * Example 1:
     * <p>
     * Input: temperatures = [73,74,75,71,69,72,76,73]
     * Output: [1,1,4,2,1,1,0,0]
     * Example 2:
     * <p>
     * Input: temperatures = [30,40,50,60]
     * Output: [1,1,1,0]
     * Example 3:
     * <p>
     * Input: temperatures = [30,60,90]
     * Output: [1,1,0]
     */
    static class Pair{
        int temp;
        int index;

        Pair(int temp, int index){
            this.temp = temp;
            this.index = index;
        }
    }

    public int[] dailyTemperatures(int[] T) {
        Stack<Pair> stack = new Stack<>();
        int[] res = new int[T.length];
        for(int i = 0; i < T.length; i++){
            while(!stack.isEmpty() && T[i] > stack.peek().temp){
                Pair p = stack.pop();//remove top ele if T[i] is warmer
                res[p.index] = i - p.index;//add in res of p.index with diff of i - p.index
            }

            stack.push(new Pair(T[i], i));
        }
        return res;
    }
}
