public class Solution {
    public String longestPalindrome(String s) {
        // Preprocess the string to handle even-length palindromes
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (char c : s.toCharArray()) {
            sb.append(c).append("#");
        }
        String t = sb.toString();
        int n = t.length();
        int[] p = new int[n]; // Array to hold the lengths of palindromes
        int center = 0, right = 0;

        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i; // Get the mirror index of i

            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Attempt to expand the palindrome centered at i
            int a = i + (1 + p[i]);
            int b = i - (1 + p[i]);
            while (a < n && b >= 0 && t.charAt(a) == t.charAt(b)) {
                p[i]++;
                a++;
                b--;
            }

            // Update center and right if the palindrome expands beyond right
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        // Find the maximum length of the palindrome
        int maxLength = 0;
        int centerIndex = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] > maxLength) {
                maxLength = p[i];
                centerIndex = i;
            }
        }

        // Extract the longest palindromic substring from the original string
        int start = (centerIndex - maxLength) / 2; // Convert index back to original string
        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "babad";
        System.out.println(solution.longestPalindrome(input)); // Output: "bab" or "aba"
    }
}
//Time complexity O(n)
//Space Complexity O(n)
