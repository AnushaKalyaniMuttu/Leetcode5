public class Solution {
    public int myAtoi(String s) {
        s = s.trim(); // Remove leading whitespace
        if (s.isEmpty()) {
            return 0; // Return 0 if the string is empty
        }

        int index = 0, sign = 1, result = 0;
        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;

        // Check for sign
        if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }

        // Convert characters to integer
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // Check for overflow
            if (result > (maxInt - digit) / 10) {
                return sign == 1 ? maxInt : minInt;
            }

            result = result * 10 + digit;
            index++;
        }

        return sign * result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "   -42";
        int output = solution.myAtoi(input);
        System.out.println(output); // Output: -42
    }
}
