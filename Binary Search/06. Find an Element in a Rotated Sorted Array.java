public class Solution {
    public int search(int[] nums, int target) {
        int minIdx = findMinIndex(nums);

        int result = binarySearch(nums, 0, minIdx - 1, target);
        if (result == -1) {
            result = binarySearch(nums, minIdx, nums.length - 1, target);
        }

        return result;
    }

    private int findMinIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}

// Alternate Way : 
class Solution {
    public int search(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == k) {
                return mid;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] <= k && k <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] <= k && k <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
