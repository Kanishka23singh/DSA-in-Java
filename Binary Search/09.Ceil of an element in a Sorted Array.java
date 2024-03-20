public class CeilInSortedArray {
    public static int findCeil(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int ceilIndex = -1; // Initialize the ceiling index to -1

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                ceilIndex = mid; // Target found, update ceiling index and break
                break;
            } else if (arr[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                ceilIndex = mid; // Update ceiling index to current mid
                right = mid - 1; // Search in the left half
            }
        }

        return ceilIndex;
    }
}
