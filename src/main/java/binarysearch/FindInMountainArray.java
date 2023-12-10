package binarysearch;


/**
 * You may recall that an array arr is a mountain array if and only if:
 *
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.
 *
 * You cannot access the mountain array directly. You may only access the array using a MountainArray interface:
 *
 * MountainArray.get(k) returns the element of the array at index k (0-indexed).
 * MountainArray.length() returns the length of the array.
 * Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.
 *
 *
 *
 * Example 1:
 *
 * Input: array = [1,2,3,4,5,3,1], target = 3
 * Output: 2
 */
public class FindInMountainArray {
      public int findInMountainArray(int target, MountainArray mountainArray) {
            int peak = peakIndex(mountainArray);
            int index = binarySearch(mountainArray, target, 0, peak);
            if (index != -1) {
                  return index;
            }
            return binarySearch(mountainArray, target, peak + 1, mountainArray.length() - 1);
      }

      public static  int peakIndex(MountainArray mountainArray){
          int left = 0;
          int right = mountainArray.length() - 1;
          while (left < right){
                int mid = left + (right - left) / 2;
                if (mountainArray.get(mid) > mountainArray.get(mid + 1)){
                      right = mid;
                }else{
                      left = mid + 1;
                }
          }
          return left;
      }

      public static int binarySearch(MountainArray mountainArray, int target, int left, int right) {
            boolean isAscending = mountainArray.get(left) < mountainArray.get(right);
            while (left <= right) {
                  int mid = left + (right - left) / 2;

                  if (target == mountainArray.get(mid)) {
                        return mid;
                  }

                  if (isAscending) {
                        if (target > mountainArray.get(mid)) {
                              left = mid + 1;
                        } else {
                              right = mid - 1;
                        }
                  } else {
                        if (target > mountainArray.get(mid)) {
                              right = mid - 1;
                        } else {
                              left = mid + 1;
                        }
                  }
            }
            return -1;
      }

      interface MountainArray {
            int get(int index);
            int length();
      }
}

