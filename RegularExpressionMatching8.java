public class RegularExpressionMatching8 {
    public boolean isMatch(String s, String p) {
        // Initialize the DP table
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true; // Empty string and empty pattern match

        // Handle patterns like a*, a*b*, a*b*c* at the beginning
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill the DP table
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                if (pChar == '.' || pChar == sChar) {
                    dp[i][j] = dp[i - 1][j - 1]; // Match current characters
                } else if (pChar == '*') {
                    dp[i][j] = dp[i][j - 2] || (matches(sChar, p.charAt(j - 2)) && dp[i - 1][j]);
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    private boolean matches(char sChar, char pChar) {
        return pChar == '.' || sChar == pChar;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aab";
        String p = "c*a*b";
        System.out.println(solution.isMatch(s, p)); // Output: true
    }
}
