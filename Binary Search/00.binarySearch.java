// Binary Search
class Solution {
    public int binarySearch(int[] nums, int n, int target) {
        int low = 0;
        int high = n - 1;
      
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
               return mid;
            }
            else if(nums[mid] < target){
                low =  mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
