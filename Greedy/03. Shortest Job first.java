// https://www.geeksforgeeks.org/problems/shortest-job-first/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-job-first
class Solution {
    static int solve(int bt[] ) {
    // code here
    Arrays.sort(bt);
    
    int n = bt.length;
    int t = 0;
    int wt = 0;
    
    for(int i : bt){
        wt += t; 
        t = t + i;
    }
    return wt/n;
  }
}
