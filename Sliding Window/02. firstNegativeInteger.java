/*First Negative Integer In Every Window Of Size K 
(https://www.codingninjas.com/studio/problems/first-negative-integer-in-every-window-of-size-k_1164406?leftPanelTabValue=PROBLEM)*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> firstNegativeInteger(ArrayList<Integer> arr, int k, int n) {
        // Initialize an ArrayList to store the result
        ArrayList<Integer> ans = new ArrayList<>();
        
        // Initialize an ArrayList to store all negative integers encountered
        ArrayList<Integer> list = new ArrayList<>();
        
        // Initialize two pointers for the sliding window approach
        int i = 0, j = 0;

        // Iterate through the array
        while (j < n) {
            // If the current element is negative, add it to the 'list'
            if (arr.get(j) < 0) {
                list.add(arr.get(j));
            }

            // If the window size reaches 'k'
            if (j - i + 1 == k) {
                // If 'list' is empty, add 0 to 'ans'
                if (list.isEmpty()) {
                    ans.add(0);
                }
                // If 'list' is not empty, add the leftmost negative integer to 'ans' and remove it from 'list'
                else {
                    ans.add(list.get(0));
                    if (arr.get(i) == list.get(0)) {
                        list.remove(0);
                    }
                }
                i++; // Move the window forward
            }
            j++; // Expand the window
        }
        return ans; // Return the result
    }
}
