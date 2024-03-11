public class Solution {
    public static int findRotationCount(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            if (arr[low] <= arr[high]) {
                return low; // Case when array is not rotated
            }

            int mid = low + (high - low) / 2;
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;

            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid; // Found the minimum element's index
            } 
            else if (arr[mid] >= arr[low]) {
                low = mid + 1; // Minimum element lies in the right half
            } 
            else if (arr[mid] <= arr[high]) {
                high = mid - 1; // Minimum element lies in the left half
            } 
        }

        return -1; // Not found (should not reach here for a valid rotated array)
    }
}
