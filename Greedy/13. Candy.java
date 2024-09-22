135. Candy
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
You are giving candies to these children subjected to the following requirements:

1.Each child must have at least one candy.
2.Children with a higher rating get more candies than their neighbors.
3.Return the minimum number of candies you need to have to distribute the candies to the children.

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 
/* Optimal Solution: Greedy we will use slope concept to solve without using any extra space
T(n) = O(n)
S(n) = O(1)
*/
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int sum = 1;
        int i = 1;

        while(i < n){
            if(ratings[i] == ratings[i-1]){ // Flat Slope
                sum++;
                i++;
                continue;
            }
            int peak = 1;
            while(i < n && ratings[i] > ratings[i-1]){ // Increasing Slope
                peak++;
                sum += peak; 
                i++;
            }
            int down = 1;
            while(i < n && ratings[i] < ratings[i-1]){ // Decreasing Slope
                sum += down;
                down++;
                i++;
            }

            if(down > peak){
                sum += down - peak;
            }
        }
        
        return sum;
    }
}
/* T(n) = O(n)
   S(n) = O(n)
class Solution {
    public int candy(int[] A) {
        int n = A.length;
        int candies[] = new int[n];
        candies[0] = 1;
        
        // Going Right
        for(int i = 1; i < n; i++){
            if(A[i] > A[i-1]){
                candies[i] = candies[i-1] + 1;
            }
            else{
                candies[i] = 1;
            }
        }
        
        // Going Left
        int ans = candies[n-1];
        for(int i = n-2; i >= 0; i--){
            int curr = 1;
            if(A[i] > A[i+1]){
                curr = candies[i+1] + 1;
            }
            ans += Math.max(curr, candies[i]);
            candies[i] = curr;
        }
        return ans;
    }
}
*/
