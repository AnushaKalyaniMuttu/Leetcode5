public class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers and numbers ending with zero (except 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int reversed = 0;
        int original = x;

        // Reverse the number
        while (x > 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }





        // Check if the original number is the same as the reversed number
        return original == reversed;
    }
}
