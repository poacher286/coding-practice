package test;

import java.util.*;

public class Biweekly158 {
    /**
     * You are given two integer arrays x and y, each of length n. You must choose three distinct indices i, j, and k such that:
     *
     * x[i] != x[j]
     * x[j] != x[k]
     * x[k] != x[i]
     * Your goal is to maximize the value of y[i] + y[j] + y[k] under these conditions. Return the maximum possible sum that can be obtained by choosing such a triplet of indices.
     *
     * If no such triplet exists, return -1.
     *
     * @param x
     * @param y
     * @return
     */
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        if (x == null || y == null || x.length != y.length || x.length < 3) {
            return -1;
        }

        Map<Integer, Integer> xToMaxY = new HashMap<>();

        for (int i = 0; i < x.length; i++) {
            int xi = x[i];
            int yi = y[i];
            xToMaxY.put(xi, Math.max(xToMaxY.getOrDefault(xi, Integer.MIN_VALUE), yi));
        }

        if (xToMaxY.size() < 3) {
            return -1;
        }

        List<Integer> yList = new ArrayList<>(xToMaxY.values());
        yList.sort(Collections.reverseOrder());

        return yList.get(0) + yList.get(1) + yList.get(2);
    }
}
