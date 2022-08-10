package arryas;

public class DistanceBetweenArrays {
    /**
     * Given two integer arrays arr1 and arr2, and the integer d,
     * return the distance value between the two arrays.
     *
     * The distance value is defined as
     * the number of elements arr1[i] such that
     * there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.
     * @param arr1
     * @param arr2
     * @param d
     * @return
     */
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int distance = arr1.length;
        for (int x : arr1){
            for (int y : arr2) {
                if (Math.abs(x-y) <= d){
                    distance--;
                    break;
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,4,2,3};
        int[] arr2 = {-4,-3,6,10,20,30};
        int d = 3;
        System.out.println(findTheDistanceValue(arr1, arr2, d));
    }
}
