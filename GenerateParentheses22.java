import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // If the current string has reached the maximum length
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // Add an opening parenthesis if we can
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // Add a closing parenthesis if it won't exceed the number of opening ones
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        int n = 3; // Example with 3 pairs
        List<String> result = solution.generateParenthesis(n);
        System.out.println(result); // Should output all combinations for 3 pairs
    }
}



/* 
Complexity Analysis
•	Time Complexity:
o	The number of valid combinations of parentheses is given by the nnn-th Catalan number, which is O(4n/n3/2)O(4^n / n^{3/2})O(4n/n3/2). Thus, the time complexity can be approximated as O(4n)O(4^n)O(4n) due to the nature of generating combinations.
•	Space Complexity:
o	The space complexity is O(n)O(n)O(n) for the recursion stack and O(k)O(k)O(k) for storing the result, where kkk is the number of valid combinations generated. Therefore, in total, the space complexity can be approximated as O(n⋅k)O(n \cdot k)O(n⋅k).
Summary
This backtracking approach effectively generates all combinations of well-formed parentheses with:
•	Time Complexity: Approximately O(4n)O(4^n)O(4n)
•	Space Complexity: O(n)O(n)O(n) for the recursion stack and O(k)O(k)O(k) for the result list.


  */
