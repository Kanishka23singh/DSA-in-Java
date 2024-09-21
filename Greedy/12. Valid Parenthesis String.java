// For Optimal Solution O(n) we need to maintain the range of cnt[min, max] and if min value is Zero(0) it is valid and if at any point the value is min is negative make it zero (because * also suggest blank) and if at any point max is neagtive return false as there has to something positive value as we are taking about range. for example: s = ')'
/*
Range of Balance:

Track the minimum (min) and maximum (max) possible counts of open parentheses as you iterate through the string.
Character Effects:

For (: Increase both min and max (you gain an open parenthesis).
For ): Decrease both (you lose an open parenthesis).
For *: Treat it as either ( (increase max), ) (decrease min), or nothing (no effect).
Maintain Validity:

If min drops below 0, reset it to 0 (as * can act as empty).
If max goes negative, it means there are too many closing parentheses without matching opens, making the string invalid.
Final Check:

At the end, if min is 0, it indicates that the parentheses can be validly matched.
*/

class Solution {
    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                min++;
                max++;
            }
            else if(s.charAt(i) == ')'){
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }

            if(min < 0) min = 0; // Ensure min is not negative as '*' can act as empty
            if(max < 0) return false; 
        }
        
        return min == 0;
    }
}
/* Brute Force Recursive Solution O(n^3)
Algorithm:
If '(' then cnt++;
If ')' then cnt--;
If at any point cnt = -1 it is invalid. For example: s = "())("

class Solution {
    public boolean checkValidString(String s) {
        return solve(s,0,0);
    }
    public boolean solve(String s, int idx, int count){
        if(count < 0){
            return false;
        }
        if(idx == s.length()){
            return (count == 0);
        }

        if(s.charAt(idx) == '('){
            return solve(s, idx + 1, count + 1);
        }

        if(s.charAt(idx) == ')'){
            return solve(s, idx + 1, count - 1);
        }

        return solve(s, idx + 1, count) || solve(s, idx + 1, count + 1) || solve(s, idx + 1, count - 1);
    }
}
*/
