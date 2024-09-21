class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int n = arr.length;
        int i = 0;
        int j = 0;
        int ans = 0;
        int cnt = 0;
        
        while(i < n){ // If no more trains are arriving
            if(arr[i] <= dep[j]){
                cnt++; // Arrival means platform needed
                i++;
            }
            else{
                cnt--; // Departure means platform free
                j++;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}



/* Brute Force O(n^2)
class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        int n = arr.length;
        int maxPlatforms = 1; // To store the maximum number of platforms needed at any point

        // Iterate through each train's arrival
        for (int i = 0; i < n; i++) {
            int platformsNeeded = 1; // At least one platform is needed for this train

            // Compare the current train's arrival time with all other trains
            for (int j = i + 1; j < n; j++) {
                // Check if trains overlap
                if (arr[i] <= dep[j] && arr[j] <= dep[i]) {
                    platformsNeeded++; // If they overlap, we need one more platform
                }
            }

            // Update the maximum platforms needed
            maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
        }

        return maxPlatforms; // Return the maximum number of platforms needed
    }
}

       .                  .
      arr                dep
 .                             . (Arrive previously and depart later)
 .                 .             (Arrive previously and depart early)
            .                  . (Arrive later and depart later)
            .      .             (Arrive later and depart eraly)

 i     arr           dep
 j     arr                 dep
 
*/
