/*
//Approach (Using simple Greedy)
//T.C : O(m+n)
//S.C : O(m*n) //You can exclude this because it is what is expected to return from the function

Find the smallest rowSum or colSum, and let it be x. Place that number in the grid, and subtract x from rowSum and colSum. 
Continue until all the sums are satisfied.
*/

class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int ans[][] = new int[n][m];

        int i = 0; // row
        int j = 0; // col

        while(i < n && j < m){
            ans[i][j] = Math.min(rowSum[i], colSum[j]);

            rowSum[i] -= ans[i][j];
            colSum[j] -= ans[i][j];

            if(rowSum[i] == 0) i++;
            if(colSum[j] == 0) j++;
        }
        return ans;
    }
}
