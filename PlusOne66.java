class PlusOne66 {
     public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Start from the last digit and work backwards
        for (int i = n - 1; i >= 0; i--) {
            // If the digit is less than 9, we can simply add one and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // Set the current digit to 0 and continue to the next digit
            digits[i] = 0;
        }
        
        // If all digits were 9, we need an extra space for the new number
        int[] result = new int[n + 1];
        result[0] = 1; // The first digit is 1 followed by all 0s
        return result;
    }
}
/*
Time and Space Complexity
•	Time Complexity: O(n), where n is the number of digits. In the worst case, we may need to iterate through all digits once.
•	Space Complexity: O(1) if we ignore the space needed for the result array in the case of all digits being 9. If not, we only allocate a new array in that specific case.
*/
