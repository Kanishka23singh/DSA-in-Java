/* Order-Agnostic Binary Search is a modified version of Binary Search algorithm.
The intuition behind this algorithm is what if the order of the sorted array is not given.*/
class Solution {
    int binarysearch(int arr[], int n, int k) {
        // code here
        int low = 0;
        int high = n-1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == k){
                return mid;
            }
            if(arr[0] < arr[1]){ // if ascending
                if(arr[mid] < k){
                   low = mid + 1;
                }
                else{
                    high = mid - 1; 
                }
            }
            if(arr[0] > arr[1]){ // if descending
                if(arr[mid] > k){
                   low = mid + 1;
                }
                else{
                    high = mid - 1; 
                }
            }
        }
        return -1;
    }
}
