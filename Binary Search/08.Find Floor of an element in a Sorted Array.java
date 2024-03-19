public class Solution {

    public static int findFloor(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int floor = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return arr[mid]; // Found exact match
            } else if (arr[mid] < target) {
                floor = arr[mid]; // Update floor and move right
                left = mid + 1;
            } else {
                right = mid - 1; // Move left
            }
        }

        return floor;
    }
}
