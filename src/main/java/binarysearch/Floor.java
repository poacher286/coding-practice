package binarysearch;

public class Floor {
    public static int floor(int[] arr, int tar){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;
            if (arr[mid] < tar){
                start = mid + 1;
            }else if (arr[mid] > tar){
                end = mid - 1;
            }else{
                return mid;//ans found
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,5,7,12,13,16,18,21};
        int tar = 10;
        System.out.println(floor(arr, tar));
    }
}
