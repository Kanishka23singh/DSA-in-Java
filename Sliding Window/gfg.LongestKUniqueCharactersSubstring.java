/*Longest K unique characters substring. 
Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.
https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1 */

class Solution {
    public int longestkSubstr(String str, int k) {
        // code here
        int i = 0;
        int j = 0;
        int ans = 0;
        int n = str.length();
        HashMap<Character, Integer> map = new HashMap<>();

        while (j < n) {
            map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
            if (map.size() == k) {
                ans = Math.max(ans, j - i + 1);
            } else if (map.size() > k) {
                while (map.size() > k) {
                    map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) - 1);
                    if (map.get(str.charAt(i)) == 0) {
                        map.remove(str.charAt(i));
                    }
                    i++;
                    if (map.size() == k) {
                        ans = Math.max(ans, j - i + 1);
                    }
                }
            }
            j++;
        }
        return ans;
    }
}
