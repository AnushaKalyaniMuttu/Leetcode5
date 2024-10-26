import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base index for valid substring calculation
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == '(') {
                stack.push(i); // Push the index of '('
            } else {
                // Pop the top for ')'
                stack.pop();

                if (stack.isEmpty()) {
                    // If stack is empty, push current index as a base
                    stack.push(i);
                } else {
                    // Calculate the length of the valid substring
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();
        String s = "(()))())(";
        int result = solution.longestValidParentheses(s);
        System.out.println("Length of longest valid parentheses: " + result); // Output: 4
    }
}



/*
Complexity Analysis
•	Time Complexity:
o	O(N), where N is the length of the string. We traverse the string once.
•	Space Complexity:
o	O(N) in the worst case for the stack if all characters are (.
Summary
This stack-based approach efficiently finds the length of the longest valid parentheses substring with:
•	Time Complexity: O(N)
•	Space Complexity: O(N)
*/
