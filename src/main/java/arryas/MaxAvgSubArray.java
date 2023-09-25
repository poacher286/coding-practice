package arryas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxAvgSubArray {
    public static double findMaxAverage(int[] nums, int k) {
        List<List<Integer>> collect = getSubArray(nums).stream()
                .filter(x -> x.size() == k)
                .collect(Collectors.toList());

        double maxAvg = Integer.MIN_VALUE;
        for (List<Integer> kLengthList : collect) {
            double avg = kLengthList.stream().mapToInt(x -> x).average().orElse(0.0);
            maxAvg = Math.max(avg, maxAvg);
        }
        return maxAvg;
    }

    public static List<List<Integer>> getSubArray(int[] nums){
        List<List<Integer>> subArrayList = new ArrayList<>();
        List<Integer> subArray ;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                subArray = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    subArray.add(nums[k]);
                }
                subArrayList.add(subArray);
            }
        }
        System.out.println(subArrayList);
        return subArrayList;
    }

    public double findMaxAverageOptimize(int[] a, int k){
        int sum = Arrays.stream(a, 0, k).sum(), maxSum = sum;
        for(int i = k; i < a.length; i++){
            sum += a[i] - a[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum * 1.0 / k;
    }

    public static void main(String[] args) {
        int[] nums = {5};
        int k = 1;

        System.out.println(findMaxAverage(nums, k));
    }
}
