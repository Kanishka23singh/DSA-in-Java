/*856. Score of Parentheses

Given a balanced parentheses string s, return the score of the string.

The score of a balanced parentheses string is based on the following rule:
"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 

Example 1:
Input: s = "()"
Output: 1

Example 2:
Input: s = "((()))"
Output: 4

Example 3:
Input: s = "()()"
Output: 2

### Intuition and Algorithm:

1. Stack Utilization:
   - We use a stack to help manage the nested structure of the parentheses and compute scores in a Last-In-First-Out (LIFO) manner.
   
2. Character Iteration:
   - We iterate through each character of the string `s`.
   
3. Handling '(':
   - When encountering an opening parenthesis `(`, push `-1` onto the stack to denote a new, potentially nested score block.
   
4. Handling ')':
   - When encountering a closing parenthesis `)`:
     - If the top of the stack is `-1`, it means we have a simple `()` pair. We pop `-1` and push `1` onto the stack.
     - If the top of the stack is not `-1`, it means we are closing a nested structure. We keep popping and summing values from the stack until we encounter `-1`, which indicates the start of the current nested structure. We then pop `-1` and push `2 * score`, where `score` is the sum of the nested values.

5. Final Sum:
   - After processing all characters, the stack contains scores of non-overlapping balanced parentheses strings. We sum these values to get the total score.

Detailed Algorithm:
1. Initialize an empty stack `st`.
2. Loop through each character `ch` in the string `s`:
   - If `ch` is `(`, push `-1` onto the stack.
   - If `ch` is `)`:
     - If `st.peek() == -1`, pop the stack and push `1`.
     - Otherwise, initialize `score` to `0` and keep popping from the stack, adding to `score` until `st.peek() == -1`. Then, pop `-1` and push `2 * score`.
3. Initialize `score` to `0` and pop all remaining elements from the stack, adding them to `score`.
4. Return the final `score`.

Example Walkthrough:

For `s = "(())()"`:
- Initial Stack: `[]`
- Processing `(`: Stack becomes `[-1]`
- Processing `(`: Stack becomes `[-1, -1]`
- Processing `)`: Pop `-1` and push `1`: Stack becomes `[-1, 1]`
- Processing `)`: Pop `1` and `-1`, push `2*1`: Stack becomes `[2]`
- Processing `(`: Stack becomes `[2, -1]`
- Processing `)`: Pop `-1` and push `1`: Stack becomes `[2, 1]`
- Sum the stack: `2 + 1 = 3`

Thus, the score is `3`.

Conclusion:
The stack-based approach helps efficiently manage and compute scores by leveraging the LIFO property to handle nested and sequential structures of balanced parentheses.
*/

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();

        // ( --> -1
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(-1);
            }
            else{
                if(st.peek() == -1){ // `()` has a score of 1.
                    st.pop();
                    st.push(1);
                }
                else{
                    int score = 0; // `(A)` has a score of `2 * A`, where `A` is a balanced parentheses string.
                    while(st.peek() != -1){
                        score += st.pop();
                    }
                    st.pop();
                    st.push(2*score);
                }
            }
        }
        int score = 0; // `(A)` has a score of `2 * A`, where `A` is a balanced parentheses string.
        while(!st.isEmpty()){
            score += st.pop();
        }
        return score;
    }
}

/*
class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int score = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(score);
                score = 0; // Reset the score for the new balanced section
            } else {
                score = stack.pop() + Math.max(2 * score, 1);
            }
        }

        return score;
    }
}
*/
