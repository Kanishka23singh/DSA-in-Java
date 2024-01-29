/*Max Sum Subarray of size K 
(https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article)*/

class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        int i = 0, j = 0;
        long sum = 0;
        long max = Integer.MIN_VALUE;
        
        while(j < Arr.size()){
            sum += Arr.get(j);
            if(j - i + 1 == K){
                max = Math.max(max,sum);
                sum = sum - Arr.get(i);
                i++;
            }
            j++;
        }
        return max;
    }
}
