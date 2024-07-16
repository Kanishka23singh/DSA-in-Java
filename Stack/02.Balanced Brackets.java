/*Leetcode 20: Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 
Sample Input

STDIN           Function
-----           --------
3               n = 3
{[()]}          first s = '{[()]}'
{[(])}          second s = '{[(])}'
{{[[(())]]}}    third s ='{{[[(())]]}}'
Sample Output

YES
NO
YES
*/
import java.util.Stack;

public class BalancedParenthesesChecker {

    public static String isBalanced(String s) {
        Stack<Character> st = new Stack<>();

        // Traverse the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Push opening brackets onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }

            // Check closing brackets
            if (ch == ')' || ch == '}' || ch == ']') {
                // If stack is empty, it means there's no corresponding opening bracket
                if (st.isEmpty()) {
                    return "NO";
                } else {
                    char top = st.peek();
                    // Check if the top of the stack matches the corresponding opening bracket
                    if ((ch == ')' && top != '(') || 
                        (ch == '}' && top != '{') || 
                        (ch == ']' && top != '[')) {
                        return "NO";
                    }
                    // Pop the matched opening bracket
                    st.pop();
                }
            }
        }

        // If the stack is empty, all opening brackets had matching closing brackets
        return st.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isBalanced("()")); // YES
        System.out.println(isBalanced("({[()]})")); // YES
        System.out.println(isBalanced("({[)]})")); // NO
        System.out.println(isBalanced("(")); // NO
        System.out.println(isBalanced("]")); // NO
    }
}
