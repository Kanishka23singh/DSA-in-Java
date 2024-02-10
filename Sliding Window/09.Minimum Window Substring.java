// Leetcode 76. Minimum Window Substring
/* Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
*/

class Solution {
    public String minWindow(String s, String t) {
        String ans = "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int i = 0;
        int j = 0;
        int cnt = map.size();

        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) - 1);
                if (map.get(s.charAt(j)) == 0) {
                    cnt--;
                }
            }
            if (cnt == 0) {
                while (cnt == 0) {
                    if (ans.isEmpty() || j - i + 1 < ans.length()) {
                        ans = s.substring(i, j + 1);
                    }
                    if (map.containsKey(s.charAt(i))) {
                        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                        if (map.get(s.charAt(i)) > 0) {
                            cnt++;
                        }
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
}
