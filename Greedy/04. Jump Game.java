/*
https://www.youtube.com/watch?v=tZAa_jJ3SwQ&list=PLgUwDviBIf0rF1w2Koyh78zafB0cz7tea&index=4
*/
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxReachable = 0;
        for(int i = 0; i < n; i++){
            if(i > maxReachable){
                return false;
            }
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }
        return true;
    }
}
