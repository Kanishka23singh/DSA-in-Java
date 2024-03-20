public class CeilInSortedArray {
    public static int findCeil(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int ceil = -1; // Initialize the ceil to -1

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                ceilIndex =arr[mid]; // Found exact match
                break;
            } else if (arr[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                ceil = arr[mid]; // Update ceil
                right = mid - 1; // Search in the left half
            }
        }

        return ceil;
    }
}
