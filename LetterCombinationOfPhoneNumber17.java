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
