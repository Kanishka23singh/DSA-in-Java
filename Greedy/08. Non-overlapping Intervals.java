/*435. Non-overlapping Intervals
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
*/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int n = intervals.length; 
        int cnt = 0; // To store non overlapping interval
        int end = intervals[0][1];

        for(int i = 1; i < n; i++){
            if(intervals[i][0] >= end){
                cnt++;
                end = intervals[i][1];
            }
        }
        return n - cnt; // Number of overlapping interval
    }
}
