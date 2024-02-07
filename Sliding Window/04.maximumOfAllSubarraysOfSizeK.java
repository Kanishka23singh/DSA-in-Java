/* Problem statement
You are given an array “A” of N integers. Your task is to find the maximum element in all K sized contiguous subarrays from left to right.
For Example:
If A = [3, 2, 3, 5, 1, 7] and K = 3.
Then max of [3, 2, 3] = 3 
Then max of [2, 3, 5] = 5 
Then max of [3, 5, 1] = 5 
Then max of [5, 1, 7] = 7 
So  the answer will be [3, 5, 5, 7]
Follow Up :
Can you solve the problem in O(N) time complexity and O(K) space complexity? 
https://www.codingninjas.com/studio/problems/maximum-of-all-subarrays-of-size-k_1071161
https://www.codingninjas.com/studio/library/maximum-of-all-subarrays-of-size-k
*/

import java.util.* ;
import java.io.*; 
public class Solution {
    public static List<Integer> maximumInAllSubarraysOfSizeK(int[] arr, int n, int k) {
        // Write your code here!
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayDeque<Integer> maxDeque = new ArrayDeque<>();
        int i = 0, j = 0;
        while(j < n){
            while(maxDeque.size() > 0 && maxDeque.getLast() < arr[j]){
                maxDeque.removeLast();
            }
            maxDeque.add(arr[j]);

            if(j - i + 1 == k){
                ans.add(maxDeque.getFirst());
                if(arr[i] == maxDeque.getFirst()){
                    maxDeque.removeFirst();
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}
