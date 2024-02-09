/* https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
https://www.codingninjas.com/studio/problems/longest-sub-string-with-k-distinct-characters_920521 (Slight change in question)
Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.
Example 1:
Input:
S = "aabacbebebe", K = 3
Output: 
7
Explanation: 
"cbebebe" is the longest substring with 3 distinct characters. */

class Solution {
    public int longestkSubstr(String str, int k) {
        // code here
        int i = 0;
        int j = 0;
        int ans = -1;
        int n = str.length();
        HashMap<Character, Integer> map = new HashMap<>();

        while (j < n) {
            map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
            if(map.size()==k){
                ans = Math.max(ans, j - i + 1);
            }
            if(map.size() > k){
                while (map.size() > k) {
                map.put(str.charAt(i), map.get(str.charAt(i))- 1);
                if (map.get(str.charAt(i)) == 0) {
                    map.remove(str.charAt(i));
                }
                i++;
                }
            }
            j++;
        }
        return ans;
    }
}
