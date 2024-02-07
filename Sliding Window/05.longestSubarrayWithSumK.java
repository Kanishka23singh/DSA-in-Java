/* Longest Subarray With Sum K
Example:
Input: ‘N’ = 5,  ‘K’ = 4, ‘NUMS’ = [ 1, 2, 1, 0, 1 ]
Output: 4
There are two subarrays with sum = 4, [1, 2, 1] and [2, 1, 0, 1]. Hence the length of the longest subarray with sum = 4 is 4.*/

// Note Optimal Approach for array consisting only {Positive} (https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_6682399?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems)
public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        int i = 0, j = 0;
        long sum = 0;
        int max = 0;

        while(j < a.length){
            sum += a[j];
            if(sum == k){
                max = Math.max(max,j-i+1);
            }
            if(sum > k){
                while(sum > k){ /* here in second condition i.e (sum>k)we go on removing starting elements of sub array till (sum <= k) if sum becomes equal to k then we are not storing that size of sub array any where we simply incrementing the j; here we looses a solution. So to prevent check (sum == k)*/
                    sum -= a[i];
                    i++;
                    if(sum == k){
                        max = Math.max(max, j - i + 1);
                    }
                }
            }
            j++;
        }
        return max;
    }
}

// Note Optimal Approach for array consisting both {Positive + Negative} ((https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_5713505))
import java.util.*;
public class Solution {
    public static int getLongestSubarray(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
			// Store the prefix sum and its corresponding index
            
            if (sum == k) {
                maxLen = i + 1; // Update maxLen if the sum up to index i equals k
            }
            if (map.containsKey(sum - k)) {
                int len = i - map.get(sum - k);
                maxLen = Math.max(len, maxLen);
            }
            
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
			
        }
        return maxLen;
    }
}

// 560. Count Subarray Sum Equals K (https://leetcode.com/problems/subarray-sum-equals-k/description/)
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Frequency Map
        map.put(0,1);
        int sum = 0, ans = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
