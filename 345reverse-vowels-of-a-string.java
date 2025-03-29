public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;

        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        // Set of vowels for quick lookup
        String vowels = "aeiouAEIOU";

        while (left < right) {
            // Move left pointer until it points to a vowel
            while (left < right && vowels.indexOf(chars[left]) == -1) {
                left++;
            }

            // Move right pointer until it points to a vowel
            while (left < right && vowels.indexOf(chars[right]) == -1) {
                right--;
            }

            // Swap the vowels
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            // Move pointers closer
            left++;
            right--;
        }

        return new String(chars);
    }
}
