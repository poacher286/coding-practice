package twoPointers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LastStoneWeight {
    /**
     * You are given an array of integers stones where stones[i] is the weight of the ith stone.
     *
     * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
     *
     * If x == y, both stones are destroyed, and
     * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
     * At the end of the game, there is at most one stone left.
     *
     * Return the weight of the last remaining stone. If there are no stones left, return 0.
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int len = stones.length - 1;
        for (int i = len; i > 0; i--) {
            if (stones[i] == stones[i - 1]) {
                stones[i - 1] = Integer.MAX_VALUE;
                stones[i] = Integer.MAX_VALUE;
                i--;
            } else {
                stones[i - 1] = Math.abs(stones[i] - stones[i - 1]);
                stones[i] = Integer.MAX_VALUE;
            }
            Arrays.sort(stones);
        }
        return stones[0] == Integer.MAX_VALUE ? 0 : stones[0];
    }

    public int lastStoneWeightRecurssion(int[] stones) {
        if (stones.length == 1) return stones[0];
        Arrays.sort(stones);
        int res = stones[stones.length - 1] - stones[stones.length - 2];
        int[] newarr = new int[stones.length - 1];
        int ind = 0;
        for (int i = 0; i < stones.length - 2; i++) {
            newarr[ind] = stones[i];
            ind++;
        }
        newarr[ind] = res;
        return lastStoneWeightRecurssion(newarr);
    }


    public int lastStoneWeightPriorityQueue(int[] stones) {
        //decreasing Priority queue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            priorityQueue.offer(stone);
        }

        while (priorityQueue.size() > 1) {
            int top1 = priorityQueue.poll();
            int top2 = priorityQueue.poll();
            int diff = Math.abs(top1 - top2);

            if (diff != 0) {
                priorityQueue.offer(diff);
            }
        }

        return priorityQueue.size() != 0 ? priorityQueue.peek() : 0;
    }
}
