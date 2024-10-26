import java.util.Stack;

public class ValidParentheses20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        // Mapping of closing to opening brackets
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); // Push opening brackets onto the stack
            } else {
                // Check if stack is empty or if the top doesn't match
                if (stack.isEmpty() || !isMatching(stack.pop(), c)) {
                    return false;
                }
            }
        }
        // Valid if stack is empty
        return stack.isEmpty();
    }

    private boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') || 
               (open == '{' && close == '}') || 
               (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        String test = "()[]{}";
        System.out.println(solution.isValid(test)); // Should output true
    }
}

//Time  Complexity : O(n)
//Space Complexity : O(n)
