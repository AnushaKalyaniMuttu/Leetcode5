public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        int n = s.length();
        int[] dp = new int[n + 1];
        
        dp[0] = 1; // Base case: empty string
        dp[1] = (s.charAt(0) != '0') ? 1 : 0; // First character should not be '0'

        for (int i = 2; i <= n; i++) {
            // Check last single digit
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }
            
            // Check last two digits
            int twoDigits = Integer.valueOf(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "226";
        int result = solution.numDecodings(s);
        System.out.println(result); // Output: 3
    }
}
