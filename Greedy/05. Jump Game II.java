class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0; // No jumps needed if there's only one element
        
        int l = 0, r = 0, jumps = 0;

        while (r < n - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) { // Fixed: i should go up to r
                farthest = Math.max(i + nums[i], farthest);
            }
            l = r + 1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }
}
/*
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j <= i + nums[i] && j < n; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }

        return dp[n - 1];
    }
}
*/
