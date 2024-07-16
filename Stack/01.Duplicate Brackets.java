/*
Given a string of balanced expressions, find if it contains a redundant parenthesis or not. A set of parenthesis is redundant if the same sub-expression is surrounded by unnecessary or multiple brackets. Print ‘Yes‘ if redundant, else ‘No‘.

Note: Expression may contain ‘+‘, ‘*‘, ‘–‘ and ‘/‘ operators. Given expression is valid and there are no white spaces present.

Examples: 

Input: str = “((a+b))”
Output: YES
Explanation: ((a+b)) can reduced to (a+b), this Redundant

Input: str = “(a+(b)/c)”
Output: YES
Explanation: (a+(b)/c) can reduced to (a+b/c) because b is surrounded by () which is redundant.

Input:
exp = (a+b+(c+d))
Output:
No
Explanation: (a+b+(c+d)) doesn't have any redundant or multiple brackets.
*/
class Solution {
    public static int checkRedundancy(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == ')') {
                int k = 0;
                
                // If immediate pop have open parenthesis '(' duplicate brackets found 
                if (st.peek() == '(') {
                    return 1; // Redundant parenthesis found
                } else {
                    // Pop elements from the stack until an opening parenthesis is found
                    while (st.peek() != '(') {
                        st.pop();
                        k++;
                    }
                    st.pop(); // Pop the opening parenthesis
                    if (k == 1) return 1; // If only one element between parentheses, it's redundant
                }
            } else {
                // Push the current character onto the stack
                st.push(ch);
            }
        }
        
        return 0; // No redundant parentheses found
    }
}
