// See Leetcode 3 also : Length of longest Substring Without Repeating Characters
// A bit different approach to refer see https://www.youtube.com/watch?v=qtVh-XEpsJo//

import java.util.HashMap;
class Main {
    static String longestSubstrDistinctChars(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int max = 0;
        
        while(j < s.length()){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j),j);
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}

// Same approach as Length of Longest substring with K Unique Characters but here we want all unique characters. Therefore here k is window size (j - i + 1). 
class Solution{
    int longestUniqueSubsttr(String str){
        int i = 0, j = 0, ans = 0;
        int n = str.length();
        HashMap<Character, Integer> map = new HashMap<>();

        while (j < n) {
            map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
            if(map.size() == j - i + 1){ // Here k is window size
                ans = Math.max(ans, j - i + 1);
            }
            if(map.size() < j - i + 1){  // If the size of the map is less than the length of the current substring, adjust the window by moving the left pointer i and updating the frequency map
                while (map.size() < j - i + 1) {
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
