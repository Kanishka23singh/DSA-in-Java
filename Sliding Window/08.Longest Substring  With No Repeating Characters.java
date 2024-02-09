// See Leetcode 3 also : Length of longest Substring Without Repeating Characters
/*It is same as Longest substring with K Unique Characters but here we want all unique characters. Therefore here k is window size (j - i + 1). 
But a bit different approach to refer see https://www.youtube.com/watch?v=qtVh-XEpsJo*/

import java.util.HashMap;
class Main {
    static String longestSubstrDistinctChars(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int max = 0;
        int start = 0, end = 0;
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j), j);
            if (j - i + 1 > max) {
                max = j - i + 1;
                start = i;
                end = j + 1;
            }
            j++;
        }
        return s.substring(start, end);
    }

    public static void main(String[] args) {
        // Test the longestSubstrDistinctChars method
        String s =  "geeksforgeeks";
        System.out.println("Longest substring with distinct characters: " + longestSubstrDistinctChars(s));
    }
}


