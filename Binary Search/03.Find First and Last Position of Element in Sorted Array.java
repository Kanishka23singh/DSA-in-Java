import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        int[] ans = new int[]{-1, -1};
        
        int firstIndex = findFirstOccurrence(arr, n, k);
        if (firstIndex != -1) {
            int lastIndex = findLastOccurrence(arr, n, k);
            ans[0] = firstIndex;
            ans[1] = lastIndex;
        }
        
        return ans;
    }

    private static int findFirstOccurrence(ArrayList<Integer> arr, int n, int k) {
        int left = 0;
        int right = n - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) == k) {
                result = mid;
                right = mid - 1;
            } else if (arr.get(mid) < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static int findLastOccurrence(ArrayList<Integer> arr, int n, int k) {
        int left = 0;
        int right = n - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) == k) {
                result = mid;
                left = mid + 1;
            } else if (arr.get(mid) < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
