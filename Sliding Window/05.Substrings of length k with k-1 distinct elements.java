// It is the typical fixed size Sliding Window Problem
class Solution {
    static int countOfSubstrings(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, count = 0;
        
        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if(j - i + 1 == k){
                if(map.size() == k - 1){
                    count++;
                }
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }
                i++;
            }
            j++;
        }
        return count;
    }
}
