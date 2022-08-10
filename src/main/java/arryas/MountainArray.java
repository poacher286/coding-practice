package arryas;

public class MountainArray {
    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = 1;
        while (true){
            if (arr[left++] > arr[right++]) break;
        }
        return left-1;
    }

    public static void main(String[] args) {
        int[] arr= {0,10,5,2};
        System.out.println(peakIndexInMountainArray(arr));
    }
}
