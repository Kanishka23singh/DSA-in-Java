/* https://www.geeksforgeeks.org/problems/minimum-window-subsequence/1
Example 1:

Input: 
str1: geeksforgeeks
str2: eksrg
Output: 
eksforg
Explanation: 
Eksforg satisfies all required conditions. str2 is its subsequence and it is longest and leftmost among all possible valid substrings of str1. */


class Solution {
    public static String minWindow(String s, String t) {
        // Initialize pointers and variables
        int j = 0; // Pointer for traversing string t
        int min = s.length(); // Variable to store the minimum window length
        String minWin = ""; // Variable to store the minimum window substring

        // Loop through string s
        for(int i = 0; i < s.length(); i++){
            // Check if current character in s matches the character in t at pointer j
            if(s.charAt(i) == t.charAt(j)){
                j++; // Move pointer j to the next character in t
                // If pointer j has reached the end of t, we found a window
                if(j == t.length()){
                    int end = i + 1; // Mark the end index of the window
                    j--; // Move pointer j back one step
                    // Backtrack to find the start index of the window
                    while(j >= 0){
                        if(s.charAt(i) == t.charAt(j)){
                            j--; // Move pointer j back if characters match
                        }
                        i--; // Move pointer i back in s
                    }
                    i++; // Move pointer i forward to the correct start index of the window
                    j++; // Move pointer j forward to the correct position in t

                    // Update min and minWin if current window is smaller
                    if(end - i < min){
                        min  = end - i; // Update min with current window length
                        minWin = s.substring(i, end); // Update minWin with current window substring
                    }
                }
            }
        }
        return minWin; // Return the minimum window substring
    }
}
