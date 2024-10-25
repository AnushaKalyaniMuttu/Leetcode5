public class PalindromeNumber7 {
    public boolean isPalindrome(int x) {
        // Negative numbers and numbers ending with 0 (except for 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedNumber = 0;
        while (x > reversedNumber) {
            reversedNumber = reversedNumber * 10 + x % 10; // Append the last digit of x
            x /= 10; // Remove the last digit from x
        }

        // x can be equal to reversedNumber (even length) or without the middle digit (odd length)
        return x == reversedNumber || x == reversedNumber / 10;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = 121;
        System.out.println(solution.isPalindrome(number)); // Output: true

        number = -121;
        System.out.println(solution.isPalindrome(number)); // Output: false

        number = 10;
        System.out.println(solution.isPalindrome(number)); // Output: false
    }
}

//time Complexity O(log 10(n))
//Space Complexity O(1)
