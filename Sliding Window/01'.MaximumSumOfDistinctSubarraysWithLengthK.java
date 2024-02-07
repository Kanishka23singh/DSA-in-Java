/* 2461. Maximum Sum of *Distinct* Subarrays With Length K
    Example 1:

Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
*/
class Solution {
    public long maximumSubarraySum(int[] nums, int k){
        long maxSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = 0 , i = 0;
        long currSum = 0;
        
        while( j < nums.length){
            map.put(nums[j] , map.getOrDefault(nums[j], 0) + 1); //putting element to map
            currSum += nums[j];         //updating currsum
            
            if(j - i + 1 == k){         //Checking in every 3 or k pairs
                if(map.size() == k){
                    maxSum = Math.max(currSum , maxSum);        //updating maxsum
                }
                currSum -= nums[i];         //deducting first element of the triplet as we move forward
                map.put(nums[i], map.get(nums[i])-1);                  
				if (map.get(nums[i]) == 0) map.remove(nums[i]);  //updating map
				i++;
            }
            j++;
        }
        return maxSum;
    }
}


