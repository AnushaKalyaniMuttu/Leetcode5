public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Expand around single character (odd length)
            int len1 = expandAroundCenter(s, i, i);
            // Expand around two characters (even length)
            int len2 = expandAroundCenter(s, i, i + 1);
            int maxLen = Math.max(len1, len2);

            // Update the start and end indices of the longest palindrome found
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Length of the palindrome
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "babad";
        System.out.println(solution.longestPalindrome(input)); // Output: "bab" or "aba"
    }
}
//time Complexity O(n2)
