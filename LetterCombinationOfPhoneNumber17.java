import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber17 {

    private static final String[] MAPPING = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder combination, String digits, int index) {
        // If the combination is complete
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }

        // Get the letters for the current digit
        String letters = MAPPING[digits.charAt(index) - '0'];

        for (char letter : letters.toCharArray()) {
            combination.append(letter);  // Choose a letter
            backtrack(result, combination, digits, index + 1);  // Explore further
            combination.deleteCharAt(combination.length() - 1);  // Un-choose the letter
        }
    }

    public static void main(String[] args) {
        PhoneNumberCombinations solution = new PhoneNumberCombinations();
        String digits = "23";  // Example input
        List<String> combinations = solution.letterCombinations(digits);
        System.out.println(combinations);
    }
}



/* Time Complexity: 
𝑂(4𝑁)
O(4N) in the worst case, where 𝑁
N is the length of the input digits. Each digit can map to up to 4 letters (e.g., the digit '7').

Space Complexity:
Recursive Call Stack: 
𝑂(𝑁)
O(N) due to the depth of recursion.
Result Storage: 
𝑂(4𝑁)
O(4 N ) for storing all possible combinations.
    */
