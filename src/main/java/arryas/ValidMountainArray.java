package arryas;

public class ValidMountainArray {
    /**
     * Given an array of integers arr, return true if and only if it is a valid mountain array.
     *
     * Recall that arr is a mountain array if and only if:
     *
     * arr.length >= 3
     * There exists some i with 0 < i < arr.length - 1 such that:
     * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
     * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
     * @param arr
     * @return
     */
    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3){
            return false;
        }

        int peakCount = 0;
        int deepCount = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if(arr[i] == arr[i - 1]){
                return false;
            }
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]){
                peakCount++;
            }else if(arr[i - 1] > arr[i] && arr[i] < arr[i + 1]){
                deepCount++;
            }
        }

        return peakCount == 1 && deepCount == 0;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,1,2};
        System.out.println(validMountainArray(arr));

    }
}
