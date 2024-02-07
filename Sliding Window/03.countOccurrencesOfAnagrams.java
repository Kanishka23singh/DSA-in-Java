/* https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1 */
import java.util.*;
public class Solution {
    public static int countOccurrencesOfAnagrams(String str, int n, String ptr, int m){  // public static ArrayList<Integer> findAnagramsIndices(String str, int n, String ptr, int m){
        // Write your code here.
        int ans = 0;  //ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < ptr.length(); i++){
            map.put(ptr.charAt(i),map.getOrDefault(ptr.charAt(i),0)+1);
        }
        int i = 0, j = 0;
        int size = map.size();

        while(j < str.length()){
            if(map.containsKey(str.charAt(j))){
                map.put(str.charAt(j),map.get(str.charAt(j))-1);
                if(map.get(str.charAt(j)) == 0){
                    size--;
                }
            }

            if(j - i + 1 == ptr.length()){
                if(size == 0){
                    ans += 1; //ans.add(i);
                }
                // Adjust the window by removing the ith character
                if (map.containsKey(str.charAt(i))) {
                    map.put((str.charAt(i)), map.get((str.charAt(i))) + 1);
                    if (map.get((str.charAt(i))) == 1) { // Note not greater than 0
                        size++;
                    }
                }
                i++; // Move the window forward
            }
            j++;
        }
        return ans;
    }
}
