import java.util.*;

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();

        // Store each word's index in the map
        for (int i = 0; i < words.length; i++) {
            wordMap.put(words[i], i);
        }

        // Check for each word
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // Case 1: Check if the word itself is a palindrome and has a pair with an empty string
            if (isPalindrome(word) && word.length() > 0) {
                if (wordMap.containsKey("") && wordMap.get("") != i) {
                    result.add(Arrays.asList(i, wordMap.get("")));
                    result.add(Arrays.asList(wordMap.get(""), i));
                }
            }

            // Case 2: Split word into two parts and check if each part is a palindrome
            for (int j = 0; j < word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);

                // Case 2a: If left part is palindrome, check if the reverse of the right part exists in the map
                if (isPalindrome(left)) {
                    String reversedRight = new StringBuilder(right).reverse().toString();
                    if (wordMap.containsKey(reversedRight) && wordMap.get(reversedRight) != i) {
                        result.add(Arrays.asList(wordMap.get(reversedRight), i));
                    }
                }

                // Case 2b: If right part is palindrome, check if the reverse of the left part exists in the map
                if (isPalindrome(right)) {
                    String reversedLeft = new StringBuilder(left).reverse().toString();
                    if (wordMap.containsKey(reversedLeft) && wordMap.get(reversedLeft) != i) {
                        result.add(Arrays.asList(i, wordMap.get(reversedLeft)));
                    }
                }
            }
        }

        // Remove duplicate pairs (such as [0,1] and [1,0] from the same word and empty string case)
        Set<List<Integer>> uniquePairs = new HashSet<>(result);
        result = new ArrayList<>(uniquePairs);

        return result;
    }

    // Helper function to check if a string is a palindrome
    private boolean isPalindrome(String word) {
        int left = 0, right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
